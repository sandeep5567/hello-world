<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>  
<html>  
<script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>  

<body>  
<form:form action="screenText" method="Post">
<div ng-app="">  
  
    First Name: <input type="text" ng-model="firstname">  
  
  <h2>You entered: {{firstname}}</h2> 
  
</div>  
<button type="submit" class="btn btn-default">Submit</button>
</form:form>   
</body>  
</html>  
