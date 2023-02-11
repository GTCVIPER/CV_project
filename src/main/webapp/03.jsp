<%--
  Created by IntelliJ IDEA.
  User: 52252
  Date: 2021/1/3
  Time: 17:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>党员管理系统-教师端</title>
<%--    <link rel="stylesheet" href="https://www.layuicdn.com/layui-v2.5.5/css/layui.css">--%>
</head>
<body>
<%--<body class="layui-layout-body">--%>
<%--<div class="layui-layout layui-layout-admin">--%>
<%--    <div class="layui-header">--%>
<%--        <div class="layui-logo">党员管理系统-教师端</div>--%>
<%--        <ul class="layui-nav layui-layout-right">--%>
<%--            <li class="layui-nav-item">--%>
<%--                <a href="javascript:;">--%>
<%--                    <img src="http://t.cn/RCzsdCq" class="layui-nav-img">--%>
<%--                    贤心--%>
<%--                </a>--%>
<%--                <dl class="layui-nav-child">--%>
<%--                    <dd><a href="">基本资料</a></dd>--%>
<%--                    <dd><a href="">安全设置</a></dd>--%>
<%--                </dl>--%>
<%--            </li>--%>
<%--            <li class="layui-nav-item"><a href="">退了</a></li>--%>
<%--        </ul>--%>
<%--    </div>--%>

<%--    <div class="layui-side layui-bg-black">--%>
<%--        <div class="layui-side-scroll">--%>
<%--            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->--%>
<%--            <ul class="layui-nav layui-nav-tree" lay-filter="test">--%>
<%--                &lt;%&ndash;        <li class="layui-nav-item"><a href="javascript:;" onclick="onforward('sys/01.jsp')">客户管理</a></li>&ndash;%&gt;--%>
<%--                <li class="layui-nav-item"><a href="javascript:;" onclick="onforward('/01.jsp')">入党申请表管理</a></li>--%>
<%--                <li class="layui-nav-item"><a href="javascript:;" onclick="onforward('/02.jsp')">审核管理</a></li>--%>
<%--                    <li class="layui-nav-item">--%>
<%--                        <a href="javascript:;" onclick="onforward('/03.jsp')">考核管理</a>--%>
<%--                        <dl class="layui-nav-child">--%>
<%--                            <dd><a href="javascript:;" onclick="onforward('/05.jsp')">模范先锋管理</a></dd>--%>
<%--                        </dl>--%>
<%--                    </li>--%>
<%--                <li class="layui-nav-item"><a href="javascript:;" onclick="onforward('/04.jsp')">交流园地管理</a></li>--%>
<%--                <li class="layui-nav-item"><a href="javascript:;" onclick="onforward('/06.jsp')">学生管理</a></li>--%>
<%--            </ul>--%>
<%--        </div>--%>
<%--    </div>--%>

