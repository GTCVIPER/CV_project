<%--
  Created by IntelliJ IDEA.
  User: 52252
  Date: 2021/1/3
  Time: 17:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>党员管理系统-教师端</title>
<%--    <link rel="stylesheet" href="https://www.layuicdn.com/layui-v2.5.5/css/layui.css">--%>
</head>
<%--<body class="layui-layout-body">--%>
<body>
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
<%--                <li class="layui-nav-item">--%>
<%--                    <a href="javascript:;" onclick="onforward('/03.jsp')">考核管理</a>--%>
<%--                    <dl class="layui-nav-child">--%>
<%--                        <dd><a href="javascript:;" onclick="onforward('/05.jsp')">模范先锋管理</a></dd>--%>
<%--                    </dl>--%>
<%--                </li>--%>
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
                        <label class="layui-form-label">用户名</label>
                        <div class="layui-input-block">
                            <label>
                                <input type="text" name="sName" required lay-verify="required" placeholder="请输入学生姓名"
                                       autocomplete="off" class="layui-input">
                            </label>
                        </div>
                    </div>

                    <div class="layui-form-item">
                        <label class="layui-form-label">性别</label>
                        <div class="layui-input-block">
                            <input type="radio" name="sSex" title="男" value="男" checked/>
                            <input type="radio" name="sSex" title="女" value="女"/>
                        </div>
                    </div>

                    <div class="layui-form-item">
                        <label class="layui-form-label">民族</label>
                        <div class="layui-input-block">
                            <label>
                                <input type="text" name="sNation" required lay-verify="required" placeholder="请输入民族"
                                       autocomplete="off" class="layui-input">
                            </label>
                        </div>
                    </div>

                    <div class="layui-form-item">
                        <label class="layui-form-label">联系方式</label>
                        <div class="layui-input-block">
                            <label>
                                <input type="tel" name="sTel" required lay-verify="required" placeholder="请输入联系方式"
                                       autocomplete="off" class="layui-input">
                            </label>
                        </div>
                    </div>

                    <div class="layui-form-item">
                        <label class="layui-form-label">政治面貌</label>
                        <div class="layui-input-block">
                            <label>
                                <input type="text" name="sPolitic" required lay-verify="required" placeholder="请输入政治面貌"
                                       autocomplete="off" class="layui-input">
                            </label>
                        </div>
                    </div>

                    <div class="layui-form-item">
                        <label class="layui-form-label">学生状态</label>
                        <div class="layui-input-block">
                            <input type="radio" name="sState" title="入党申请人" value="0" checked/>
                            <input type="radio" name="sState" title="积极分子" value="1"/>
                            <input type="radio" name="sState" title="发展对象" value="2"/>
                            <input type="radio" name="sState" title="预备党员" value="3"/>
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
                            <label>
                                <input type="text" name="sId" required lay-verify="required" placeholder="请输入学生账号"
                                       autocomplete="off" class="layui-input">
                            </label>
                        </div>
                    </div>

                    <div class="layui-form-item">
                        <label class="layui-form-label">用户名</label>
                        <div class="layui-input-block">
                            <label>
                                <input type="text" name="sName" required lay-verify="required" placeholder="请输入学生姓名"
                                       autocomplete="off" class="layui-input">
                            </label>
                        </div>
                    </div>

                    <div class="layui-form-item">
                        <label class="layui-form-label">密码</label>
                        <div class="layui-input-block">
                            <label>
                                <input type="password" name="sPassword" required lay-verify="required" placeholder="请输入学生初始密码"
                                       autocomplete="off" class="layui-input">
                            </label>
                        </div>
                    </div>

                    <div class="layui-form-item">
                        <label class="layui-form-label">性别</label>
                        <div class="layui-input-block">
                            <input type="radio" name="sSex" title="男" value="男" checked/>
                            <input type="radio" name="sSex" title="女" value="女"/>
                        </div>
                    </div>


                    <div class="layui-form-item">
                        <label class="layui-form-label">民族</label>
                        <div class="layui-input-block">
                            <label>
                                <input type="text" name="sNation" required lay-verify="required" placeholder="请输入民族"
                                       autocomplete="off" class="layui-input">
                            </label>
                        </div>
                    </div>


                    <div class="layui-form-item">
                        <label class="layui-form-label">联系方式</label>
                        <div class="layui-input-block">
                            <label>
                                <input type="tel" name="sTel" required lay-verify="required" placeholder="请输入联系方式"
                                       autocomplete="off" class="layui-input">
                            </label>
                        </div>
                    </div>

                    <div class="layui-form-item">
                        <label class="layui-form-label">政治面貌</label>
                        <div class="layui-input-block">
                            <label>
                                <input type="text" name="sPolitic" required lay-verify="required" placeholder="请输入政治面貌"
                                       autocomplete="off" class="layui-input">
                            </label>
                        </div>
                    </div>

                    <div class="layui-form-item">
                        <label class="layui-form-label">学生状态</label>
                        <div class="layui-input-block">
                            <input type="radio" name="sState" title="入党申请人" value="0" checked/>
                            <input type="radio" name="sState" title="积极分子" value="1"/>
                            <input type="radio" name="sState" title="发展对象" value="2"/>
                            <input type="radio" name="sState" title="预备党员" value="3"/>
                        </div>
                    </div>

                    <div class="layui-form-item">
                        <label class="layui-form-label">入学年份</label>
                        <div class="layui-input-block">
                            <label>
                                <input type="date" name="sRegister" required lay-verify="required" placeholder="请输入入学年份"
                                       autocomplete="off" class="layui-input">
                            </label>
                        </div>
                    </div>

                    <div class="layui-form-item">
                        <label class="layui-form-label">申请入党时间</label>
                        <div class="layui-input-block">
                            <label>
                                <input type="date" name="sApply" required lay-verify="required" placeholder="请输入申请入党时间"
                                       autocomplete="off" class="layui-input">
                            </label>
                        </div>
                    </div>

                    <div class="layui-form-item">
                        <label class="layui-form-label">确定积极分子时间</label>
                        <div class="layui-input-block">
                            <label>
                                <input type="date" name="sActivist" required lay-verify="required" placeholder="请输入确定积极分子时间"
                                       autocomplete="off" class="layui-input">
                            </label>
                        </div>
                    </div>

                    <div class="layui-form-item">
                        <label class="layui-form-label">确定发展对象时间</label>
                        <div class="layui-input-block">
                            <label>
                                <input type="date" name="sDevelop" required lay-verify="required" placeholder="请输入确定发展对象时间"
                                       autocomplete="off" class="layui-input">
                            </label>
                        </div>
                    </div>

                    <div class="layui-form-item">
                        <label class="layui-form-label">确定预备入党时间</label>
                        <div class="layui-input-block">
                            <label>
                                <input type="date" name="sProbationer" required lay-verify="required" placeholder="请输入确定预备入党时间"
                                       autocomplete="off" class="layui-input">
                            </label>
                        </div>
                    </div>

                    <div class="layui-form-item">
                        <label class="layui-form-label">确定为党员时间</label>
                        <div class="layui-input-block">
                            <label>
                                <input type="date" name="sCommunist" required lay-verify="required" placeholder="请输入确定为党员时间"
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
            , url: '/stu/stuList'
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
                , {field: 'sName', title: '姓名', width: 120, edit: 'text'}
                , {field: 'sSex', title: '性别', width: 110}
                , {field: 'sNation', title: '民族', width: 180, edit: 'text'}
                , {
                    field: 'sTel', title: '联系方式', width: 140, edit: 'text', templet: function (res) {
                        return '<em>' + res.sTel + '</em>'
                    }
                }
                , {field: 'sPolitic', title: '政治面貌', width: 130}
                , {
                    field: 'sRegister', title: '入学年份', width: 130, templet(date) {
                        if (date.sRegister != null && date.sRegister !== "") {
                            return layui.util.toDateString(date.sRegister, 'yyyy-MM-dd')
                        }
                    }
                }
                , {
                    field: 'sApply', title: '申请入党时间', width: 130, templet(date) {
                        if (date.sApply != null && date.sApply !== "") {
                            return layui.util.toDateString(date.sApply, 'yyyy-MM-dd')
                        }
                    }
                }
                , {
                    field: 'sActivist', title: '积极分子时间', width: 130, templet(date) {
                        if (date.sActivist != null && date.sActivist !== "") {
                            return layui.util.toDateString(date.sActivist, 'yyyy-MM-dd')
                        }
                    }
                }
                , {
                    field: 'sDevelop', title: '发展对象时间', width: 130, templet(date) {
                        if (date.sDevelop != null && date.sDevelop !== "") {
                            return layui.util.toDateString(date.sDevelop, 'yyyy-MM-dd')
                        }
                    }
                }
                , {
                    field: 'sProbationer', title: '确定入党时间', width: 130, templet(date) {
                        if (date.sProbationer != null && date.sProbationer !== "") {
                            return layui.util.toDateString(date.sProbationer, 'yyyy-MM-dd')
                        }
                    }
                }
                , {
                    field: 'sCommunist', title: '确定为党员时间', width: 130, templet(date) {
                        if (date.sCommunist != null && date.sCommunist !== "") {
                            return layui.util.toDateString(date.sCommunist, 'yyyy-MM-dd')
                        }
                    }
                }
                , {
                    field: 'sState', title: '状态', width: 180, templet(data) {
                        if (data.sState === 0) return '<span class="layui-badge layui-bg-cyan">入党申请人</span>'
                        else if (data.sState === 1) return '<span class="layui-badge layui-bg-red">积极分子</span>'
                        else if (data.sState === 2) return '<span class="layui-badge layui-bg-blue">发展对象</span>'
                        else if (data.sState === 3) return '<span class="layui-badge layui-bg-orange">预备党员</span>'
                        // return (data.sState==1)?'<span class="layui-badge layui-bg-green">有效</span>'
                        //     :'<span class="layui-badge layui-bg-red">无效</span>'
                    }
                }
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
                                url: '/stu/stuDels',
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
                        url: '/stu/stu' + (data == null ? 'Add' : 'Update'),
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
    //     $("#main").load(url)
    // }

</script>

</body>
</html>