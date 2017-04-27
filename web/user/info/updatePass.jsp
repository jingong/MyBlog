<%--
  Created by IntelliJ IDEA.
  User: jiajingong
  Date: 2017/4/18
  Time: 18:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>修改密码界面</title>
    <link rel="stylesheet" type="text/css" href="../../easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="../../easyui/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="../../easyui/demo.css">
    <link rel="stylesheet" type="text/css" href="../../easyui/myinfo.css">
    <script type="text/javascript" src="../../easyui/jquery.min.js"></script>
    <script type="text/javascript" src="../../easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="../../easyui/locale/easyui-lang-zh_CN.js"></script>
</head>
<body>
    <h2 align="center">修改密码</h2>
    <div style="margin:20px 0;"></div>
    <div id="info1">
        <div id="info2">
            <div class="easyui-panel" style="width:400px;padding:50px 60px">
                <form action="updatePasswordAction">
                    <div style="margin-bottom:20px">
                        <input class="easyui-textbox" name="userName" value="<s:property value="#session.user.userName"/>" prompt="Username" iconWidth="28" style="width:100%;height:34px;padding:10px;" disabled="true"　readOnly="true">
                    </div>
                    <div style="margin-bottom:20px">
                        <input id="pass" name="password" class="easyui-passwordbox" prompt="密码" iconWidth="28" style="width:100%;height:34px;padding:10px">
                    </div>
                    <div style="margin-bottom:20px">
                        <input class="easyui-passwordbox" name="password1" prompt="确认密码" iconWidth="28" validType="confirmPass['#pass']" style="width:100%;height:34px;padding:10px">
                    </div>
                    <div>
                        <input type="submit" class="easyui-linkbutton" value="确认修改" iconCls="icon-ok" style="width:100%;height:32px"/>
                    </div>
                </form>
            </div>
        </div>
    </div>

    <script type="text/javascript">
        $.extend($.fn.validatebox.defaults.rules, {
            confirmPass: {
                validator: function(value, param){
                    var pass = $(param[0]).passwordbox('getValue');
                    return value == pass;
                },
                message: '两次密码不一致'
            }
        })
    </script>
</body>
</html>
