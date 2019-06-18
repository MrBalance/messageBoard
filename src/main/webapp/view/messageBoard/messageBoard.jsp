<%--
  Created by IntelliJ IDEA.
  User: kenfor
  Date: 2019/6/13
  Time: 14:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="../static/css/msgBoard.css">
<script src="../static/js/msgBoard.js"></script>
<div>
    <!-- 发布留言的主体 -->
    <div class="wrap">
        <strong>标题：</strong>
        <input id="Mtittle" class="input-txt">
        <strong>关键字：</strong>
        <input id="Mkey" class="input-txt">
        <div class="wrap-head">
            <div class="head-txt">
                <a class="title-txt" href="javascript:void(0)">置办年货省省省！红包在手年货无忧！点击领取年货红包&nbsp;&nbsp;&nbsp;热门微博</a>
            </div>
        </div>
        <div class="main-txt">
            <textarea name="" rows="" cols="" class="main-area"></textarea>
        </div>
        <div class="warp-footer">
            <div class="warp-icon-cont">
            </div>
            <div class="warp-footer-btns">
                <div class="release-btn">
                    <a href="javascript:void(0)">发布</a>
                </div>
            </div>
        </div>
    </div>
    <!-- 显示留言的主体 -->
    <div class="show">
         <div class="show-content">
            <div class="show-name">Xx</div>
             <div class="show-key">key</div>
            <div class="show-txt">
                <p class="">这是内容</p>
            </div>
            <div class="show-time">2018年10月24日</div>
            <div class="show-close">x</div>
        </div>
    </div>
</div>
