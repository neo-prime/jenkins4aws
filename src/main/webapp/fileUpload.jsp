<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.io.*,java.util.*, javax.servlet.*" %>
<%@ page import="javax.servlet.http.*" %>
<%@ page import="org.apache.commons.fileupload.*" %>
<%@ page import="org.apache.commons.fileupload.disk.*" %>
<%@ page import="org.apache.commons.fileupload.servlet.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="generator" content="Jekyll v3.8.6">    

    <link rel="canonical" href="https://getbootstrap.com/docs/4.4/examples/album/">

    <!-- Bootstrap core CSS -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">


<style type="text/css">
body{
	background-color:silver;
}
h3{
	color:black;
	font-size: 25px;
	font-family: Century;
}
#fileSubmit{
	background-color: gray;
	color:white;
}

p,form {
  text-align: center;
  font-family: Century;
  color:black;
  font-size: 15px;
  padding-top: 10px;
  }
</style>
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
        <strong>File Selection menu</strong>
      </a>
     </div>
  </div>
</header>



<section class="jumbotron text-center">
    <div class="container">
<h3>Select the file you want to upload</h3>
<form method="POST" action="uploadAction" enctype="multipart/form-data">
    <input type="file" name="files" /><br/><br/>
    <input type="submit" id="fileSubmit" value="Submit" />
</form>

    </div>
</section>

<script>
	
</script>
</body>
</html>
 