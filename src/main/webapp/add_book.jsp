<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="/index.jsp"></jsp:include>
	<div class="container">
	
	<h4>New Book Info</h4>
	<form action="addbook" method="post">
		
		<div class="alert-danger col-sm-5">${error_msg}</div>
		<div class="mb-4">
			<label class="form-label">Code</label>
		
		<div class="col-sm-3">
			<input type="text" name="code" class="form-control" value="${book.code}">
		</div>
		</div>
		<div class="mb-4">
			<label class="form-label">Name</label>
		
		<div class="col-sm-3">
			<input type="text" name="name" class="form-control" value="${book.name}">
		</div>
		</div>
		<div class="mb-4">
			<label class="form-label">Price</label>
		
		<div class="col-sm-3">
			<input type="number" name="price" class="form-control" value="${book.price}">
		</div>
		</div>
		<div class="mb-4">
			<label class="form-label">Author</label>
		
		<div class="col-sm-3">
			<input type="text" name="author" class="form-control" value="${book.author}">
		</div>
		</div>
		<div class="mb-4">
			<input type="submit" value="AddBook" class="btn-btn-primary">
		</div>
	</form>
	</div>

</body>
</html>