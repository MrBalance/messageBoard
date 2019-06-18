<%--
  Created by IntelliJ IDEA.
  User: kenfor
  Date: 2019/6/12
  Time: 9:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="messageDataManage" class="easyui-layout" data-options="fit:true">
    <!-- 数据表 -->
    <table id="messageData"></table>
    <!-- /数据表 -->
    <!-- 数据表工具栏 -->
    <div class="toolbar" id="toolbar">
        <div class="search-div">
            <label>留言标题：</label>
            <input id="tittle"/>
            <label>留言关键字：</label>
            <input id="key"/>
            <label>留言内容：</label>
            <input id="context"/>
            <label>留言账户：</label>
            <input id="account"/>
            <a href="#" id="searchBtn" class="easyui-linkbutton" iconCls="icon-search">搜索</a>
        </div>
        <div class="ctrl-div">
            <a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" id="addBtn">新增</a>
            <a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" id="editBtn">编辑</a>
            <a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" id="deletBtn">批量删除</a>
        </div>
    </div>
    <!-- /数据表工具栏 -->
    <!-- 弹出框 -->
    <div class="easyui-dialog" title="新增/编辑" iconCls="icon-save" modal="true"
         closed="true" buttons="#dlg-btns" id="dlg" style="width:500px;height:380px;">
        <form id="fm" method="post">
            <div class="fitem">
                <label>留言标题： </label>&nbsp;&nbsp;
                <input id="dlgTitle" class="easyui-textbox"  />
            </div>
            <div class="fitem">
                <label>留言关键字：</label>
                <input id="dlgKey" class="easyui-textbox"  />
            </div>
            <div class="fitem">
                <label>留言内容： </label>&nbsp;&nbsp;
                <input id="dlgContext" class="easyui-textbox" multiline="true" style="width:352px;height:150px;"   />
            </div>
            <div style="padding:5px 0;text-align: center;color: red;" id="showMsg"></div>
        </form>
    </div>
    <!-- /弹出框 -->

    <!-- 弹出框按钮组-->
    <div id="dlg-btns">
        <a href="#" class="easyui-linkbutton" iconCls="icon-ok" id="saveBtn">保存</a>
        <a href="#" class="easyui-linkbutton" iconCls="icon-cancel" id="cancelBtn">取消</a>
    </div>
    <!-- /弹出框 按钮组-->
</div>
<script type="text/javascript">
    $(function() {
        // TODO 关于js和样式加载顺序问题还需要花时间研究一下
        /******************************************
         * 页面信息载入模块
         ******************************************/
        var messageDataManage= {};
        messageDataManage.messageData = $("#messageData").datagrid({
            pagination: true,
            pageSize: 10,
            singleSelect:false,
            ctrlSelect:true,
            columns:[[
                {field:'messageId',hidden:'true'},
                {field:'messageTittle',title:'留言标题',width:"20%",align:"center"},
                {field:'messageKey',title:'留言关键字',width:"10%",align:"center"},
                {field:'messageContext',title:'留言内容',width:"30%",align:"center"},
                {field:'messageDate',title:'留言时间',width:"20%",align:"center"},
                {field:'messageAccout',title:'留言账户',width:"20%",align:"center"}
            ]],
            toolbar:"#toolbar"
        });
        messageDataManage.title = $("#tittle").textbox({});
        messageDataManage.key = $("#key").textbox({});
        messageDataManage.context = $("#context").textbox({});
        messageDataManage.account = $("#account").textbox({});
        messageDataManage.messageData.datagrid('getPager').pagination({
            pageSize: 10,
            onSelectPage: function (pageNumber, pageSize) {    //onRefresh
                messageDataLoad(pageNumber,pageSize);
            }
        });
        messageDataManage.dlgTitle = $("#dlgTitle").textbox({});
        messageDataManage.dlgKey = $("#dlgKey").textbox({});
        messageDataManage.dlgContext = $("#dlgContext").textbox({});

        /******************************************
         * 复用功能模块
         ******************************************/
        // 加载功能
        var messageDataLoad = function(page,rows) {
            var tittle = messageDataManage.title.textbox("getValue");
            var key = messageDataManage.key.textbox("getValue");
            var context = messageDataManage.context.textbox("getValue");
            var account = messageDataManage.account.textbox("getValue");
            $.ajax({
                type: "POST",   //post提交方式默认是get
                url: "../service/MessageBoardInfo/searchMessage",
                data: {
                    pageNum: page,
                    pageSize: rows,
                    tittle:tittle,
                    key:key,
                    context:context,
                    account:account
                },
                dataType: 'json',
                error: function (request) { // 设置表单提交出错
                    $.messager.alert('警告', request, 'info');
                },
                success: function (data) {
                    if(!data.rows){
                        data.rows = '';
                    }
                    $("#messageData").datagrid('loadData', data);
                }
            });
        }
        // 搜索功能
        var searchMessage = function(){
            var options = messageDataManage.messageData.datagrid('getPager').data("pagination").options;
            messageDataLoad(1, options.pageSize)
        }
        // dialog内容清除
        var dlgclear = function () {
            messageDataManage.dlgTitle.textbox("clear");
            messageDataManage.dlgKey.textbox("clear");
            messageDataManage.dlgContext.textbox("clear");
            $("#showMsg").html("");
        }


        /******************************************
         * 标签方法关联模块
         ******************************************/
        // 查询按钮
        $("#searchBtn").click(function () {
            searchMessage();
        });
        // 新增保存按钮
        $("#saveBtn").click(function () {
            // 空检验
            var tittle = messageDataManage.dlgTitle.textbox("getValue");
            if(!tittle){
                $("#showMsg").html("标题不能为空，请输入");
                messageDataManage.dlgTitle.next('span').find('input').focus();
                return;
            }
            var key = messageDataManage.dlgKey.textbox("getValue");
            if(!key){
                $("#showMsg").html("关键字不能为空，请输入");
                messageDataManage.dlgKey.next('span').find('input').focus();
                return;
            }
            var context = messageDataManage.dlgContext.textbox("getValue");
            if(!context){
                $("#showMsg").html("内容不能为空，请输入");
                messageDataManage.dlgContext.next('span').find('textarea').focus();
                return;
            }
            // 清除内容
            dlgclear();
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
        })
        // 批量删除按钮
        $("#deletBtn").click(function () {
            var rows = messageDataManage.messageData.datagrid('getSelections');
            var ids = new Array();
            $.each(rows, function(i, n){
                ids.push(n.messageInfoId);
            });
            $.ajax({
                type: "POST",   //post提交方式默认是get
                url: "../service/MessageBoardInfo/deleteMessages",
                data: {
                    list:ids
                },
                error: function (request) { // 设置表单提交出错
                    $.messager.alert('警告', request, 'info');
                },
                success: function (data) {
                    if(data == "0") {
                        $("#dlg").dialog("close");
                        searchMessage();
                        $.messager.alert('提示', "删除成功", 'info');
                    } else {
                        $.messager.alert('提示', data, 'info');
                    }
                }
            });
        });
        // 新增/编辑按钮（打开弹出框）
        $("#addBtn, #editBtn").click(function(e) {
            e.preventDefault();
            $("#dlg").dialog("open");
        });
        // 取消按钮（关闭弹出框）
        $("#cancelBtn").click(function(e) {
            e.preventDefault();
            dlgclear();
            $("#dlg").dialog("close");
        });
        /******************************************
         * 初始化加载数据模块
         ******************************************/
        messageDataLoad(1,10);
    });
</script>

