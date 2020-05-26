<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="generator" content="Jekyll v3.8.6">    

    <link rel="canonical" href="https://getbootstrap.com/docs/4.4/examples/album/">

    <!-- Bootstrap core CSS -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

    
     <style>
body {
  background-color:silver ;
}

h1 {
  color: Gray;
  text-align: left;
}
#choice {
  color: black;
  text-align: center;
}
#choiceSubmit{
	color:white;
	background: gray;
}
p,form {
  text-align: center;
  font-family: Century;
  color:dark gray;
  font-size: 20px;
  padding-top: 10px;
}
</style>
   
    <!-- Custom styles for this template -->
    <link href="album.css" rel="stylesheet">
    
  </head>
  <body>
    <header>
  <div class="collapse bg-gray" id="navbarHeader">
    <div class="container">
      <div class="row">
        <div class="col-sm-8 col-md-7 py-4">
         </div>
      </div>
    </div>
  </div>
  <div class="navbar navbar-dark bg-dark shadow-sm">
    <div class="container d-flex justify-content-between">
      <a href="#" class="navbar-brand d-flex align-items-center">       
        <strong>Welcome to MIM page! </strong>
      </a>
     </div>
  </div>
</header>


<section class="jumbotron text-center">
    <div class="container">
    <p id="choice">
Select your choice and press next
</p>
	<form name="changeStatus" action="home" >
	<input type="radio" name="statusChoice" value="Enable" > Enable
	<input type="radio" name="statusChoice" value="Disable" > Disable
	<br><br><input type="submit" id="choiceSubmit" name="next" value="next">
	</form>
    
          
    </div>
</section>
