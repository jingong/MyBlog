<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>main</title>
  </head>
	<frameset rows="150,*">
		<frame src="main/top.jsp" scrolling="no">
		<frameset cols="160,*">
			<frame src="main/left.jsp" scrolling="no">
			<frame src="main/right.jsp" name="main">
		</frameset>
	</frameset>
</html>
