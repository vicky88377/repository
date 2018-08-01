<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Player Management Screen</title>
</head>
<body>
	<div align="center">
		<h1>Player List</h1>
		
		<table border="1">

			<th>Name</th>
			<th>Category</th>
			<th>Matches</th>
			<th>Wickets</th>
			<th>Action</th>

			<c:forEach var="player" items="${listPlayer}">
				<tr>

					<td>${player.name}</td>
					<td>${player.category}</td>
					<td>${player.matches}</td>
					<td>${player.wickets}</td>
					<td><a href="editPlayer?id=${player.id}">Edit</a>
						&nbsp;&nbsp;&nbsp;&nbsp; <a
						href="deletePlayer?id=${player.id}">Delete</a></td>

				</tr>
			</c:forEach>
		</table>
		<h4>
			New Player Register <a href="newPlayer">here</a>
		</h4>
	</div>
</body>
</html>