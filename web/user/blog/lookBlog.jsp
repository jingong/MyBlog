<%--
  Created by IntelliJ IDEA.
  User: jiajingong
  Date: 2017/4/16
  Time: 19:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>查看博客页面</title>
    <link rel="stylesheet" href="../../css/pintuer.css">
    <link rel="stylesheet" href="../../css/admin.css">
    <script src="../../js/jquery.js"></script>
    <script src="../../js/pintuer.js"></script>
    <script type = "text/javascript">
        function deleteStudent(){
            flag=false;
            len = form1.delid.length;
            for(i=0;i<len;i++){
                if(form1.delid[i].checked){
                    flag=true;
                }
            }
            if(flag == false){
                alert("至少选择一个待删除记录");
                return false;
            }
            form1.action = "deleteBlogAction";
            form1.submit();
        }
        function refreshStudent(){
            form1.action = "lookBlogAction?page=<s:property value="#session.pageBean.currentPage"/>";
            form1.submit();
        }
        function lookBlog() {
            /*判断是模糊查询还是普通查看*/
            var keywords = form1.keywords.value;
            if(keywords == null || keywords == ""){//普通的页面浏览
                form1.action = "lookBlogAction?page=1";
                form1.submit();
            }else {//模糊查询
                form1.action = "fuzzyLookBlogAction?page=1";
                form1.submit();
            }
        }
        function lookFirstPage() {
            /*判断是模糊查询还是普通查看*/
            var keywords = form1.keywords.value;
            if(keywords == null || keywords == ""){//普通的页面浏览
                form1.action = "lookBlogAction?page=1";
                form1.submit();
            }else {//模糊查询
                form1.action = "fuzzyLookBlogAction?page=1";
                form1.submit();
            }
        }
        function lookPreviousPage() {
            /*判断是模糊查询还是普通查看*/
            var keywords = form1.keywords.value;
            if(keywords == null || keywords == ""){//普通的页面浏览
                form1.action = "lookBlogAction?page=<s:property value="#session.pageBean.currentPage - 1"/>";
                form1.submit();
            }else {//模糊查询
                form1.action = "fuzzyLookBlogAction?page=<s:property value="#session.pageBean.currentPage - 1"/>";
                form1.submit();
            }
        }
        function lookNextPage() {
            /*判断是模糊查询还是普通查看*/
            var keywords = form1.keywords.value;
            if(keywords == null || keywords == ""){//普通的页面浏览
                form1.action = "lookBlogAction?page=<s:property value="#session.pageBean.currentPage + 1"/>";
                form1.submit();
            }else {//模糊查询
                form1.action = "fuzzyLookBlogAction?page=<s:property value="#session.pageBean.currentPage + 1"/>";
                form1.submit();
            }
        }
        function lookLastPage() {
            /*判断是模糊查询还是普通查看*/
            var keywords = form1.keywords.value;
            if(keywords == null || keywords == ""){//普通的页面浏览
                form1.action = "lookBlogAction?page=<s:property value="#session.pageBean.totalPage"/>";
                form1.submit();
            }else {//模糊查询
                var keyword1 = '<s:property value="keywords"/>';
                form1.action = "fuzzyLookBlogAction?page=<s:property value="#session.pageBean.totalPage"/>";
                form1.submit();
            }
        }
    </script>
</head>
<body>
    <%--在首次进入查看博客页面的时候，当session里的pageBean为空的时候把页面重定向--%>
    <s:if test="#session.pageBean == null">
        <script language="javascript" type="text/javascript">
            window.location.href='lookBlogAction?page=1';
        </script>
    </s:if>
    <form method="post" action="" id="listform" name="form1">
        <div class="panel admin-panel">
            <div class="panel-head"><strong class="icon-reorder">内容列表</strong> <a href="" style="float:right; display:none;">添加字段</a></div>
            <div class="padding border-bottom">
                <ul class="search" style="padding-left:10px;">
                    <li> <a class="button border-main icon-plus-square-o" href="addBlog.jsp">添加内容</a> </li>
                    <li><input type="text" placeholder="请输入关键字(支持模糊查询)" name="keywords" value="<s:property value="keywords"/>" class="input" style="width:250px; line-height:17px;display:inline-block" /><input type="submit" class="button border-main icon-search" value="搜索" onclick="lookBlog()"/></li>
                    <li><input type="submit" class="button border-main icon-refresh" onclick="refreshStudent()" value="刷新"/></li>
                </ul>
            </div>
            <table class="table table-hover text-center">
                <tr><th width="100" style="text-align:left; padding-left:20px;">ID</th>
                    <th>图片</th>
                    <th>名称</th>
                    <th>分类名称</th>
                    <th width="10%">更新时间</th>
                    <th width="310">操作</th></tr>
                <volist name="list" id="vo">
                    <s:iterator value="#session.pageBean.list" status="st">
                        <tr><td style="text-align:left; padding-left:20px;"><input type="checkbox" name="delid" value="${id}" id="delid[#st.index]"/><s:property value="id"/></td>
                            <td width="10%"><img src="../../upload/jia/<s:property value="picture"/>" alt="" width="70" height="50" /></td>
                            <td><s:property value="title" /></td>
                            <td><s:property value="type.type" /></td>
                            <td><s:property value="time" /></td>
                            <td><div class="button-group"><a class="button border-main" href="getUpdateBlogAction?id=<s:property value="id"/>"><span class="icon-edit"></span>修改</a><a class="button border-main" href="getBlogCommentsAction?id=<s:property value="id"/>&page=1"><span class="icon-arrow-right"></span>进入评论区</a></div></td>
                        </tr>
                    </s:iterator>
                    <tr><td colspan="7" style="text-align:left;padding-left:20px;"><input type="submit" class="button border-red icon-trash-o" style="padding:5px 15px;" onclick="deleteStudent()" value="删除"/> <a href="javascript:void(0)" style="padding:5px 15px; margin:0 10px;" class="button border-blue icon-edit"> 排序</a></tr>
                    <tr><td colspan="8">
                            <div class="pagelist">
                                <s:if test="#session.pageBean.currentPage == 1">首页&nbsp;&nbsp;&nbsp;上一页
                                </s:if>
                                <s:else><a onclick="lookFirstPage()">首页</a>&nbsp;&nbsp;&nbsp;<a onclick="lookPreviousPage()">上一页</a>
                                </s:else>
                                <s:if test="#session.pageBean.currentPage != #session.pageBean.totalPage"><a onclick="lookNextPage()">下一页</a>&nbsp;&nbsp;&nbsp;<a onclick="lookLastPage()">尾页</a>
                                </s:if>
                                <s:else>下一页&nbsp;&nbsp;&nbsp;尾页
                                </s:else>
                            </div></td>
                    </tr></volist></table></div>
    </form>
</body>
</html>
