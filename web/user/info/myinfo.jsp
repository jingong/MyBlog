<!DOCTYPE HTML>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
	<meta charset="UTF-8">
	<title>个人信息</title>
	<link rel="stylesheet" type="text/css" href="../../easyui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="../../easyui/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="../../easyui/demo.css">
	<link rel="stylesheet" type="text/css" href="../../easyui/myinfo.css">
	<script type="text/javascript" src="../../easyui/jquery.min.js"></script>
	<script type="text/javascript" src="../../easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="../../easyui/locale/easyui-lang-zh_CN.js"></script>
</head>
<body>
<h2 align="center">博主信息</h2>
<div style="margin:20px 0;"></div>
<div id="info1">
	<div id="info2">
		<div class="easyui-panel" title="个人信息" style="width:100%;max-width:400px;padding:30px 60px;">
			<form action="updateUserInfo">
				<div style="margin-bottom:20px">
					<input class="easyui-textbox" name="user.userName" value="<s:property value="#session.user.userName"/>" label="用户名:" labelPosition="top" style="width:100%;height:52px">
				</div>
				<div style="margin-bottom:20px">
					<input class="easyui-textbox" name="user.name" value="<s:property value="#session.user.name"/>" label="姓名:" labelPosition="top" style="width:100%;height:52px">
				</div>
				<div style="margin-bottom:20px">
					<input class="easyui-datebox" name="user.birth" value="<s:property value="#session.user.birth"/>" label="生日:" labelPosition="top" style="width:100%;height:52px">
				</div>
				<div style="margin-bottom:20px">
					<input class="easyui-textbox" name="user.address" value="<s:property value="#session.user.address"/>" label="地址:" labelPosition="top" style="width:100%;height:52px">
				</div>
				<div style="margin-bottom:20px">
					<input class="easyui-textbox" name="user.work" value="<s:property value="#session.user.work"/>" label="工作:" labelPosition="top" style="width:100%;height:52px">
				</div>
				<div style="margin-bottom:20px">
					<input class="easyui-textbox" name="user.description" value="<s:property value="#session.user.description"/>" label="描述:" labelPosition="top" style="width:100%;height:52px">
				</div>
				<div>
					<%--class="easyui-linkbutton"--%>
					<input type="submit"  iconCls="icon-ok" style="width:100%;height:32px"/>
				</div>
			</form>
		</div>
	</div>
</div>
</body>
</html>