<%--    <div class="layui-body" id="main">--%>
<%--        <!-- 内容主体区域 -->--%>
        <div style="padding: 15px;">


            <div class="demoTable">
                搜索ID：
                <div class="layui-inline">
                    <input class="layui-input" name="sId" id="demoReload" autocomplete="off">
                </div>
                <button class="layui-btn" data-type="reload">搜索</button>
            </div>

            <table class="layui-hide" id="demo" lay-filter="test"></table>

            <script type="text/html" id="toolbarDemo">
                <div class="layui-btn-container">
                    <button class="layui-btn layui-btn-sm" lay-event="insert"><i class="layui-icon">&#xe654;</i> 添加
                    </button>
                    <button class="layui-btn layui-btn-sm layui-btn-danger" lay-event="delete"><i class="layui-icon">&#xe640;</i>
                        删除
                    </button>
                </div>
            </script>

            <script type="text/html" id="barDemo">
                <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
            </script>
            <script>

            </script>
            <script type="text/html" id="student-edit-layer">
                <form action="" method="post" id="student-edit-form" style="width: 80%" class="layui-form"
                      lay-filter="student-edit-form">
                    <input type="hidden" name="sId">
                    <div class="layui-form-item">
                        <label class="layui-form-label">班级职务</label>
                        <div class="layui-input-block">
                            <label>
                                <input type="text" name="eCareer" required lay-verify="required" placeholder="请输入班级职务"
                                       autocomplete="off" class="layui-input">
                            </label>
                        </div>
                    </div>

                    <div class="layui-form-item">
                        <label class="layui-form-label">群众意见打分分数</label>
                        <div class="layui-input-block">
                            <label>
                                <input type="number" name="eMass" required lay-verify="required" placeholder="请输入群众意见打分分数"
                                       autocomplete="off" class="layui-input">
                            </label>
                        </div>
                    </div>

                    <div class="layui-form-item">
                        <label class="layui-form-label">辅导员意见打分分数</label>
                        <div class="layui-input-block">
                            <label>
                                <input type="number" name="eCounsellor" required lay-verify="required" placeholder="请输入辅导员意见打分分数"
                                       autocomplete="off" class="layui-input">
                            </label>
                        </div>
                    </div>

                    <div class="layui-form-item">
                        <label class="layui-form-label">支部书记意见打分分数</label>
                        <div class="layui-input-block">
                            <label>
                                <input type="number" name="eSecretary" required lay-verify="required" placeholder="请输入支部书记意见打分分数"
                                       autocomplete="off" class="layui-input">
                            </label>
                        </div>
                    </div>

                    <div class="layui-form-item">
                        <label class="layui-form-label">先锋模范总分</label>
                        <div class="layui-input-block">
                            <label>
                                <input type="number" name="eGrade" required lay-verify="required" placeholder="请输入先锋模范总分"
                                       autocomplete="off" class="layui-input">
                            </label>
                        </div>
                    </div>

                </form>
            </script>
            <script type="text/html" id="student-add-layer">
                <form action="" method="post" id="coustomer-add-form" style="width: 80%" class="layui-form"
                      lay-filter="student-edit-form">

                    <div class="layui-form-item">
                        <label class="layui-form-label">学生 ID</label>
                        <div class="layui-input-block">
                            <select name="sId" lay-verify="required">
                                <option value=""></option>
                                <c:forEach items="${stus}" var="stu">
                                    <option value="${stu}">${stu}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>

<%--                    <div class="layui-form-item">--%>
<%--                        <label class="layui-form-label">学生 ID</label>--%>
<%--                        <div class="layui-input-block">--%>
<%--                            <label>--%>
<%--                                <input type="text" name="sId" required lay-verify="required" placeholder="请输入学生账号"--%>
<%--                                       autocomplete="off" class="layui-input">--%>
<%--                            </label>--%>
<%--                        </div>--%>
<%--                    </div>--%>
                    <div class="layui-form-item">
                        <label class="layui-form-label">班级职务</label>
                        <div class="layui-input-block">
                            <label>
                                <input type="text" name="eCareer" required lay-verify="required" placeholder="请输入班级职务"
                                       autocomplete="off" class="layui-input">
                            </label>
                        </div>
                    </div>

                    <div class="layui-form-item">
                        <label class="layui-form-label">群众意见打分分数</label>
                        <div class="layui-input-block">
                            <label>
                                <input type="number" name="eMass" required lay-verify="required" placeholder="请输入群众意见打分分数"
                                       autocomplete="off" class="layui-input">
                            </label>
                        </div>
                    </div>

                    <div class="layui-form-item">
                        <label class="layui-form-label">辅导员意见打分分数</label>
                        <div class="layui-input-block">
                            <label>
                                <input type="number" name="eCounsellor" required lay-verify="required" placeholder="请输入辅导员意见打分分数"
                                       autocomplete="off" class="layui-input">
                            </label>
                        </div>
                    </div>

                    <div class="layui-form-item">
                        <label class="layui-form-label">支部书记意见打分分数</label>
                        <div class="layui-input-block">
                            <label>
                                <input type="number" name="eSecretary" required lay-verify="required" placeholder="请输入支部书记意见打分分数"
                                       autocomplete="off" class="layui-input">
                            </label>
                        </div>
                    </div>

                    <div class="layui-form-item">
                        <label class="layui-form-label">先锋模范总分</label>
                        <div class="layui-input-block">
                            <label>
                                <input type="number" name="eGrade" required lay-verify="required" placeholder="请输入先锋模范总分"
                                       autocomplete="off" class="layui-input">
                            </label>
                        </div>
                    </div>

                </form>
            </script>

        </div>
    </div>

    <div class="layui-footer">
        <!-- 底部固定区域 -->
        © GTC.com - 底部固定区域
    </div>
