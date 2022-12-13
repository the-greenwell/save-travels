<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/main.css"/>
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<meta charset="UTF-8">
<title>Expenses - <c:out value="${expense.id}"/></title>
</head>
<body>
	<div class="container">
		<a href="/expense" class="btn btn-primary">Back</a>
		<p class="display-5 mt-3">Edit Expense</p>
		<div class="border container py-3">
			<form:form action="/expense/${expense.id}/edit" method="post" class="d-flex gap-3 flex-column" modelAttribute="expense">
				<input type="hidden" name="_method" value="put" />
				<div class="form-group">
				  	<form:label for="name" path="name">Enter the expense</form:label>
				  	<form:input type="text" class="form-control" id="name" path="name" value="${expense.name}" />
				  	<form:errors path="name" class="text-danger"/>
				</div>
				<div class="form-group">
				  	<form:label for="vendor" path="vendor">Enter the vendor</form:label>
				  	<form:input type="text" class="form-control" id="vendor" path="vendor" value="${expense.vendor}" />
				  	<form:errors path="vendor" class="text-danger"/>
				</div>
				<div class="form-group">
				  	<form:label for="amount" path="amount">Enter the price</form:label>
				  	<div class="d-flex align-items-center gap-1">$<form:input type="text" class="form-control" id="amount" path="amount" value="${expense.amount}" /></div>
				  	<form:errors path="amount" class="text-danger"/>
				</div>
				<div class="form-group">
			    	<form:label for="description" path="description">Description</form:label>
			    	<form:textarea class="form-control" id="description" path="description" rows="3" value="${expense.description}"></form:textarea>
				  	<form:errors path="description" class="text-danger"/>
			    </div>
			    <div class="d-flex justify-content-end">
			    	<button type="submit" class="btn btn-primary">Submit</button>
			    </div>
			</form:form>
		</div>
	</div>
</body>
</html>