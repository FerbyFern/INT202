<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:choose>
    <c:when test="${cart==null || empty cart.allItem}">
        <h3 class="text-danger">No item in your shopping cart</h3>
    </c:when>
    <c:otherwise>
        <table class="table table-striped table-bordered w-100">
            <thead>
            <th>#</th>
            <th>Code</th>
            <th>Description</th>
            <th>Quantity</th>
            <th>Price</th>
            <th>Total</th>
            </thead>
            <tbody>
            <c:forEach items="${cart.allItem}" var="lineItem" varStatus="vs">
                <tr>
                    <td>${vs.count}</td>
                    <td>${lineItem.product.id}</td>
                    <td>${lineItem.product.productName}</td>
                    <td>${lineItem.quantity}</td>
                    <td>${lineItem.product.msrp}</td>
                    <td>${lineItem.total}</td>
                </tr>
            </c:forEach>
            <tr>
                <td colspan="5" style="text-align: right;margin-right: 5px">Total</td>
                <td><fmt:formatNumber pattern="#,###.00" value="${cart.totalPrice}"/></td>
            </tr>
            </tbody>
        </table>
        <%--Assign--%>
        <button id="edit-cart" class="btn btn-primary" style="float: right; border-radius: 10px; background-color: #b84a62; border-color: #b84a62" type="button" onclick="editCart()">Edit</button>
    </c:otherwise>
</c:choose>