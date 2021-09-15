<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <title>JSP - Hello World</title>
        <meta charset="utf-8">
        <meta name="viewpoint" content="width=widthdevice, intial-scal=1.0">
        <style>
            body {
                background: lavenderblush;
            }
            .box {
                display: inline-flex;
                border: 3px solid lightcoral;
                margin: 10px;
                padding: 5px;
                width: 30px;
                text-align: right;
                border-radius: 12%;
            }
        </style>
    </head>
    <body>
        <div style="padding: 10px;display: block;width: 50%;margin: auto">
            <%--><c:forEach begin="1" end="100" var="value">
                <div class="box">${value}</div>
            </c:forEach>--%>
            <h3>Menu</h3> <br>
            <a href="course-list">1) ลงทะเบียน </a> <br>
            <a href="course-registered-history">2) ประวัติการลงทะเบียน </a>
        </div>
    </body>
</html>