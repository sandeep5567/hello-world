<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
<body ng-app="">

<form:form action="Qtext" method="Post">
 1.which is your favourite color?<br>
  <input type="radio" ng-model="myVar" value="red">Red
  <input type="radio" ng-model="myVar" value="blue">Blue
  <input type="radio" ng-model="myVar" value="green">Green
  <input type="radio" ng-model="myVar" value="Burgundy">Burgundy<br>
 2.which is your favourite Cuisine?<br>
  <input type="radio" ng-model="myVar" value="chinese">chinese
  <input type="radio" ng-model="myVar" value="mughlai">mughlai
  <input type="radio" ng-model="myVar" value="South Indian">South Indian
  <input type="radio" ng-model="myVar" value="Italian">Italian<br>
 3.which is your preffered Mobile OS?<br>
  <input type="radio" ng-model="myVar" value="Android">Android
  <input type="radio" ng-model="myVar" value="iOS">iOS
  <input type="radio" ng-model="myVar" value="Windows">Windows
  <input type="radio" ng-model="myVar" value="Firfox OS">Firfox OS<br>
 4.which is the most popular consumer brand in India?<br>
  <input type="radio" ng-model="myVar" value="GSK">GSK
  <input type="radio" ng-model="myVar" value="ITC">ITC
  <input type="radio" ng-model="myVar" value="PIDLITE">PIDLITE
  <input type="radio" ng-model="myVar" value="AMUL">AMUL
<br>
<button type="submit" class="btn btn-default">Submit</button>

</form:form>
</body>
</html>

