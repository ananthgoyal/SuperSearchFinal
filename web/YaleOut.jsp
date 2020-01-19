<%--

  Created by IntelliJ IDEA.
  User: ananthgoyal
  Date: 2020-01-18
  Time: 18:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="Database.Yale" %>--%>
<%@ page import="Database.DocsTeach" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Yale Database Output</title>
</head>
<body style="background-color: lightyellow">
<pre><center><p>
<%
    Yale yaleSource = new Yale("https://www.google.com/search?domains=yale.edu&sitesearch=avalon.law.yale.edu%2F&q=" + DocsTeach.phrase+ "&x=0&y=0");
    out.println(yaleSource.intialRun());%>
</p></center></pre>
</body>
</html>
