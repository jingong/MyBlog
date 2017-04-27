<%--
  Created by IntelliJ IDEA.
  User: jiajingong
  Date: 2017/4/26
  Time: 20:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="../../css/pintuer.css">
    <link rel="stylesheet" href="../../css/admin.css">
    <script src="../../js/jquery.js"></script>
    <script src="../../js/pintuer.js"></script>
    <script type="text/javascript">
        function deleteComments(){
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
            form1.action = "deleteCommentAction";
            form1.submit();
        }
        function refreshComment(){
            form1.action = "getBlogCommentsAction?page=<s:property value="#session.commentPageBean.currentPage"/>&id=<s:property value="id"/>";
            form1.submit();
        }
    </script>
</head>
<body>
<%--在首次进入查看博客页面的时候，当session里的pageBean为空的时候把页面重定向--%>
<s:if test="#session.pageBeanById == null">
    <script language="javascript" type="text/javascript">
        window.location.href='getBlogCommentsAction?page=1&id=<s:property value="id"/>';
    </script>
</s:if>
<form method="post" action="" id="listform" name="form1">
    <div class="panel admin-panel">
        <div class="panel-head"><strong class="icon-reorder">内容列表</strong> <a href="" style="float:right; display:none;">添加字段</a></div>
        <div class="padding border-bottom">
            <ul class="search" style="padding-left:10px;">
                <li>
                    <input type="text" placeholder="请输入关键字(支持模糊查询)" name="keywords" value="<s:property value="keywords"/>" class="input" style="width:250px; line-height:17px;display:inline-block" />
                    <input type="submit" class="button border-main icon-search" value="搜索" onclick=""/>
                </li>
                <li>
                    <input type="submit" class="button border-main icon-refresh" onclick="refreshComment()" value="刷新"/>
                </li>
            </ul>
        </div>
        <table class="table table-hover text-center">
            <tr>
                <th width="100" style="text-align:left; padding-left:20px;">ID</th>
                <th>游客</th>
                <th>博客标题</th>
                <th>评论内容</th>
                <th width="10%">评论时间</th>
                <th width="300"></th>
            </tr>
            <volist name="list" id="vo">
                <s:iterator value="#session.pageBeanById.clist1" status="st">
                    <tr>
                        <td style="text-align:left; padding-left:20px;"><input type="checkbox" name="delid" value="${id}" id="delid[#st.index]"/><s:property value="id"/></td>
                        <td><s:property value="visitor.visName"/></td>
                        <td><s:property value="blog.title" /></td>
                        <td><s:property value="content" /></td>
                        <td><s:property value="time" /></td>
                        <td>...</td>
                    </tr>
                </s:iterator>
                <tr>
                    <td colspan="7" style="text-align:left;padding-left:20px;"><input type="submit" class="button border-red icon-trash-o" style="padding:5px 15px;" onclick="deleteComments()" value="删除"/> <a href="javascript:void(0)" style="padding:5px 15px; margin:0 10px;" class="button border-blue icon-edit"> 排序</a>
                </tr>
                <tr>
                    <td colspan="8">
                        <div class="pagelist">
                            <s:if test="#session.pageBeanById.currentPage == 1">
                                首页&nbsp;&nbsp;&nbsp;上一页
                            </s:if>
                            <s:else>
                                <a href="getBlogCommentsAction?page=1&id=<s:property value="id"/>">首页</a>
                                &nbsp;&nbsp;&nbsp;
                                <a href="getBlogCommentsAction?page=<s:property value="#session.pageBeanById.currentPage - 1"/>&id=<s:property value="id"/>">上一页</a>
                            </s:else>
                            <s:if test="#session.pageBeanById.currentPage != #session.pageBeanById.totalPage">
                                <a href="getBlogCommentsAction?page=<s:property value="#session.pageBeanById.currentPage + 1"/>&id=<s:property value="id"/>">下一页</a>
                                &nbsp;&nbsp;&nbsp;
                                <a href="getBlogCommentsAction?page=<s:property value="#session.pageBeanById.totalPage"/>&id=<s:property value="id"/>">尾页</a>
                            </s:if>
                            <s:else>
                                下一页&nbsp;&nbsp;&nbsp;尾页
                            </s:else>
                        </div>
                    </td>
                </tr>
            </volist>
        </table>
    </div>
</form>
</body>
</html>
