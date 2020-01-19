<%@ page import="Database.LunaImaging" %>
<%@ page import="Database.DocsTeach" %><%--
  Created by IntelliJ IDEA.
  User: ananthgoyal
  Date: 2019-05-18
  Time: 12:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Images</title>
</head>

<center><h1>Images</h1></center>
<body style="background-color: lightyellow">

<pre><center><p>


    <% LunaImaging a = new LunaImaging("https://jcb.lunaimaging.com/luna/servlet/view/search?search=SUBMIT&q=" + DocsTeach.phrase + "&dateRangeStart=&dateRangeEnd=&QuickSearchA=QuickSearchA");
        out.println(a.intialRun());
        for(int i = 0;  i < a.num; i++){
            out.println(a.nameList.get(i));
    %>

    <img src="<%out.println(a.imageList.get(i));%>" alt="img">

    <%

            out.println();

            out.println();out.println();out.println();
        }


    %>
</p></center></pre>



</body>
</html>
