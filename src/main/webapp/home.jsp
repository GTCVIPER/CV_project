<%--
  Created by IntelliJ IDEA.
  User: 52252
  Date: 2021/12/15
  Time: 11:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>党员管理系统-教师端</title>
        <link rel="stylesheet" href="https://www.layuicdn.com/layui-v2.5.5/css/layui.css">
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo">党员管理系统-教师端</div>
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item">
                <a href="javascript:;">
                    <img src="http://t.cn/RCzsdCq" class="layui-nav-img">
                    GTC
                </a>
<%--                <dl class="layui-nav-child">--%>
<%--                    <dd><a href="">基本资料</a></dd>--%>
<%--                    <dd><a href="">安全设置</a></dd>--%>
<%--                </dl>--%>
<%--            </li>--%>
<%--            <li class="layui-nav-item"><a href="">退了</a></li>--%>
        </ul>
    </div>

    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
            <ul class="layui-nav layui-nav-tree" lay-filter="test">
                <%--        <li class="layui-nav-item"><a href="javascript:;" onclick="onforward('sys/01.jsp')">客户管理</a></li>--%>
                <li class="layui-nav-item"><a href="javascript:;" onclick="onforward('/01.jsp')">入党申请表管理</a></li>
                <li class="layui-nav-item"><a href="javascript:;" onclick="onforward('/02.jsp')">审核管理</a></li>
                <li class="layui-nav-item">
                    <a href="javascript:;" onclick="onforward('/03.jsp')">考核管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:;" onclick="onforward('/05.jsp')">模范先锋管理</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item"><a href="javascript:;" onclick="onforward('/04.jsp')">交流园地管理</a></li>
                <li class="layui-nav-item"><a href="javascript:;" onclick="onforward('/06.jsp')">学生管理</a></li>
            </ul>
        </div>
    </div>

    <div class="layui-body" id="main">
        <!-- 内容主体区域 -->

<div class="layui-footer">
    <!-- 底部固定区域 -->
    © 党员管理系统 - 底部固定区域
</div>
</div>
<script src="https://www.layuicdn.com/layui-v2.5.5/layui.js"></script>
<%--<script src="${pageContext.request.contextPath}/layui/jquery-1.10.2.min.js"></script>--%>
<script>

    layui.use('element', function(){
        var element = layui.element;
        window.jQuery = window.$ = layui.jquery;
    });

    function onforward(url) {
        // location.href = url
        $("#main").load(url)
    }

</script>

</body>
</html>
