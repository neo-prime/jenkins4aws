<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en" xmlns:th="http://www.thymeleaf.org">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

<style type="text/css">
body{
	background-color: LightGray;
	
}
h3{
	color:Black;
	text-align: center;
  font-family: Century;
}
form {
  text-align: center;
  font-family: Century;
  color:black;
  font-size: 15px;
  padding-top: 10px;
  }
</style>
</head>
<body>


<section class="jumbotron text-center">
    <div class="container">

<form action="input">
<div th:if="${message}">
    <h3>${message}</h3>
</div>
<input type="submit" id="homePage" value="Home" >
</form>

    </div>
</section>
</body>
</html>