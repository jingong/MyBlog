<%--
  Created by IntelliJ IDEA.
  User: jiajingong
  Date: 2017/4/16
  Time: 19:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="../../css/pintuer.css">
    <link rel="stylesheet" href="../../css/admin.css">
    <script src="../../js/jquery.js"></script>
    <script src="../../js/pintuer.js"></script>
</head>
<body>
<div class="panel admin-panel">
    <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>增加内容</strong></div>
    <div class="body-content">
        <form method="post" class="form-x" action="updateBlogAction">
            <input type="hidden" value="<s:property value="blog.id"/>" name="blog.id"/>
            <div class="form-group">
                <div class="label">
                    <label>标题:</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" value="<s:property value="blog.title"/>" name="blog.title" data-validate="required:请输入标题" />
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>图片:</label>
                </div>
                <div class="field">
                    <input type="text" id="url1" name="blog.picture" class="input tips" style="width:25%; float:left;"  value="<s:property value="blog.picture"/>"  data-toggle="hover" data-place="right" data-image="" />
                    <input type="file" class="button bg-blue margin-left" id="image1" value="+ 浏览上传"  style="float:left;">
                    <%--<s:file name="upload" label="选择文件" size="20" class="button bg-blue margin-left" id="image1" style="float:left;" />--%>
                    <div class="tipss">图片尺寸:500*500</div>
                </div>
            </div>

            <if condition="$iscid eq 1">
                <div class="form-group">
                    <div class="label">
                        <label>分类标题:</label>
                    </div>
                    <div class="field">
                        <select name="blog.type.tid" class="input w50">
                            <c:forEach var="t" items="${session.tlist}">
                                <option value="${t.tid}">${t.type}</option>
                            </c:forEach>
                        </select>
                        <div class="tips"></div>
                    </div>
                </div>
            </if>
            <div class="form-group">
                <div class="label">
                    <label>内容：</label>
                </div>
                <div class="field">
                    <textarea name="blog.content" class="input" style="height:450px; border:1px solid #ddd;"><s:property value="blog.content"/></textarea>
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>发布时间：</label>
                </div>
                <div class="field">
                    <script src="js/laydate/laydate.js"></script>
                    <%--onclick="laydate({istime: true, format: 'YYYY-MM-DD hh:mm:ss'})"--%>
                    <input type="date" class="laydate-icon input w50" data-format="yyyy-MM-dd" name="blog.time" value="<s:property value="blog.time"/>" onclick="laydate({istime: true, format:'YYYY-MM-DD'})" data-validate="required:日期不能为空" style="padding:10px!important; height:auto!important;border:1px solid #ddd!important;" />
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>作者：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" name="blog.user.userName" value="<s:property value="blog.user.userName"/>"  />
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label></label>
                </div>
                <div class="field">
                    <button class="button bg-main icon-check-square-o" type="submit">提交</button>
                </div>
            </div>
        </form>
    </div>
</div>
</body>
</html>
