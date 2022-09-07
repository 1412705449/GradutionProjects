<#include "head.html">
<#--后台作者管理页面-->

<div class="x-nav">
            <span class="layui-breadcrumb">
              <a><cite>首页</cite></a>
              <a><cite>作者管理</cite></a>
              <a><cite>作者列表</cite></a>
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
                用户名
            </th>

            <th>
                加入时间
            </th>
            <th>
                状态
            </th>
            <th>
                操作
            </th>
        </tr>
        </thead>
        <tbody>
        <#list authorlist as author>
            <tr>

                <td>
                    ${author.id}
                </td>
                <td>
                    ${author.username}
                </td>
                <td>
                    ${author.create_time}
                </td>

                    <#if author.judgment==1>
                <td>
                        正常
                </td>
                    <#else>
                <td>
                        冻结
                </td>
                    </#if>
                <td class="td-manage">
                    <a title="修改" href="javascript:;" onclick="admin_upd(this,${author.id})"
                       style="text-decoration:none">
                        <i class="layui-icon">修改</i>
                    </a>
                </td>
            </tr>
        </#list>
        </tbody>
    </table>

</div>

<#include "footer.html">

<script language="JavaScript">
    layui.use(['laydate','element','laypage','layer'], function(){
        $ = layui.jquery;//jquery

        lement = layui.element();//面包导航

        layer = layui.layer;//弹出层

        //以上模块根据需要引入

    });

    /*修改*/
    function admin_upd(obj,id){
        layer.confirm('确认要修改吗？',function(index){
            //发异步删除数据
            $.post("authorupd",{"id":id},function (data) {
                if(JSON.parse(data).code==200){
                    layer.msg('已修改!',{icon:1,time:1000});
                    location.replace(location.href);
                }else{
                    layer.msg("修改失败")
                }

            })

        });
    }
</script>
