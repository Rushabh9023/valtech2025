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
	Counters = ${counters} Current Department = ${current}
	<hr>
	<form action="depts" method="post">
		<table>
			<tr>
				<td>Id</td>
				<td>${dept.id}</td>
			</tr>
			<tr>
				<td>Name</td>
				<td>${dept.name}</td>
			</tr>
			<tr>
				<td>Location</td>
				<td>${dept.location}</td>
			</tr>
			<tr>
			<td>
			<a href="depts?operation=Update&id=${dept.id}">Update</a>
			<a href="depts?operation=Delete&id=${dept.id}">Delete</a>
			</td>
			<td colspan="7">
			<a href="depts?operation=new">New Department</a>
			</td>
			</tr>
			<tr>
				<td colspan="2">
			    <input type="submit" name="operation" value="First" /> 
			    <input type="submit" name="operation" value="Previous" /> 
			    <input type="submit" name="operation" value="Next" /> 
			    <input type="submit" name="operation" value="Last" />
				</td>
			</tr>
			<tr>
			<td>Name</td>
			<td><input type="text" name="name" /></td>
			<tr/>
			<tr>
			<td>Age</td>
			<td><input type="text" name="age" /></td>
			<tr/>
			<tr>
			<td>Salary</td>
			<td><input type="text" name="salary" /></td>
			<tr/>
			<tr>
			<td>Level</td>
			<td><input type="text" name="level" /></td>
			<tr/>
			<tr>
			<td>Experience</td>
			<td><input type="text" name="experience" /></td>
			<tr/>
			<tr>
			<td><input type="submit" name="operation" value="Search" /></td>
			</tr>
			
			

<tr>
			<th><a href="depts?operation=sort&sortBy=id&sortOrder=${sortOrder}">Id ${sortOrder == 'desc' ? '(desc)':'(asc)'}</a></th>
			<th><a href="depts?operation=sort&sortBy=name&sortOrder=${sortOrder}"> Name ${sortOrder == 'desc' ? '(desc)' : '(asc)'}</a></th>
			<th><a href="depts?operation=sort&sortBy=age&sortOrder=${sortOrder}">Age ${sortOrder == 'desc' ? '(desc)':'(asc)'}</a></th>
			<th><a href="depts?operation=sort&sortBy=gender&sortOrder=${sortOrder}">Gender ${sortOrder == 'desc' ? '(desc)':'(asc)'}</a></th>
			<th><a href="depts?operation=sort&sortBy=salary&sortOrder=${sortOrder}">Salary ${sortOrder == 'desc' ? '(desc)':'(asc)'}</a></th>
			<th><a href="depts?operation=sort&sortBy=experience&sortOrder=${sortOrder}">Experience ${sortOrder == 'desc' ? '(desc)':'(asc)'}</a></th>
			<th><a href="depts?operation=sort&sortBy=level&sortOrder=${sortOrder}">Level ${sortOrder == 'desc' ? '(desc)':'(asc)'}}</a></th>
			<th><a href="depts?operation=sort&sortBy=deptid&sortOrder=${sortOrder}">DeptId </a></th>
			<!-- <th>Actions</th> -->
	</tr>
		<c:forEach items="${emplist}" var="e">
		<tr>
		<!-- We can write like both the ways Like below Also with c:out and without it also -->
		<td>${e.id}</td>
		<td>${e.name}</td>
		<td>${e.age}</td>
		<td>${e.gender}</td>
		<td>${e.salary}</td>
		<td>${e.experience}</td>
		<td>${e.level}</td>
		<td>${e.deptId}</td> 
		<tr/>
		</c:forEach>
		</table>
		
	</form>
</body>
</html>