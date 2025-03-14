<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="items">
		<table >
		<tr>
		<td><input type="text" name="id" value="0" hidden="true"/></td>
		</tr>
			<tr>
				<td>Name:-</td>
				<td><input type="text" name="name" /></td>
			</tr>
			<tr>
				<td>Description:-</td>
				<td><input type="text" name="desc" /></td>
			</tr>
			<tr>
				<td>CurrentQuentity:-</td>
				<td><input type="text" name="currentQty" /></td>
			</tr>
			<tr>
				<td>ReorderQuentity:-</td>
				<td><input type="text" name="reorderQty" /></td>
			</tr>
			<tr>
				<td>MaxQuentity:-</td>
				<td><input type="text" name="maxQty" /></td>
			</tr>
			<tr>
				<td colspan="2">
				<input name="action" value="Add Item" type="submit" />
				<input name="action" value="Cancle" type="reset" />
				</td>
				
			</tr>
		</table>
	</form>
	<table border="1">
		<tr>
			<th>Id<th/>
			<th>Name</th>
			<th>Description</th>
			<th>CurrentQuentity</th>
		</tr>
		<c:forEach items="${item}" var="i">
		<tr>
			<td>${i.id}<td/>
			<td>${i.name}</td>
			<td>${i.desc}</td>
			<td>${i.currentQty}</td>
			<td hidden="true">${i.reorderQty}</td>
			<td hidden="true">${i.maxQty}</td>
			<tr/>
		</c:forEach>
	</table>

</body>
</html>