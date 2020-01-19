<%--
  Created by IntelliJ IDEA.
  User: ananthgoyal
  Date: 2020-01-19
  Time: 03:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="Database.MedLine" %>
<%@ page import="Database.DocsTeach" %>

<html>
<head>
    <title>Medline</title>
</head>
<body style="background-color: lightyellow">

<pre><center><p>
<%
MedLine medLine = new MedLine("https://vsearch.nlm.nih.gov/vivisimo/cgi-bin/query-meta?query=" + DocsTeach.phrase + "&v%3Aproject=nlm-main-website");
out.println(medLine.intialRun());%>
</p></center></pre>

</body>
</html>