</div>
<%--<script src="https://www.layuicdn.com/layui-v2.5.5/layui.js"></script>--%>
<%--<script src="${pageContext.request.contextPath}/layui/jquery-1.10.2.min.js"></script>--%>
<script>

    //JavaScript代码区域
    layui.use(['table', 'layer', 'form', 'element', 'jquery'], function () {
        // var element = layui.element;
        // window.jQuery = window.$ = layui.jquery;
        var table = layui.table;
        var layer = layui.layer;
        var form = layui.form;
        form.render()
        table.render({
            elem: '#demo',
            id: 'demo'
            , url: '/exam/examList'
            , toolbar: '#toolbarDemo' //开启头部工具栏，并为其绑定左侧模板
            , defaultToolbar: ['filter', 'exports', 'print', { //自定义头部工具栏右侧图标。如无需自定义，去除该参数即可
                title: '提示'
                , layEvent: 'LAYTABLE_TIPS'
                , icon: 'layui-icon-tips'
            }]
            , title: '客户数据表'
            , cols: [[
                {type: 'checkbox', fixed: 'left'}
                , {field: 'sId', title: 'ID', width: 100, fixed: 'left', unresize: true, sort: true}
                , {field: 'eCareer', title: '班级职务', width: 120, edit: 'text'}
                , {field: 'eMass', title: '群众意见打分分数', width: 110,sort: true}
                , {field: 'eCounsellor', title: '辅导员意见打分分数', width: 180, edit: 'text',sort: true}

                , {field: 'eSecretary', title: '支部书记意见打分分数', width: 130,sort: true}
                , {field: 'eGrade', title: '先锋模范总分', width: 130,sort: true}

                , {fixed: 'right', title: '操作', toolbar: '#barDemo', width: 250}
            ]]
            , page: {
                limit: 5
                , limits: [1, 2, 3, 4, 5]
                , first: '首页'
                , last: '尾页'
                , prev: '<i class="layui-icon layui-icon-prev"></i>'
                , next: '<i class="layui-icon layui-icon-next"></i>'
                , layout: ['prev', 'page', 'next', 'count', 'limit', 'skip', 'refresh']
            }//开启分页
        });

        //头工具栏事件
        table.on('toolbar(test)', function (obj) {
            switch (obj.event) {
                case 'insert':
                    openEditWindow(null);
                    break;
                case 'delete':
                    var data = table.checkStatus("demo").data;
                    if (data.length > 0) {
                        layer.confirm('真的要删除行吗？', function (index) {
                            var params = '';
                            $.each(data, function (i, obj) {
                                params += '&sIds=' + obj.sId
                            })
                            $.ajax({
                                url: '/exam/examDels',
                                data: params,
                                method: 'post',
                                success: function (result) {
                                    if (result.status) {
                                        table.reload('demo', {});
                                    } else {
                                        layer.alert(result.message)
                                    }
                                    layer.close(index);
                                }
                            })
                        })
                    }
                    break;
            }
        });
        //编辑按钮事件
        table.on('tool(test)', function (obj) {
            var data = obj.data;//用于在编辑页面回显的数据

            switch (obj.event) {
                case 'edit': {
                    //打开编辑窗口
                    openEditWindow(data);
                    break;
                }
            }
        })

        function openEditWindow(data) {
            layer.open({
                type: 1,
                content: data == null ? $('#student-add-layer').html() : $('#student-edit-layer').html(),
                title: '编辑',
                area: ['500px', '400px'],
                btn: ['提交', '取消'],//可以添加无限个按钮
                yes: function (index, layero) {
                    layer.load();
                    $.ajax({
                        url: '/exam/exam' + (data == null ? 'Add' : 'Update'),
                        data: data == null ? $('#coustomer-add-form').serialize() : $('#student-edit-form').serialize(),
                        method: 'post',
                        success: function (result) {
                            if (result.status) {
                                layer.msg(result.message)
                                table.reload('demo', {});
                                layer.close(index);
                            } else {
                                layer.alert(result.message)
                            }
                            layer.close(index);
                            layer.closeAll('loading');
                        }
                    })
                },
                success: function (layero, index) {
                    form.render()
                    if (data != null) {
                        form.val('student-edit-form', data);
                        form.val('student-edit-form', {
                            "state": data.state + ""
                        });
                    }
                    // layer.close(index);
                }
            })
        }

        var $ = layui.$, active = {
            reload: function () {
                var demoReload = $('#demoReload');

                //执行重载
                table.reload('demo', {
                    page: {
                        curr: 1 //重新从第 1 页开始
                    }
                    , where: {
                        sId: demoReload.val()
                    }
                });
            }
        };

        $('.demoTable .layui-btn').on('click', function () {
            var type = $(this).data('type');
            active[type] ? active[type].call(this) : '';
        });

    });

    // function onforward(url) {
    //     // location.href = url
    //
    //     $("#main").load(url)
    // }

</script>

</body>
</html>