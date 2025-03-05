<%@page import="assignment.servlets.entity.Employee"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<table>
		<tr>
			<th><a href="employees?operation=sort&sortBy=id&sortOrder=${sortOrder == 'asc' ? 'desc':'asc'}">Id ${sortOrder == 'desc' ? '(desc)':'(asc)'}</a></th>
			<th><a href="employees?operation=sort&sortBy=name&sortOrder=${sortOrder == 'asc' ? 'desc':'asc'}">Name ${sortOrder == 'desc' ? '(desc)':'(asc)'}</a></th>
			<th><a href="employees?operation=sort&sortBy=age&sortOrder=${sortOrder == 'asc' ? 'desc':'asc'}">Age ${sortOrder == 'desc' ? '(desc)':'(asc)'}</a></th>
			<th><a href="employees?operation=sort&sortBy=gender&sortOrder=${sortOrder == 'asc' ? 'desc':'asc'}">Gender ${sortOrder == 'desc' ? '(desc)':'(asc)'}</a></th>
			<th><a href="employees?operation=sort&sortBy=salary&sortOrder=${sortOrder == 'asc' ? 'desc':'asc'}">Salary ${sortOrder == 'desc' ? '(desc)':'(asc)'}</a></th>
			<th><a href="employees?operation=sort&sortBy=experience&sortOrder=${sortOrder == 'asc' ? 'desc':'asc'}">Experience ${sortOrder == 'desc' ? '(desc)':'(asc)'}</a></th>
			<th><a href="employees?operation=sort&sortBy=level&sortOrder=${sortOrder == 'asc' ? 'desc':'asc'}">Level ${sortOrder == 'desc' ? '(desc)':'(asc)'}}</a></th>
			<th><a href="employees?operation=sort&sortBy=deptid&sortOrder=${sortOrder == 'asc' ? 'desc':'asc'}">DeptId ${sortOrder == 'desc' ? '(desc)':'(asc)'}</a></th>
			<th>Actions</th>
		</tr>
		<c:forEach items="${emps}" var="e">
		<tr>
		<!-- We can write like both the ways Like below Also with c:out and without it also -->
		<td><c:out value="${e.id}"></c:out></td>
		<td>${e.name}</td>
		<td>${e.age}</td>
		<td>${e.gender}</td>
		<td>${e.salary}</td>
		<td>${e.experience}</td>
		<td>${e.level}</td>
		<td>${e.deptId}</td> 
		<td>
		<a href="employees?operation=Update&id=${e.id}">Update</a>
		<a href="employees?operation=Delete&id=${e.id}">Delete</a>
		</td>
		</tr>
		
		</c:forEach>
		<tr>
		<td colspan="7">
		<a href="employees?operation=new">New Employee</a>
		</td>
		</tr>
</table>	

</body>
</html>