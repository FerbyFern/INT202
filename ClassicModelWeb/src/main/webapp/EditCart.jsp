<%--Assign--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:choose>
  <c:when test="${cart==null || empty cart.allItem}">
    <h3 class="text-danger">No item in your shopping cart</h3>
  </c:when>
  <c:otherwise>
    <table class="table table-striped table-bordered w-100" id="table-edit-cart">
      <thead>
      <th>#</th>
      <th>Code</th>
      <th>Description</th>
      <th>Price</th>
      <th>Quantity</th>
      <th>Total</th>
      </thead>
      <tbody>
      <c:forEach items="${cart.allItem}" var="lineItem" varStatus="vs">
        <tr id="row-${vs.count}" style="">
          <td>${vs.count}</td>
          <td>${lineItem.product.id}</td>
          <td>${lineItem.product.productName}</td>
          <td>${lineItem.product.msrp}</td>
          <td><input id="${lineItem.product.id}" type="number" name="quantity" min="1" size="3"
                     value="${lineItem.quantity}"
                     onclick="updateCart(${lineItem.product.id},${vs.count},${lineItem.product.msrp})"></td>
          <td id="show-total-${vs.count}"><fmt:formatNumber pattern="#,###.00" value="${lineItem.total}"/></td>
          <td><button class="btn btn-primary" type="button" style="border-radius: 10px; background-color: #b84a62; border-color: #b84a62" onclick="removeItem(${lineItem.product.id},'row-${vs.count}')">remove</button></td>
        </tr>
      </c:forEach>
      </tbody>
    </table>
  </c:otherwise>
</c:choose>
<button id="update-cart" class="btn btn-primary" style="float: right; border-radius: 10px; background-color: #b84a62; border-color: #b84a62" type="button" onclick="viewCart()">Back to cart</button>
<button id="clear-cart" class="btn btn-primary" style="float: right; margin-right: 20px; border-radius: 10px; background-color: #4c243b; border-color: #4c243b" onclick="clearCart()">Clear cart</button>
