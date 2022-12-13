<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
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
<title>Expenses</title>
</head>
<body>
	<div class="container">
		<h1 class="display-6 py-3">Travel Expenses</h1>
		<div class="container border">
			<table class="table">
			  <thead>
			    <tr>
			      <th scope="col">Name</th>
			      <th scope="col">Vendor</th>
			      <th scope="col">Price</th>
			      <th scope="col">Actions</th>
			    </tr>
			  </thead>
			  <tbody>
				<c:forEach var="expense" items="${allExpenses}">
				    <tr>
				      <td><a href="/expense/${expense.id}">${expense.name}</a></td>
				      <td>${expense.vendor}</td>
				      <td>${expense.amount}</td>
				      <td class="d-flex gap-2">
				      	<a href="/expense/${expense.id}/edit" class="btn btn-success">Edit</a>
				      	<form action="/expense/${expense.id}" method="post">
				      		<input type="hidden" name="_method" value="delete">
				      		<button type="submit" class="btn btn-danger">Delete</button>
				      	</form>
				      </td>
				    </tr>
				</c:forEach>
			  </tbody>
			</table>
		</div>
		<p class="display-5 mt-3">New Expense</p>
		<div class="border container py-3 mb-3">
			<form:form action="/expense" method="post" class="d-flex gap-3 flex-column" modelAttribute="expense">
				<div class="form-group">
				  	<form:label for="name" path="name">Enter the expense</form:label>
				  	<form:input type="text" class="form-control" id="name" path="name" placeholder="Backpack" />
				  	<form:errors path="name" class="text-danger"/>
				</div>
				<div class="form-group">
				  	<form:label for="vendor" path="vendor">Enter the vendor</form:label>
				  	<form:input type="text" class="form-control" id="vendor" path="vendor" placeholder="Target" />
				  	<form:errors path="vendor" class="text-danger"/>
				</div>
				<div class="form-group">
				  	<form:label for="amount" path="amount">Enter the price</form:label>
				  	<div class="d-flex align-items-center gap-1">$<form:input type="text" class="form-control" id="amount" path="amount" placeholder="30" /></div>
				  	<form:errors path="amount" class="text-danger"/>
				</div>
				<div class="form-group">
			    	<form:label for="description" path="description">Description</form:label>
			    	<form:textarea class="form-control" id="description" path="description" rows="3" placeholder="Tie-Dye Color"></form:textarea>
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