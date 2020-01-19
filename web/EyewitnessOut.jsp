<%--
  Created by IntelliJ IDEA.
  User: ananthgoyal
  Date: 2020-01-18
  Time: 18:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="Database.EyeWitness" %>
<%@ page import="Database.DocsTeach" %>

<html>
<head>
    <title>Eyewitness Database</title>
</head>
<body style="background-color: lightyellow">
<pre><center><p>
<%
    EyeWitness eyeWitness = new EyeWitness("https://www.google.com/search?q="+ DocsTeach.phrase + "&sa=Search&domains=eyewitnesstohistory.com&sitesearch=eyewitnesstohistory.com");
    out.println(eyeWitness.intialRun());
    //out.println(DocsTeach.phrase);
%>
</p></center></pre>

</body>
</html>
