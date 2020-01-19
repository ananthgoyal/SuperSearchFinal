<%@ page import="Database.DocsTeach" %><%--
  Created by IntelliJ IDEA.
  User: ananthgoyal
  Date: 2020-01-19
  Time: 06:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Case Law Output</title>
</head>
<body style="background-color:lightyellow;">
<center>

<a href="https://codes.findlaw.com/LCsearch.html#?cludoquery=<%out.println(DocsTeach.phrase);%>&cludoCategory=Codes&cludopage=1&cludorefurl=https%3A%2F%2Fcaselaw.findlaw.com%2F&cludorefpt=Caselaw%3A%20Cases%20and%20Codes%20-%20FindLaw%20Caselaw&cludorefact=<%out.println(DocsTeach.phrase);%>&cludorefaci=1" target="_blank">Find Law Database</a>
<br>
<a href="https://scholar.google.com/scholar?hl=en&as_sdt=2006&q=<%out.println(DocsTeach.phrase);%>&btnG=" target="_blank">Google Scholar Database</a>

</center>
</body>
</html>
