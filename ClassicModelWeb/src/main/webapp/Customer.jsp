<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ferns
  Date: 12/2/2021
  Time: 4:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="row pt-4 align-items-center">
    <c:forEach items="${customers}" var="customer">
        ${customer.customerName},
        ${customer.city},
        ${customer.country},
        ${customer.phone},
        ${customer.role}
    </c:forEach>
</div>