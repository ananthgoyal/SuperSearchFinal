<%--
  Created by IntelliJ IDEA.
  User: ananthgoyal
  Date: 2020-01-18
  Time: 18:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="Database.Ancient" %>
<%@ page import="Database.DocsTeach" %>
<%@ page import="javax.print.Doc" %>
<html>
<head>
    <title>Ancient Database</title>
</head>
<body style="background-color:lightyellow;"; onload="load()";>
<pre><center><p>
<%
    Ancient ancient = new Ancient("https://www.ancient.eu/search/?q=" + DocsTeach.phrase + "&s=Search");
    out.println(ancient.intialRun());%>
</p></center></pre>

</body>
</html>
