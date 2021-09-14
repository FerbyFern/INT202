<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
<%@ page import="java.util.Collection" %>
<%@ page import="sit.int202.simpleweb.models.Student" %>
  Created by IntelliJ IDEA.
  User: Khaitong Lim
  Date: 8/24/2021
  Time: 11:54 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student Listing ::</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <p class="h1">Student List ::</p>
    <div class="row">
        <%--
        <%
            Collection<Student> students = (Collection<Student>) request.getAttribute("students");
            int i = 1;
            String bg = null;
            for(Student st : students) {
                if (i++%2==0)
                    bg = "bg-light";
                else
                    bg = "bg-secondary";
        %>
        --%>
        <c:forEach items="${students}" var="student" varStatus="vs">
        <div class="col-2 p-2 m-2 border border-secondary
        ${vs.count%5==1 || vs.count%5==3 ? 'bg-primary' : 'bg-light'} <%--<%=bg%>--%>">

            <div>Id: ${student.id} <%--<%= st.getId()%>--%></div>
            <div>Name: ${student.name} <%--<%= st.getName()%>--%></div>
            <div>gpax: ${student.gpax} <%--<%= st.getGpax()%>--%></div>
        </div>
        </c:forEach>
        <%--<%}%>--%>
    </div>
</div>

</body>
</html>
