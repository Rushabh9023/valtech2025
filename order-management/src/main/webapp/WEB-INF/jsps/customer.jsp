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
<form method="post" action="customers">
		<table >
		<tr>
		<td><input type="text" name="custId" value="0" hidden="true"/></td>
		</tr>
			<tr>
				<td>Name:-</td>
				<td><input type="text" name="name" /></td>
			</tr>
			<tr>
				<td>Age:-</td>
				<td><input type="text" name="age" /></td>
			</tr>
			<tr>
				<td>Current Address:-</td>
				<td><input type="text" name="address" /></td>
			</tr>
			<tr>
				<td>Permanent Address:-</td>
				<td><input type="text" name="perAddress" /></td>
			</tr>
			<tr>
				
				<td><input type="text" name="status" value="ENABLED" hidden="true"/></td>
			</tr>
			<tr>
				<td colspan="2">
				<input name="action" value="Add Customer" type="submit" />
				<input name="action" value="Cancle" type="reset" />
				</td>
				
			</tr>
		</table>
	</form>
	 <table border="1">
		<tr>
			<th>Customer Id<th/>
			<th>Name</th>
			<th>Age</th>
			<th>Current Address</th>
			<th>Status</th>
		</tr>
		<c:forEach items="${customer}" var="c">
		<tr>
			<td>${c.custId}<td/>
			<td>${c.name}</td>
			<td>${c.age}</td>
			<td>${c.address}</td>
			<td hidden="true">${c.perAddress}</td>
			<td>${c.status}</td>
			<tr/>
		</c:forEach>
	</table> 
</body>
</html>