<%--
  Created by IntelliJ IDEA.
  User: ananthgoyal
  Date: 2020-01-19
  Time: 03:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="Database.PubMed" %>--%>
<%@ page import="Database.DocsTeach" %>

<html>
<head>
    <title>PubMed</title>

</head>
<body style="background-color: lightyellow">
<pre><center><p>
<%
    PubMed pubMed = new PubMed("https://www.ncbi.nlm.nih.gov/pubmed/?term=" + DocsTeach.phrase);
    out.println(pubMed.intialRun());%>
</p></center></pre>
</body>
</html>
