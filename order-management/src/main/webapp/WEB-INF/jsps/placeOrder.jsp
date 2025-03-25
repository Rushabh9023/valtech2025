<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="placeOrder">
		<table >
		
			<tr>
				<td>Customer Id:-</td>
				<td><input type="text" name="customerId" /></td>
			</tr>
			<tr>
				<td>Item Id:-</td>
				<td><input type="text" name="itemId" /></td>
			</tr>
			<tr>
				<td>Quantity:-</td>
				<td><input type="text" name="quentity" /></td>
			
			<tr>
				<td colspan="2">
				<input name="action" value="Place Order" type="submit" />
				<input name="action" value="Cancle" type="reset" />
				</td>
				
			</tr>
		</table>
	</form>
</body>
</html>