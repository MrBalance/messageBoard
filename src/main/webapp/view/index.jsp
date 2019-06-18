<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta charset="utf-8" />
    <title>留言板后台管理系统</title>
    <link rel="stylesheet" type="text/css" href="../static/themes/default/easyui.css" />
    <link rel="stylesheet" type="text/css" href="../static/themes/icon.css" />
    <link rel="stylesheet" type="text/css" href="../static/css/common.css" />
    <script type="text/javascript" src="../static/js/jQuery/jquery-1.11.2.min.js"></script>
    <script type="text/javascript" src="../static/js/jQuery/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="../static/js/jQuery/easyui-lang-zh_CN.js"></script>
</head>
<body class="easyui-layout" id="layout" style="visibility:hidden;">

<div region="north" id="header">
    <img src="../static/image/index/logo.png" class="logo" />
    <div class="top-btns">
        <span>欢迎您，管理员</span>
        <a href="#" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-lock'">修改密码</a>
        <a href="#" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-clear'">退出系统</a>
        <select class="easyui-combobox" data-options="editable:false">
            <option value="0" selected="selected">中文</option>
            <option value="1">English</option>
        </select>
    </div>
</div>

<div region="west" split="true" title="导航菜单" id="naver">
    <div class="easyui-accordion" fit="true" id="navmenu">
        <div title="留言管理">
            <ul class="navmenu">
                <li><a href="#" data-url="messageManage/messageSearch.jsp">留言查询</a></li>
            </ul>
        </div>
        <div title="留言板">
            <ul class="navmenu">
                <li><a href="#" data-url="messageBoard/messageBoard.jsp">留言</a></li>
            </ul>
        </div>
    </div>
</div>

<div region="center" id="content">
    <div class="easyui-tabs" fit="true" id="tt">

        <div title="首页" iconCls="icon-ok">
            <div class="easyui-accordion" data-options="fit:true">
                <div title="欢迎使用">
                </div>
                <div title="系统公告">
                    <ul class="notice-list">
                        <li>
                            <span>这是一条系统公告系统公告系统公告系统公告系统公告系统公告系统公告系统公告系统公告</span>
                            <span class="date">2015-10-30</span>
                        </li>
                        <li>
                            <span>这是一条系统公告系统公告系统公告系统公告系统公告系统公告系统公告系统公告系统公告</span>
                            <span class="date">2015-10-30</span>
                        </li>
                        <li>
                            <span>这是一条很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长的系统公告</span>
                            <span class="date">2015-10-30</span>
                        </li>
                        <li>
                            <span>这是一条系统公告系统公告系统公告系统公告系统公告系统公告系统公告系统公告系统公告</span>
                            <span class="date">2015-10-30</span>
                        </li>
                        <li>
                            <span>这是一条系统公告系统公告系统公告系统公告系统公告系统公告系统公告系统公告系统公告</span>
                            <span class="date">2015-10-30</span>
                        </li>
                    </ul>
                </div>
            </div>
        </div>

    </div>
</div>

<div region="south" id="footer">留言板后台管理系统</div>

<script type="text/javascript">
    $(function() {
        //添加新的Tab页
        $("#navmenu").on("click", "a[data-url]", function(e) {
            e.preventDefault();
            var tabTitle = $(this).text();
            var tabUrl = $(this).data("url");

            if($("#tt").tabs("exists", tabTitle)) { //判断该Tab页是否已经存在
                $("#tt").tabs("select", tabTitle);
            }else {
                $("#tt").tabs("add", {
                    title: tabTitle,
                    href: tabUrl,
                    closable: true
                });
            }
            $("#navmenu .active").removeClass("active");
            $(this).parent().addClass("active");
        });

        //解决闪屏的问题
        window.setTimeout(function() {
            $("#layout").css("visibility", "visible");
        }, 800);

        var loadUser = function () {
            $.ajax({
                type: "POST",   //post提交方式默认是get
                url: "../service/MessageBoardInfo/leavingMessage",
                data: {
                    tittle: tittle,
                    key: key,
                    context:context
                },
                error: function (request) { // 设置表单提交出错
                    $.messager.alert('警告', request, 'info');
                },
                success: function (data) {
                    if(data == "0") {
                        $("#dlg").dialog("close");
                        searchMessage();
                        $.messager.alert('提示', "添加成功", 'info');
                    } else {
                        $.messager.alert('提示', data, 'info');
                    }
                }
            });
        }
    });
</script>
</body>
</html>
