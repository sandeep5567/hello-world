<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Bootstrap Case</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</head>


<nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">Gadgets</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="#">Home</a></li>
      <li><a href="#">Login</a></li>
      <li><a href="#">Sign up</a></li>
      <li><a href="#">Products</a></li>
    </ul>
  </div>
</nav>
  <body>
  <div class="container">
  <br>
  <div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
      <li data-target="#myCarousel" data-slide-to="3"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner" role="listbox">
      <div class="item active">
        <img src="I Phone.jpg" alt="I Phone" width="500" height="500">
      </div>

      <div class="item">
        <img src="moto 360.jpg" alt="moto 360" width="500" height="500">
      </div>
    
      <div class="item">
        <img src="sony z5.jpg" alt="sony z5" width="500" height="500">
      </div>

      <div class="item">
        <img src="nikon.jpg" alt="nikon" width="500" height="500">
      </div>
    </div>

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>
</div>

</body>
<div class="container">

</div>

</body>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="container">
  <div class="row">
    <div class="col-md-4">
      <a href="4.jpg" class="thumbnail">
          
        <img src="laptop.jpg" alt="laptop" style="width:500px;height:500px">
      </a>
    </div>
    <div class="col-md-4">
      <a href="5.jpg" class="thumbnail">
       
        <img src="television.jpg" alt="television" style="width:500px;height:400px">
      </a>
    </div>
    <div class="col-md-4">
      <a href="speakers.jpg" class="thumbnail">
        
        <img src="speakers.jpg" alt="speakers" style="width:500px;height:400px">
      </a>
    </div>
  </div>
</div>
</body>
</html>