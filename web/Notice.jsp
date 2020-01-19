<%@ page import="Database.DocsTeach" %>
<%@ page import="javax.print.Doc" %><%--
  Created by IntelliJ IDEA.
  User: ananthgoyal
  Date: 2019-05-16
  Time: 18:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<body style="background-color:lightyellow;"; onload="load()";>

<%DocsTeach.phrase = request.getParameter("fname");
/*
    DocsTeach.isUS  = request.getParameter("USA");
    DocsTeach.isImage =  request.getParameter("Images");
    DocsTeach.isGeneral =  request.getParameter("General");
    DocsTeach.isCartoon  =  request.getParameter("Cartoons");


    if(DocsTeach.isUS==null)
        DocsTeach.isUS  = "";
    if(DocsTeach.isImage==null)
        DocsTeach.isImage  = "";
    if(DocsTeach.isGeneral==null)
        DocsTeach.isGeneral  = "";
    if(DocsTeach.isCartoon==null)
        DocsTeach.isCartoon="";
*/

%>

<script type="text/javascript">
    urlParams = new URLSearchParams(window.location.search);
    myParam = urlParams.get('topic');
    function load()
    {


            if(myParam=='history') {
                window.open('historicalResults.jsp')
            }
            else if(myParam=='science'){
                window.open('scienceResults.jsp')
            }
            else if(myParam=='medicine'){
                window.open('medicineResults.jsp')
            }
            else if(myParam=='literature'){
                window.open('literatureResults.jsp')
            }




    }
</script>

<title>Fetching</title>
<center><h1>Fetching Data</h1></center>
<br>




</head>

</body>

</html>
