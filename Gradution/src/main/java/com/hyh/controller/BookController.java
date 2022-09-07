package com.hyh.controller;

import com.hyh.entity.Barrage;
import com.hyh.entity.Chapter;
import com.hyh.entity.Store;
import com.hyh.entity.User;
import com.hyh.service.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class BookController {
    @Autowired
    UserService userService;
    @Autowired
    private ChapterService chapterService;
    @Autowired
    private StoreService storeService;
    @Autowired
    private BarrageService barrageService;
    @Autowired
    private BookshelfService bookshelfService;
    @Autowired
    private MessageService messageService;
    /**
     * 小说所有章节页
     */
    @RequestMapping("/book/{id}/index")
    public String index(@PathVariable String id, Model model){
        Store store = storeService.findId(id);
        List<Chapter> all = chapterService.findAll(Integer.parseInt(id));
        model.addAttribute("chatlist",all);
        model.addAttribute("store",store);
        return "chapts";
    }

    /**
     * 小说章节内容
     */
    @RequestMapping("/book/{id}/{cid}")
    public String book(@PathVariable String id,@PathVariable String cid,Model model){
        Store store = storeService.findId(id);
        Chapter chapter = chapterService.findId(Integer.parseInt(id), Integer.parseInt(cid));
        List<Chapter> near = chapterService.findNear(id, chapter.getOrder() - 1, chapter.getOrder() + 1);
        chapter.setContent(chapter.getContent().trim() .split("\\s")[0].replaceFirst("　　","  ").replaceAll("　　","<br/><br/>"));
        int last=-1;
        int next =-1;
        for(Chapter chapter1 :near){
            if(chapter1.getOrder()>chapter.getOrder()){
                next=chapter1.getId();
            }
            if(chapter1.getOrder()<chapter.getOrder()){
                last=chapter1.getId();
            }
        }


       model.addAttribute("last",last);
       model.addAttribute("next",next);
        model.addAttribute("store",store);
        model.addAttribute("chapter",chapter);
        return "book";
    }

    /**
     * 增加弹幕
     */
    @RequestMapping(value = "/book/sendBullet",method = RequestMethod.POST)
    @ResponseBody
    public String sendBullet(@RequestParam("chapid")String chapid,@RequestParam("content")String content){
        barrageService.Add(chapid,content,Long.toString(new Date().getTime()));
        return "{\"code\": 1, \"desc\": \"ok\"}";
    }
    /**
     * 查询所有弹幕
     */
    @RequestMapping(value = "/book/queryBullet",method = RequestMethod.POST)
    @ResponseBody
    public String queryBullet(@RequestParam("chapid")String chapid){

        StringBuffer res=new StringBuffer();
        res.append("[");
        List<Barrage> all = barrageService.findAll(chapid);
        int index=0;
        for(Barrage barrage:all){
            index++;
            res.append(barrage.toJson());

            if(index<all.size()){
               res.append(",");
            }
        }
        res.append("]");
        if("".equals(res.toString())){
            return "{}";
        }
        return res.toString();
    }

    @RequestMapping(value = "/book/search",method = RequestMethod.GET)
    public String search(@RequestParam(value = "catId",defaultValue = "-1")String catId,@RequestParam(value = "curr",defaultValue = "1")String curr,@RequestParam(value = "keyword",defaultValue = "-1")String keyword,@RequestParam(value = "uid",defaultValue = "-1")String uid,Model model){
        /**
         * 查找个人书架
         */
        if(!"-1".equals(uid)){
            List<Store> aLl = bookshelfService.findALl(Integer.parseInt(uid));
            for(int i=0;i<aLl.size();i++){
                aLl.get(i).setNewtime(new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date(Long.parseLong(aLl.get(i).getNewtime()))));
            }
            model.addAttribute("typeses","我的书架");
            model.addAttribute("storelist",aLl);
            model.addAttribute("siteurl","https://www.biqudao.com");
            model.addAttribute("last",0);
            model.addAttribute("next",0);
           // model.addAttribute("catId",catId);
            return "serarch";
        }
        /**
         * 查找指定类型小说
         */
        if(!"-1".equals(catId)){
            String typename=null;
            switch (catId){
                case "1":typename="玄幻奇幻";break;
                case "2":typename="武侠仙侠";break;
                case "3":typename="都市言情";break;
                case "4":typename="历史军事";break;
                case "5":typename="科幻灵异";break;
                case "6":typename="网游竞技";break;
                case "7":typename="女频频道";break;
                default:
                    return "serarch";
            }
            if("-1".equals(keyword)){

                int i = Integer.parseInt(curr);

                List<Store> storess = storeService.findTypeNmae(typename,--i*10);
                Integer sum = storeService.findSum(typename);
                model.addAttribute("typeses",typename+"频道");
                model.addAttribute("storelist",storess);
                model.addAttribute("siteurl","https://www.biqudao.com");
                model.addAttribute("last",i);
                if(sum>++i*10){
                    model.addAttribute("next",i+1);
                }else{
                    model.addAttribute("next",0);
                }
                model.addAttribute("catId",catId);
                return "serarch";
            }else{
                /**
                 * 查找指定类型名字或者作者小说
                 */
                List<Store> typeStore = storeService.findTypeStore(typename, keyword);
                model.addAttribute("typeses",typename+"频道");
                model.addAttribute("storelist",typeStore);
                model.addAttribute("siteurl","https://www.biqudao.com");
                model.addAttribute("last",0);
                model.addAttribute("next",0);
                model.addAttribute("catId",catId);
            }


        }
        if(!"-1".equals(keyword)){
            List<Store> stores = storeService.findName(keyword);
           model.addAttribute("typeses","搜索");
            model.addAttribute("storelist",stores);
            model.addAttribute("siteurl","https://www.biqudao.com");
            model.addAttribute("last",0);
            model.addAttribute("next",0);
            return "serarch";
        }

        return "serarch";
    }
    //添加书到书架
    @RequestMapping(value = "/book/addbookshelf",method = RequestMethod.POST)
    @ResponseBody
    public String addBookshelf(@RequestParam("uid")String uid,@RequestParam("store_id")String store_id){
         if(bookshelfService.findN(Integer.parseInt(uid),Integer.parseInt(store_id))==0){
            bookshelfService.addBook(Integer.parseInt(uid),Integer.parseInt(store_id),Long.toString(new Date().getTime()));
        }
        return "{\"code\":200}";
    }
//    修改评分
    @PostMapping("book/update_score")
    @ResponseBody
    public String update_score(@Param("store_id") int store_id, @Param("username")String username,Integer value){
        User name1 = userService.findName(username);
        double score=0.0;
        if(name1!=null){
           switch (value){
               case 0: score=0.0 ;break;
               case 1: score=2.0 ;break;
               case 2: score=4.0 ;break;
               case 3: score=6.0 ;break;
               case 4: score=8.0 ;break;
               case 5: score=10.0 ;break;
           }
            Store store = storeService.findById(store_id);
            double newScore = (score+store.getScore())/2;
            java.text.DecimalFormat   df=new   java.text.DecimalFormat("0.0");
            storeService.updateScore(Double.valueOf(df.format(newScore)),store_id);
            Store store1 = storeService.findById(store_id);
            return "{\"code\":200}";
        }else {
            return "{\"code\":250}";
        }
    }
}
