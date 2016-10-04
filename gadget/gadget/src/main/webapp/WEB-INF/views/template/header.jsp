<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<title>Gadgets</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    
 <!-- Angular.JS -->
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.1/angular.min.js"></script>

    <!-- JQuery -->
    <script src="https://code.jquery.com/jquery-2.2.1.min.js"></script>
    <script src="https://cdn.datatables.net/1.10.10/js/jquery.dataTables.min.js"></script>


    <!-- Bootstrap core CSS -->
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">

    <!-- MaCarouselin CSS -->
    <link href="<c:url value="/resources/css/carousel.css" />" rel="stylesheet">

    <!-- Main CSS -->
    <link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">


    <link href="https://cdn.datatables.net/1.10.10/css/jquery.dataTables.min.css" rel="stylesheet">


    
    <style>
    /* Remove the navbar's default margin-bottom and rounded borders */
    
.navbar {
      margin-bottom: 0;
      border-radius: 0;
    }
    
    /* Add a gray background color and some padding to the footer */
    header {
      background-color: #f2f2f2;
      padding: 25px;
    }
  </style>
</head>

    <!-- Angular.JS -->
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.1/angular.min.js"></script>

    <!-- JQuery -->
    <script src="https://code.jquery.com/jquery-2.2.1.min.js"></script>
    <script src="https://cdn.datatables.net/1.10.10/js/jquery.dataTables.min.js"></script>


    <!-- Bootstrap core CSS -->
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
	
		 <!-- MaCarouselin CSS -->
    <link href="<c:url value="/resources/css/carousel.css" />" rel="stylesheet">
	
    

    <!-- Main CSS -->
    <link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">


    <link href="https://cdn.datatables.net/1.10.10/css/jquery.dataTables.min.css" rel="stylesheet">
    
<body>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
                    <a class="navbar-brand" href="#">Gadgets</a>
                </div>
                <div class="collapse navbar-collapse" id="myNavbar">
      				<ul class="nav navbar-nav">
                        <li><a href="<c:url value="/" />">Home</a></li>
                        <li><a href="<c:url value="/product/productList/all" />">Products</a></li>
                        <li><a href="<c:url value="/about" />">About Us</a></li>
                    </ul>
                    <ul class="nav navbar-nav pull-right">
                        <c:if test="${pageContext.request.userPrincipal.name != null}">
                            <li><a>Welcome: ${pageContext.request.userPrincipal.name}</a></li>
                            <li><a href="<c:url value="/j_spring_security_logout" />">Logout</a></li>

                            <c:if test="${pageContext.request.userPrincipal.name != 'admin'}">
                                <li><a href="<c:url value="/customer/cart" />">Cart</a></li>
                            </c:if>

                            <c:if test="${pageContext.request.userPrincipal.name == 'admin'}">
                                <li><a href="<c:url value="/admin" />">Admin</a></li>
                            </c:if>

                        </c:if>

                        <c:if test="${pageContext.request.userPrincipal.name == null}">
                            <li><a href="<c:url value="/login" />">Login</a></li>
                            <li><a href="<c:url value="/register" />">Register</a></li>
                        </c:if>
                    </ul>
                </div>
            </div>
        </nav>