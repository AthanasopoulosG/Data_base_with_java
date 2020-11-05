<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
body {
  background-image: url("https://tapoueh.org/img/database-background-11458.jpg");
  background-color:#bdbdbd;
  background-repeat: no-repeat; 
  background-size: cover;
}
table, th, td {
  border: 1px solid black;
  background: rgba(255, 255, 255, 0.3);
  padding:20px;
  text-align:center;
  word-wrap: break-word;
}
p{
font-size:1.3em;
}

.center {
  margin: auto;
}

.error {

	text-align:center;
	text-shadow:2px 2px #000000;
	color:red;
	
}

h2 {
	
	text-align:center;
	font-size:1.4em;
	text-shadow: 2px 2px  #000000;
	
}

</style>
</head>
<body >



	<p class="error"  ><%=request.getAttribute("str")%></p>


<h2>Product Summary</h2>

<table class="center">


	
	 <tr>
	 	<td><p>Barcode</p></td>
	 	<td><p>Product Name</p></td>
	 	<td><p>Product Color</p></td>
	 	<td><p>Product Information</p></td>
	 
	 </tr>
    <tr>
    	<td><%=request.getAttribute("barcode")%></td>   
        <td><%=request.getAttribute("Name")%></td>
        <td><%=request.getAttribute("Color")%></td>   
        <td><%=request.getAttribute("info")%></td>  
          
    </tr>
</table>

</body>
</html>