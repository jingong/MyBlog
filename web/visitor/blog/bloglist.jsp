<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1" />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <!--[if IE]>
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <![endif]-->
    <title>Bootstrap Free Blog Template</title>
    <!-- BOOTSTRAP CORE STYLE CSS -->
    <link href="../../assets/css/bootstrap.css" rel="stylesheet" />
    <!-- FONTAWESOME STYLE CSS -->
    <link href="../../assets/css/font-awesome.css" rel="stylesheet" />
    <!-- CUSTOM STYLE CSS -->
    <link href="../../assets/css/style.css" rel="stylesheet" />
</head>
<body>


    <section class="header-section">
        <div class="container">
            <div class="row">
                <div class="col-md-2">
                    <img src="../../upload/jia/<s:property value="#session.user.logo"/>" class="img-circle img-responsive" />
                </div>
                <div class="col-md-5 text-center">
                    <h1><strong><s:property value="#session.user.name"/></strong></h1>
                    <h4><s:property value="#session.user.position"/></h4>
                </div>
                <div class="col-md-5">
                    <h3>WHO M I :</h3>
                    我是一名<s:property value="#session.user.position"/>
                    目前就读于<s:property value="#session.user.address"/> <s:property value="#session.user.school"/><br>
                    我的专业是：<s:property value="#session.user.major"/>
                </div>
            </div>
        </div>
    </section>
    <!--HOME SECTION END-->

    <section>
        <div class="container">
            <div class="row">
                <div class="col-md-2 spon-txt">
                    <span>我的最爱: </span>
                </div>
                <div class="col-md-10">
                    <img src="../../assets/img/clients.png" alt="" class="img-rounded img-responsive" />
                </div>
            </div>
        </div>
    </section>
    <!--SPONSORS SECTION END-->
    <div class="copyrights">Collect from <a href="http://blog.csdn.net/iamjingong"  title="博客">我的博客</a></div>
    <hr />
    <section>
        <div class="container">
            <div class="row">
                <div class="col-md-9">
                    <s:iterator value="#session.blogPage.bloglist">
                        <div class="blog-main">
                            <div class="heading-blog">
                                <s:property value="title"/>
                            </div>
                            <a href="lookCommentsAction?id=<s:property value="id"/>">
                                <img src="../../upload/jia/<s:property value="picture"/>" class="img-responsive img-rounded" />
                            </a>
                            <div class="blog-info">
                                <span class="label label-primary">发表于 <s:property value="time"/></span>
                                <span class="label label-success"><s:property value="type.type"/></span>
                                <span class="label label-danger"><s:property value="userName"/></span>
                            </span>
                            </div>
                            <div class="blog-txt">
                                <s:property value="content"/>
                            </div>
                        </div>
                    </s:iterator>

                    <nav>
                        <ul class="pagination">
                            <s:if test="#session.blogPage.currentPage == 1">
                                首页&nbsp;&nbsp;&nbsp;上一页
                            </s:if>
                            <s:else>
                                <a href="lookBlogByPageAction?page=1">首页</a>
                                &nbsp;&nbsp;&nbsp;
                                <a href="lookBlogByPageAction?page=<s:property value="#session.blogPage.currentPage - 1"/>">上一页</a>
                            </s:else>
                            <s:if test="#session.blogPage.currentPage != #session.blogPage.totalPage">
                                <a href="lookBlogByPageAction?page=<s:property value="#session.blogPage.currentPage + 1"/>">下一页</a>
                                &nbsp;&nbsp;&nbsp;
                                <a href="lookBlogByPageAction?page=<s:property value="#session.blogPage.totalPage"/>">尾页</a>
                            </s:if>
                            <s:else>
                                下一页&nbsp;&nbsp;&nbsp;尾页
                            </s:else>
                        </ul>
                    </nav>
                     <!--PAGING  END -->
                </div>
                <div class="col-md-3">

                    <ul class="list-group">
                        <li class="list-group-item">
                            <strong>博客分类</strong>
                        </li>
                        <li class="list-group-item">
                            <span class="badge"></span>
                            <a href="lookBlogByType?tid=1&page=1">旅游博客</a>
                        </li>
                        <li class="list-group-item">
                            <span class="badge"></span>
                            <a href="lookBlogByType?tid=2&page=1">技术博客</a>
                        </li>
                        <li class="list-group-item">
                            <span class="badge"></span>
                            <a href="lookBlogByType?tid=3&page=1">心情博客</a>
                        </li>
                    </ul>
                    <br />

                    <ul class="list-group">
                        <li class="list-group-item">Advrtisements
                        </li>
                        <li class="list-group-item">
                            <a href="#">
                                <img src="../../assets/img/ad1.jpg" class="img-responsive" />
                            </a>
                            <br />
                            <a href="#">
                                <img src="../../assets/img/ad2.jpg" class="img-responsive" />
                            </a>
                        </li>
                    </ul>
                    <br />
                </div>
            </div>
        </div>
    </section>
    <hr />
    <div class="container">
        <div class="row">
            <div class="col-md-12 text-center set-foot">
                欢迎访问我的博客！
            </div>
        </div>
    </div>

</body>
</html>
