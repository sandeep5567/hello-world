<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ include file="/WEB-INF/views/template/header.jsp" %>

<script>

    $(document).ready(function(){
        var searchCondition = '${searchCondition}';

        $('.table').DataTable({
            "lengthMenu": [[1,2,3,5,10, -1], [1,2,3,5,10, "All"]],
            "oSearch" : {"sSearch": searchCondition}
        });
    });
</script>

<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>All Products</h1>

            <p class="lead">Checkout all the awesome products available now!</p>
        </div>

        <table class="table table-striped table-hover">
            <thead>
                <tr class="bg-success">
                    <th>Pro Image</th>
                    <th>Product Name</th>
                    <th>Category</th>
                    <th>Condition</th>
                    <th>Price</th>
                    <th></th>
                </tr>
            </thead>
            <c:forEach items="${products}" var="product">
                <tr>
                    <th><img src="<c:url value="/resources/images/${product.productId}.png" />" alt="image" style="width:100%"/></th>
                    <th>${product.productName}</th>
                    <th>${product.productCategory}</th>
                    <th>${product.productCondition}</th>
                    <th>&#8377 ${product.productPrice} </th>
                    <th><a href="<spring:url value="/product/viewProduct/${product.productId}" />"><span class="glyphicon glyphicon-info-sign"></span></a></th>
                </tr>
            </c:forEach>
        </table>
        </div></div>
<br><br><br><br>
<%@ include file="/WEB-INF/views/template/footer.jsp" %>