<%@ taglib prefix="s" uri="/struts-tags" %>


<%--
  Created by IntelliJ IDEA.
  User: 11955
  Date: 2018/11/22
  Time: 14:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"  %>
<html>
  <head>
    <title>login</title>
  </head>
  <body>
  <%--style="background:url(wallPaper2.png)"--%>
  <br/>
  <br/>
  <br/>
  <br/>
  <br/>
  <br/>
  <br/>
  <br/>
  <center>
    <s:form action="loginAction">
      <s:textfield name="name" label="name"/>
      <s:textfield name="pass" label="pass"/>
      <s:submit label="submit them~" />
    </s:form>
  </center>




  </body>
</html>
