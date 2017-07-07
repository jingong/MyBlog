<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="viewport" content="width=device-width,initial-scale=1.0,maximum-scale=1.0,user-scalable=0" />
    <title>关于 我</title>
    <link rel="stylesheet" href="css/style.css" type="text/css" media="all" />
</head>
<body class="loading-process">
<div class="loading">
    <div class="loading-circle"></div>
    <div class="loading-avatar"><img src="../upload/jia/<s:property value="#session.user.logo"/>" alt="" width="100" height="100"></div>
    <div class="loading-info">正在努力加载中...</div>
</div>
<div class="section-header">
    <div class="section">
        <nav class="nav" role="navigation">
            <ul>
                <li class="nav-about fade fade1"><a href="#about">关于</a></li>
                <li class="nav-works fade fade4"><a href="#works">博客</a></li>
                <li class="fade back-home"><a href="#top">首页</a></li>
                <li class="nav-skill fade fade2"><a href="#skill">能力</a></li>
                <li class="nav-contact fade fade3"><a href="#contact">联系</a></li>
            </ul>
        </nav>
    </div>
    <div class="nav-bg"></div>
</div>
<div class="home-bg">
    <img src="images/home-bg.jpg" alt="" width="1000" height="667">
</div>
<div class="section-wrap section-fristpage" data-slide="1"  >
    <div class="section">
        <div class="section-content">
            <p class="fade fade1">Hi，我是 <s:property value="#session.user.name"/></p>
            <p class="fade fade2">欢迎光临我的博客！</p>
            <p class="fade fade3">想了解更多，往下滚动哦 ^_^</p>
        </div>
        <a class="button2 scroll-tip fade fade4" data-slide="3" title="">向下滚动</a>
    </div>
</div>
<div id="about" data-slide="2" data-stellar-background-ratio="0.3" class="section-wrap section-about">
    <div class="section">
        <div class="about-content clearfix section-content">
            <div class="introli">
                <span class="left_icon"><img class="bio-text bio-icon-1" src="images/bio-icon-1.png" data-stellar-ratio="0.7" ></span>
                <span class="right_content "><a class="bio-text bio-text-2" data-stellar-ratio="0.7" style="font-family: 'Comic Sans MS';font-size: 3em;color: #0C0C0C";>我是一名<s:property value="#session.user.position"/></a></span>
            </div>
            <div class="introli">
                <span class="left_icon"><img class="bio-text bio-icon-2" src="images/bio-icon-2.png" data-stellar-ratio="0.7" ></span>
                <span class="right_content"><a class="bio-text bio-text-2" data-stellar-ratio="0.7" style="font-family: 'Comic Sans MS';font-size: 3em;color: #0C0C0C";>目前就读于<s:property value="#session.user.school"/></a></span>
            </div>
            <div class="introli">
                <span class="left_icon"><img class="bio-text bio-icon-3" src="images/bio-icon-3.png" data-stellar-ratio="0.7" ></span>
                <span class="right_content"><a class="bio-text bio-text-2" data-stellar-ratio="0.7" style="font-family: 'Comic Sans MS';font-size: 3em;color: #0C0C0C";>我是一名理工男，Major in <s:property value="#session.user.major"/></a></span>
            </div>
        </div>
    </div>
    <a class="button2 dark-button2 scroll-tip" style="background-position:0 -60px;" data-slide="3" title=""></a>
</div>
<div id="works" class="section-wrap section-works" data-slide="3" >
    <div class="section">
        <div class="works-content section-content">
            <h1>博客内容</h1>
            <div class="works-list clearfix">
                <s:iterator value="#session.bloglists" begin="0" end="5">
                    <div class="works-item first fade fade2">
                        <a href="lookCommentsAction?id=<s:property value="id"/>" target="_blank">
                            <img src="../upload/jia/<s:property value="picture"/>" alt="" width="300" height="180">
                            <div class="work-info">
                                <h2><s:property value="title"/></h2>
                                <p><strong>创建时间</strong>：<s:property value="time"/><br>
                                    <strong>博客类型</strong>：<s:property value="type.type"/></p>
                            </div>
                        </a>
                    </div>
                </s:iterator>
            </div>
            <a class="more-link" href="lookBlogByPageAction?page=1">查看更多</a>
        </div>
        <a class="button2 scroll-tip fade fade4" data-slide="4" title="">向下滚动</a>
    </div>
</div>
<div id="skill" class="section-wrap section-skill" data-slide="4">
    <div class="section">
        <div class="skill-content section-content">
            <h1>相关技能</h1>
            <ul>
                <s:iterator value="#session.slist">
                    <li class="fade fade1"><s:property value="skill"/></li>
                </s:iterator>
            </ul>
        </div>
    </div>
    <a class="button2 scroll-tip fade fade4"  data-slide="5" title="">向下滚动</a>
</div>
<div id="contact" class="section-wrap section-contact" data-slide="5">
    <div class="section">
        <div class="contact-content clearfix section-content">
            <h1>联系本人</h1>
            <div class="left">
                <div class="contact-ways fade fade1">
                    <h2>社交网络</h2>
                    <ul>
                        <li>学号：20142203630</li>
                        <li>姓名：贾金公</li>
                        <li>邮箱：jiajingong@163.com</li>
                        <li>Q Q ：739676343</li>
                        <li>CSDN：http://blog.csdn.net/iamjingong</li>
                        <li>Github：https://github.com/jingong</li>
                    </ul>
                </div>
                <div class="contact-info fade fade2">
                    <p>虽然有社交网络，但是平时上的比较少，很多时候是只看不发！不过你可以关注我哦！</p>
                </div>
            </div>
            <div class="right fade fade3">
                <h2>项目外包</h2>
                <p>如果你有前端相关的需求，可以联系我</p>
                <ul>
                    <li>网站布局设计及制作，网站页面制作。</li>
                    <li>根据需求，对网站前端进行修改和优化，或者转响应式处理。</li>
                    <li>企业网站建设及相关功能开发。</li>
                    <li>对于网站建设项目，我也有一些同行朋友可以推荐，也欢迎咨询！</li>
                </ul>
                <p><strong>适用浏览器</strong>：360、FireFox、Chrome、Safari、Opera、傲游、搜狗、世界之窗. 不支持IE8及以下浏览器。</p>

            </div>
        </div>
    </div>
    <a class="button2 button2-2-top scroll-tip" id="gototops" data-slide="1" href="#top" style="background-position: -60px 0;width:80px;height:80px;" title=""></a>
</div>

<div class="overlay"></div>
<div class="state-indicator"></div>

<script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
<script src="js/global.js"></script>
<script src="js/waypoints.min.js"></script>
<script src="js/js.js"></script>
<script src="js/jquery.stellar.min.js"></script>
</body>
</html>

