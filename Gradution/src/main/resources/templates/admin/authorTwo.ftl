<#include "head.html">
<#--后台作者管理页面-->

<div class="layui-layout layui-layout-admin">
    <div class="layui-header header header-demo">
        <div class="layui-main">
            <a class="logo" href="/admin/index">
                智行小说管理系统
            </a>

        </div>
    </div>
    <div class="layui-side layui-bg-black x-side">
        <div class="layui-side-scroll">
            <ul class="layui-nav layui-nav-tree site-demo-nav" lay-filter="side">

                <li class="layui-nav-item">
                    <a class="javascript:;" href="javascript:;">
                        <i class="layui-icon" style="top: 3px;">&#xe642;</i><cite>作者管理</cite>
                    </a>
                    <dl class="layui-nav-child">
                        <dd class="">
                        <dd class="">
                            <a href="javascript:;" _href="classifyAll">
                                <cite>上传小说</cite>
                            </a>
                        </dd>
                        </dd>
                        <dd class="">
                        <dd class="">
                            <a href="javascript:;" _href="authorUpdate">
                                <cite>更新小说</cite>
                            </a>
                        </dd>
                        </dd>
                    </dl>
                </li>

                <li class="layui-nav-item" style="height: 30px; text-align: center">
                </li>
            </ul>
        </div>

    </div>
    <div class="layui-tab layui-tab-card site-demo-title x-main" lay-filter="x-tab" lay-allowclose="true">
        <div class="x-slide_left"></div>
        <ul class="layui-tab-title">
            <li class="layui-this">
                我的桌面
                <i class="layui-icon layui-unselect layui-tab-close">ဆ</i>
            </li>
        </ul>
        <div class="layui-tab-content site-demo site-demo-body">
            <div class="layui-tab-item layui-show">
                <iframe frameborder="0" src="./welcom" class="x-iframe"></iframe>
            </div>
        </div>
    </div>
    <div class="site-mobile-shade">
    </div>
</div>
<#include "footer.html">