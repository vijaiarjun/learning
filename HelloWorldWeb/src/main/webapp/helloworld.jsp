<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>  
<head>
<!-- Load jQuery -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
</head>
<body>  
<h1>Integrated with Git now!</h1>
<h2>New Enhancement  development</h2>
<h3>check out from local branch</h3>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<form action="acceptFormData">
	<input type="text" 	name="helloworldtext"/>
	<input type="submit" value="Submit"/>
</form>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
The input data from the form is ${helloworldoutput}
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
Sorted Output is ${sortedDatabaseOutput}
<br/>
<br/>
<br/>
<br/>
<br/>

<c:forEach var="data" items="${sortedDatabaseOutput}">
   Value is ${data} <br/>
</c:forEach>

<br/>
<br/>
<br/>
<br/>
<br/>
<br/>

<c:forEach var="restData" items="${restOutput}">
   Key is ${restData.key}<br/>
   Value is ${restData.value}
   <script type="text/javascript">
   	var jsonResponse = '${restData.value}';
   </script>
</c:forEach>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<script type="text/javascript">
	document.write("JSON JS = " + jsonResponse.result);
</script>

<br/>
<br/>
<br/>
<br/>
<br/>
<br/>


Output is ${databaseOutput}
<br/>
<br/>
<br/>
<br/>
<br/>

<c:forEach var="data" items="${databaseOutput}">
   Value is ${data} <br/>
</c:forEach>

<br/>
<br/>
<br/>
<br/>
<br/>
<br/>


Create a Product and store in Database Here
<br/>
<form action="createProduct" method="POST">
	ID <input type="text" name="id"/><br/>
	Identifier <input type="text" name="identifier"/><br/>
	Part Number<input type="text" name="partnumber"/><br/>
	Status <input type="text" name="status"/><br/>
	<input type="submit" value="Create Product"/><br/>
</form>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>

The newly created product is ${createdProduct}


</body>  
</html>  