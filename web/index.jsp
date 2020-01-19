<%--
  Created by IntelliJ IDEA.
  User: ananthgoyal
  Date: 2019-05-15
  Time: 22:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="Database.DocsTeach" %>
<%@ page import="Database.Phrase" %>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Source Extractor</title>
</head>



<body style="background-color:lightyellow;">
<h1><center>Super Search Algorithm</center></h1>
<center><p>By Ananth Goyal and Dev Gupta</p></center>


<form action="Notice.jsp" method="GET">
  <center>
    <br><br><br><br><br><br><br><br><br><br>
    <center>
      Research Subjects: <select name = "topic">
      <option value="history">History</option>
      <option value="medicine">Medicine</option>

    </select>


    </center><br>

    <%--<%=Database.DocsTeach.check()%>--%>
    Search Sources: <input type="text" name="fname"></form>
<br>
<br>

<script>{
  var doc = document.getElementById("fname/topic").value;
}
</script>





<br>
<br><input type="submit" value="Submit">
</center>

</body>
</html>
