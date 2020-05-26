<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>


    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="generator" content="Jekyll v3.8.6">    

    <link rel="canonical" href="https://getbootstrap.com/docs/4.4/examples/album/">

    <!-- Bootstrap core CSS -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

<style type="text/css">
body{
	background-color: silver;
}

#countryMenu{
	color:black;
}
#countrySubmit{
	background-color: gray;
	text-align: center;
	color: white;
}

p,form {
  text-align: left;
  font-family: Century;
  color:black;
  font-size: 15px;
  padding-top: 12px;
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
        <strong>Country selection menu </strong>
      </a>
     </div>
  </div>
</header>




<section class="jumbotron text-center">
    <div class="container">
<form action="" id="countries" enctype="multipart/form-data" onsubmit="checkChoice()" >
<p id="countryMenu">Select countries from country menu</p>
<th><input type="checkbox" onchange="checkAll(this)" name="chk[]" /> </th>
<label for = "chk[]">Select all</label>
 <c:forEach var="country" items="${countryList}">
	 <br><input type="checkbox" name="selectedCountries[]" value=${country} >
	 <label for = "country"> ${country}</label> 
	  
	</c:forEach>
	<br>
<input type="submit" value="submit" id="countrySubmit" />
	
</form>

</div>
</section>

<script type="text/javascript">
function checkAll(ele) {
    var checkboxes = document.getElementsByTagName('input');
    if (ele.checked) {
        for (var i = 0; i < checkboxes.length; i++) {
            if (checkboxes[i].type == 'checkbox') {
                checkboxes[i].checked = true;
            }
        }
    } else {
        for (var i = 0; i < checkboxes.length; i++) {
            console.log(i)
            if (checkboxes[i].type == 'checkbox') {
                checkboxes[i].checked = false;
            }
        }
    }
}
function checkChoice(){
		var x ="${outageStatusChoice}";
		
		if(x=='Enable'){
			console.log("in checkChoice");
			document.getElementById("countries").action="fileUpload";
			document.getElementById("countries").method="post";
		}
		else{
			console.log("in checkChoice");
			document.getElementById("countries").action="disableOutageStatus";
			document.getElementById("countries").method="post";
		}
		
}

</script>

</body>

</html>
