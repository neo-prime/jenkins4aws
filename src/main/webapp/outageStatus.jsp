<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>
	Current Outage status of Selected country <b><%=request.getParameter("country") %></b> is <b><%=request.getParameter("outageStatus") %></b>
</h1>	
	<form name="changeStatus" action="fileUpload.jsp">
	<input type="button" id="enableStatus" value="Enable" >
	<input type="button" id="disableStatus" value="Disable" >
	
	</form>

</body>
<script type="text/javascript">
    document.getElementById("enableStatus").onclick = function redirect() {
    	location.href = "fileUpload.jsp";
    };
    document.getElementById("disableStatus").onclick = function () {
    	location.href = "home.jsp";
    };
</script>
</html>
