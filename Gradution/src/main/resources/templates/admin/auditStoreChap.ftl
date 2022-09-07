<#include "head.html">
<#--后台小说章节审核页面-->
<div class="x-nav">
            <span class="layui-breadcrumb">
              <a><cite>首页</cite></a>
              <a><cite>会员管理</cite></a>
              <a><cite>小说列表</cite></a>
            </span>
    <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right"  href="javascript:location.replace(location.href);" title="刷新"><i class="layui-icon" style="line-height:30px">ဂ</i></a>
</div>
<div class="x-body">

    <table class="layui-table">
        <thead>
        <tr>
            <th>
                ID
            </th>
            <th>
                章节名
            </th>
            <th>
                审核状态
            </th>
            <th>
                最近更新时间
            </th>
            <th>
                审核
            </th>
        </tr>
        </thead>
        <tbody>
        <#list auditlist as audit>
            <#if audit.storeChap==1>
            <tr>

                <td>
                    ${audit.order}
                </td>
                <td>
                    ${audit.chap}
                </td>

                <#if audit.judgment==0>
                    <td>
                        未定
                    </td>
                <#elseif audit.judgment==1>
                    <td>
                        通过
                    </td>
                <#elseif audit.judgment==2>
                    <td>
                        拒绝
                    </td>
                </#if>
                <td>
                    ${audit.create_time}
                </td>
                <td class="td-manage">
                    <a title="通过" href="javascript:;" onclick="admin_OK(this,${audit.id})"
                       style="text-decoration:none">
                        <i class="layui-icon">通过</i>
                    </a>
                    <a title="拒绝" href="javascript:;" onclick="admin_NO(this,${audit.id})"
                       style="text-decoration:none">
                        <i class="layui-icon">拒绝</i>
                    </a>
                </td>
            </tr>
            </#if>
        </#list>
        </tbody>
    </table>

</div>

<#--<div id="books" style="text-align: center">-->
<#--    <div class="layui-box layui-laypage layui-laypage-default" id="layui-laypage-9">-->
<#--        <#if last==-1>-->
<#--            <a href="javascript:void(0);" class="layui-laypage-prev layui-disabled" data-page="${last}">上一页</a>-->
<#--        <#else>-->
<#--            <a href="/admin/store?start=${last}" class="layui-laypage-prev " data-page="${last}">上一页</a>-->
<#--        </#if>-->
<#--        <#if next==-1>-->
<#--            <a href="javascript:void(0);" class="layui-laypage-next layui-disabled" data-page="${next}">下一页</a>-->
<#--        <#else>-->
<#--            <a href="/admin/store?start=${next}" class="layui-laypage-next" data-page="${next}">下一页</a>-->
<#--        </#if>-->

<#--    </div>-->
<#--</div>-->
<#include "footer.html">

<script>
    layui.use(['laydate','element','laypage','layer'], function(){
        $ = layui.jquery;//jquery
        laydate = layui.laydate;//日期插件
        lement = layui.element();//面包导航
        laypage = layui.laypage;//分页
        layer = layui.layer;//弹出层

        //以上模块根据需要引入

    });
    /*通过*/
    function admin_OK(obj,id){
        layer.confirm('确认要同意吗？',function(index){
            //发异步删除数据
            $.post("/author/addScoreChapOK",{"id":id},function (data) {
                if(JSON.parse(data).code==200){
                    layer.msg('已同意!',{icon:1,time:1000});
                    location.replace(location.href);
                }else{
                    layer.msg("同意失败")
                }

            })

        });
    }
    /*拒绝*/
    function admin_NO(obj,id){
        layer.confirm('确认要拒绝吗？',function(index){
            //发异步删除数据
            $.post("/author/addScoreChapNO",{"id":id},function (data) {
                if(JSON.parse(data).code==200){
                    layer.msg('已拒绝!',{icon:1,time:1000});
                    location.replace(location.href);
                }else{
                    layer.msg("拒绝失败")
                }

            })

        });
    }
</script>
