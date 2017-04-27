<%--
  Created by IntelliJ IDEA.
  User: jiajingong
  Date: 2017/4/19
  Time: 18:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <title>此页面是用于帮助页面跳转的页面</title>
</head>
<body>
    <script type="text/javascript">
        var url = "lookBlogAction?page=1";//通常先写一个变量来存地址
        window.location.href(url);//这个是传到action的方式
    </script>
</body>
</html>
