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
<style>
  .SearchBar input {
    height: 30px;
    width: 500px;
  }

  .Submit input {
    height: 30px;
    width: 75px;
  }
</style>


<body style="background-color:lightyellow;">
<h1 style="font-family:verdana;" ><center>Super Search Algorithm</center></h1>
<center><p>By Ananth Goyal, Dev Gupta, Devesh Panda, and Adil Ahmed</p></center>


<form action="Notice.jsp" method="GET">
  <center>
    <br><br><br><br><br><br><br><br><br><br>
      Research Subjects: <select name = "topic">
      <option value="history">History</option>
      <option value="medicine">Medicine</option>
      <option value="caseLaw">Case Law</option>
    </select>



    </center><br>

    <%--<%=Database.DocsTeach.check()%>--%>
  <div class="SearchBar">
    <form>
      Search Sources: <input type="text" name="fname"></form>
    <br>
    <br>

    <script>{
      var doc = document.getElementById("fname").value;
    }
    </script>


<img src="searchIMG.jpg" alt="searchBar" style="width:250px;height: 160px;px;position:absolute; top: 100px;left: 570px">

  <input type="submit" value="Submit">

<br>
<br>
  </div></form>


</center>

</body>
</html>
