<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!doctype html>
<html ng-app="quiz" >
<head>
  <meta charset="utf-8">
  <title>Quiz Engine</title>
  <!-- <link href="http://twitter.github.com/bootstrap/assets/css/bootstrap.css" rel="stylesheet" /> 
   --><link rel="stylesheet" href="style.css">
 <!--  <script src="http//ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
  <script src="https://raw.github.com/twitter/bootstrap/master/docs/assets/js/bootstrap.js"></script>
  <script src="//ajax.googleapis.com/ajax/libs/angularjs/1.0.2/angular.js"></script> -->
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
  
  <script src="app.js"></script>
</head>
<body>
  <div ng-controller="QuizController">
    <ul class="unstyled">
      <li ng-repeat="question in questions">
       <strong class="question">{{question.questionText}}</strong>
       <ul class="unstyled" id="quest_{{$parent.$index}}">
        <li ng-repeat="answer in question.answers">
          <label class="isCorrect_{{answer.selected}}" for="quest_{{$parent.$index}}_answer_{{$index}}">
            <input type="radio" id="quest_{{$parent.$index}}_answer_{{$index}}" 
            ng-model="answers[$parent.$index]" value="{{ answer.answerText }}"  name="quest_{{$parent.$index}}_answers" />{{ answer.answerText }}</label>
        </li>
       </ul>
      </li>
    </ul>
    <button class="btn" type="submit" ng:click="showResult()">Submit</button>
  <div class="well">
    <p>you got {{ correctCount }} out of {{questions.length}} right</p>
    
  </div>
    
  </div>
  
 </body>
</html>
