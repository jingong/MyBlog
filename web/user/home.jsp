<!DOCTYPE HTML>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<html>
  <head>
    <title>首页</title>
	  <link href="../indexassets/css/bootstrap.css" rel="stylesheet" />
	  <link href="../indexassets/css/font-awesome.css" rel="stylesheet" />
	  <link href="../indexassets/js/morris/morris-0.4.3.min.css" rel="stylesheet" />
	  <link href="../indexassets/css/custom.css" rel="stylesheet" />
	  <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
  </head>
  
  <body>
	  <div class="row">
		  <div class="col-md-12">
			  <h2>站长统计</h2>
			  <h5>Welcome <s:property value="#session.user.userName"/>, Love to see you back. </h5>
		  </div>
	  </div>
	  <!-- /. ROW  -->
	  <hr />
	  <div class="row">
		  <div class="col-md-3 col-sm-6 col-xs-6">
			  <div class="panel panel-back noti-box">
					<span class="icon-box bg-color-red set-icon">
						<i class="fa fa-newspaper-o"></i>
					</span>
				  <div class="text-box" >
					  <p class="main-text"><s:property value="#session.blogCount"/> 篇</p>
					  <p class="text-muted">博客</p>
				  </div>
			  </div>
		  </div>
		  <div class="col-md-3 col-sm-6 col-xs-6">
			  <div class="panel panel-back noti-box">
					<span class="icon-box bg-color-green set-icon">
						<i class="fa fa-comments-o"></i>
					</span>
				  <div class="text-box" >
					  <p class="main-text"><s:property value="#session.commentCount"/> 条</p>
					  <p class="text-muted">评论</p>
				  </div>
			  </div>
		  </div>
		  <div class="col-md-3 col-sm-6 col-xs-6">
			  <div class="panel panel-back noti-box">
					<span class="icon-box bg-color-blue set-icon">
						<i class="fa fa-users"></i>
					</span>
				  <div class="text-box" >
					  <p class="main-text"><s:property value="#session.visitorCount"/> 个</p>
					  <p class="text-muted">访客</p>
				  </div>
			  </div>
		  </div>
		  <div class="col-md-3 col-sm-6 col-xs-6">
			  <div class="panel panel-back noti-box">
					<span class="icon-box bg-color-brown set-icon">
						<i class="fa fa-bars"></i>
					</span>
				  <div class="text-box" >
					  <p class="main-text"><s:property value="#session.typeCount"/> 种</p>
					  <p class="text-muted">博客类型</p>
				  </div>
			  </div>
		  </div>
	  </div>
	  <script src="../indexassets/js/jquery-1.10.2.js"></script>
	  <!-- BOOTSTRAP SCRIPTS -->
	  <script src="../indexassets/js/bootstrap.min.js"></script>
	  <!-- METISMENU SCRIPTS -->
	  <script src="../indexassets/js/jquery.metisMenu.js"></script>
	  <!-- MORRIS CHART SCRIPTS -->
	  <script src="../indexassets/js/morris/raphael-2.1.0.min.js"></script>
	  <script src="../indexassets/js/morris/morris.js"></script>
	  <!-- CUSTOM SCRIPTS -->
	  <script src="../indexassets/js/custom.js"></script>
  </body>
</html>
