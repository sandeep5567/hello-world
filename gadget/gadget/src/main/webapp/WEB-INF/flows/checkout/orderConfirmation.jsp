<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="/WEB-INF/views/template/header.jsp" %>

<jsp:useBean id="now" class="java.util.Date" />

<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Order</h1>

            <p class="lead">Order confirmation</p>
        </div>

        <div class="container">

            <div class="row">

                <form:form commandName="order" class="form-horizontal">

                    <div class="well col-xs-10 col-sm-10 col-md-6 col-xs-offset-1 col-sm-offset-1 col-md-offset-3">

                       <div class="txt-center">
                            <h1>Receipt</h1>
                       </div>
                        <div class="row">
                            <div class="col-xs-6 col-sm-6 col-md-6">
                                <address>
                                    <strong>Shipping Address</strong><br/>
                                    ${order.cart.customer.shippingAddress.streetName}
                                <br/>
                                    ${order.cart.customer.shippingAddress.city}, ${order.cart.customer.shippingAddress.state}
                                <br/>
                                     ${order.cart.customer.shippingAddress.country}, ${order.cart.customer.shippingAddress.zipCode}
                                </address>
                            </div>
                            <div class="col-xs-6 col-sm-6 col-md-6 text-right">
                                <p>Shipping Date: <fmt:formatDate type="date" value="${now}" /></p>
                            </div>
                        </div>

                        <div class="row">
                            <div class="col-xs-6 col-sm-6 col-md-6">
                                <address>
                                    <strong>Billing Address</strong><br/>
                                        ${order.cart.customer.billingAddress.streetName}
                                    <br/>
                                        ${order.cart.customer.billingAddress.city}, ${order.cart.customer.billingAddress.state}
                                    <br/>
                                        ${order.cart.customer.billingAddress.country}, ${order.cart.customer.billingAddress.zipCode}
                                </address>
                            </div>
                        </div>

                        <div class="row">
                            <table class="table table-hover">
                                <thead>
                                    <tr>
                                        <th>Product</th>
                                        <th>Quantity</th>
                                        <th class="text-center">Price</th>
                                        <th class="text-center">Total</th>
                                    </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="cartItem" items="${order.cart.cartItems}">
                                    <tr>
                                        <th class="col-md-9"><em>${cartItem.product.productName}</em></th>
                                        <th class="col-md-1" style="text-align: center">&#8377 ${cartItem.product.productPrice}</th>                                        
                                        <th class="col-md-1" style="text-align: center">${cartItem.quantity}</th>
                                        <th class="col-md-1" style="text-align: center">&#8377 ${cartItem.totalPrice}</th>
                                    </tr>
                                </c:forEach>

                                <tr>
                                    <th></th>
                                    <th></th>
                                    <td class="text-right">
                                        <h4><strong>Grand Total:</strong></h4>
                                    </th>
                                    <th class="text-center text-danger">
                                        <h4><strong>&#8377 ${order.cart.grandTotal}</strong></h4>
                                    </th>
                                </tr>

                                </tbody>
                            </table>
                        </div>


                        <input type="hidden" name="_flowExecutionKey" />

                        <br/><br/>

                        <button class="btn btn-default" name="_eventId_backToCollectShippingDetail">Back</button>

                        <input type="submit" value="Submit Order" class="btn btn-default" name="_eventId_orderConfirmed" />

                        <button class="btn btn-default" name="_eventId_cancel">Cancel</button>
                    </div>
                </form:form>
            </div>
        </div>

<%@ include file="/WEB-INF/views/template/footer.jsp" %>