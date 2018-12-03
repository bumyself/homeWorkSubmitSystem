<%@ taglib prefix="s" uri="/struts-tags" %>

<%--
  Created by IntelliJ IDEA.
  User: 11955
  Date: 2018/11/23
  Time: 8:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>


    <s:form action="downloadAction">
        <s:textfield name="targetUrl" label="url"/>
        <s:submit label="搜索"/>
    </s:form>
</body>
</html>
