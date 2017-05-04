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
    <title>博客详情</title>
    <!-- BOOTSTRAP CORE STYLE CSS -->
    <link href="../../assets/css/bootstrap.css" rel="stylesheet" />
    <!-- FONTAWESOME STYLE CSS -->
    <link href="../../assets/css/font-awesome.css" rel="stylesheet" />
    <!-- CUSTOM STYLE CSS -->
    <link href="../../assets/css/style.css" rel="stylesheet" />
</head>
<body >
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
                <span>My Sponsers: </span>
            </div>
            <div class="col-md-10">
                <img src="../../assets/img/clients.png" alt="" class="img-rounded img-responsive" />
            </div>


        </div>
    </div>
</section>
<!--SPONSORS SECTION END-->
<hr />
<section  >
    <div class="container">
        <div class="row">
            <div class="col-md-9" >
                <div class="blog-main">
                    <div class="heading-blog">
                        <s:property value="blog.title"/>
                    </div>
                    <img src="../../upload/jia/<s:property value="blog.picture"/>" class="img-responsive img-rounded" />
                    <div class="blog-info">
                        <span class="label label-primary"><s:property value="blog.time"/></span>
                        <span class="label label-success"><s:property value="blog.type.type"/></span>
                        <span class="label label-danger"><s:property value="blog.userName"/></span>
                    </div>
                    <div class="blog-txt">
                        <s:property value="blog.content"/>
                    </div>
                </div>
                <!--BLOG MAIN SECTION END-->
                <h3 ><strong>Recent Comments :</strong></h3>
                <hr />
                <ul class="media-list">
                    <s:iterator value="clist">
                        <li class="media">
                            <a class="pull-left" href="#">
                                <img class="media-object img-circle"   src="../../assets/img/user2.png" />
                            </a>
                            <div class="media-body">
                                <h4 class="media-heading"><s:property value="userName"/></h4>
                                <p>
                                    <s:property value="content"/>
                                </p>
                            </div>
                        </li>
                    </s:iterator>
                </ul>
            </div>
            <div class="col-md-3">
                <br />
                <div style="padding-top:30px;">
                    <ul class="list-group">
                        <li class="list-group-item">
                            Advrtisements
                        </li>
                        <li class="list-group-item">
                            <a href="#">
                                <img src="../../assets/img/ad1.jpg" class="img-responsive" />
                            </a>
                            <br /><a href="#">
                            <img src="../../assets/img/ad2.jpg" class="img-responsive" />
                        </a>
                        </li>
                    </ul>
                </div>
                <br />
                <div style="padding-top:30px;">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h3 class="panel-title">Subscribe For Updates</h3>
                        </div>
                        <div class="panel-body">
                            <input type="text" class="form-control" placeholder="Your Email" />
                            <hr />
                            <a href="#" class="btn btn-info btn-sm btn-block" >subscribe</a>
                        </div>
                    </div>
                </div>
            </div>



        </div>
    </div>
</section>
<hr />
<div class="container">
    <div class="row">
        <div class="col-md-12 text-center" style="padding:20px 5px;" >
            http://blog.csdn.net/iamjingong |  贾金公 <a href="http://blog.csdn.net/iamjingong" target="_blank" title="博客">博客</a>
        </div>
    </div>
</div>

</body>
</html>
