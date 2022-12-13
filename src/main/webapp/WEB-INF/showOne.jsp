<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<title>Expenses - <c:out value="${expense.name}"/></title>
</head>
<body>
	<div class="container my-4">
		<a href="/expense" class="btn btn-primary">Back</a>
		<p class="display-3">Expense: <c:out value="${expense.name}"/></p>
		<p class="display-5">Vendor: <c:out value="${expense.vendor}"/></p>
		<p class="display-5">Amount: $<c:out value="${expense.amount}"/></p>
		<div class="container border">
			<p class="display-6">Description:</p>
			<p class="display-3"><c:out value="${expense.description}"/></p>
		</div>
	</div>	
</body>
</html>