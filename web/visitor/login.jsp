<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
	<style>body{padding-top: 60px;}</style>
    <link href="../bootstrap3/css/bootstrap.css" rel="stylesheet" />
	<link href="../css/login-register.css" rel="stylesheet" />
	<link rel="stylesheet" href="http://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css">
	<script src="../jquery/jquery-1.10.2.js" type="text/javascript"></script>
	<script src="../bootstrap3/js/bootstrap.js" type="text/javascript"></script>
	<script src="../js/login-register.js" type="text/javascript"></script>
</head>
<body>
    <div class="container">

        <div class="row">
            <div class="col-sm-4">
            </div>
            <div class="col-sm-4">
                 <a class="btn big-login" data-toggle="modal" href="javascript:void(0)" onclick="openLoginModal();">登录</a>
                 <a class="btn big-register" data-toggle="modal" href="javascript:void(0)" onclick="openRegisterModal();">注册</a></div>
            <div class="col-sm-4"></div>
        </div>

		 <div class="modal fade login" id="loginModal">
		      <div class="modal-dialog login animated">
    		      <div class="modal-content">
    		         <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        <h4 class="modal-title">登录方式</h4>
                    </div>
                    <div class="modal-body">  
                        <div class="box">
                             <div class="content">
                                <div class="social">
                                    <a class="circle github" href="/auth/github">
                                        <i class="fa fa-github fa-fw"></i>
                                    </a>
                                    <a id="google_login" class="circle google" href="/auth/google_oauth2">
                                        <i class="fa fa-google-plus fa-fw"></i>
                                    </a>
                                    <a id="facebook_login" class="circle facebook" href="/auth/facebook">
                                        <i class="fa fa-facebook fa-fw"></i>
                                    </a>
                                </div>
                                <div class="division">
                                    <div class="line l"></div>
                                      <span>或</span>
                                    <div class="line r"></div>
                                </div>
                                <div class="error"></div>
                                <div class="form loginBox">
                                    <form method="post" action="loginAction" accept-charset="UTF-8">
                                        <input id="email" class="form-control" type="text" placeholder="用户名" name="visitor.visName">
                                        <input id="password" class="form-control" type="password" placeholder="密码" name="visitor.visPassword">
                                        <input class="btn btn-default btn-login" type="submit" value="登录" onclick="">
                                    </form>
                                </div>
                             </div>
                        </div>
                        <div class="box">
                            <div class="content registerBox" style="display:none;">
                             <div class="form">
                                <form method="post" html="{:multipart=>true}" data-remote="true" action="registerAction" accept-charset="UTF-8">
                                    <input id="email" class="form-control" type="text" placeholder="用户名" name="visitor.visName">
                                    <input id="password" class="form-control" type="password" placeholder="密码" name="visitor.visPassword">
                                    <input id="password_confirmation" class="form-control" type="password" placeholder="确认密码" name="visitor.visPassword1">
                                    <input class="btn btn-default btn-register" type="submit" value="创建账户" name="commit">
                                </form>
                                </div>
                            </div>

                        </div>
                    </div>
                    <div class="modal-footer">
                        <div class="forgot login-footer">
                            <span>还没账户
                                 <a href="javascript: showRegisterForm();">创建账户</a>
                            ?</span>
                        </div>
                        <div class="forgot register-footer" style="display:none">
                             <span>已经有账号?</span>
                             <a href="javascript: showLoginForm();">登录</a>
                        </div>
                    </div>        
    		      </div>
		      </div>
		  </div>
    </div>
</body>
</html>
