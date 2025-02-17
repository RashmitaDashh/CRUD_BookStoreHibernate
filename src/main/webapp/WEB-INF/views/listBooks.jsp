<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@ page import="java.util.List"%>
<%@ page import="com.hibernateCrud.CRUD_hibernate.entities.Book"%>

<%@ page isELIgnored="false"%>

<html>
<head>
<meta charset="UTF-8">
<title>BookList page</title>
</head>
<body>
	<h1>Book List</h1>
	
	<!-- Link to Create Book -->
    <a href="toCreateBook" style="text-decoration: none; background-color: #4CAF50; color: white; padding: 10px 15px; border-radius: 5px;">Add New Book</a>
    <br><br>
	
	<%
		List<Book> books = (List<Book>) request.getAttribute("books");
			if (books != null && !books.isEmpty()) {
		%>
	<table border="1">
		<tr>
			<th>Book ID</th>
			<th>Book Name</th>
			<th>Author</th>
			<th>Language</th>
			<th>Publisher</th>
			<th>Seller</th>
		</tr>
		<%
		for (Book book : books) {
		%>
		<tr>
			<td><%=book.getId()%></td>
			<td><%=book.getName()%></td>
			<td><%=book.getAuthor()%></td>
			<td><%=book.getLanguage()%></td>
			<td><%=book.getPublisher()%></td>
			<td><%=book.getSeller()%></td>

			<td><a href="toUpdateBook?id=<%=book.getId()%>">Update</a>
			<a href="toDeleteBook?id=<%=book.getId()%>"
				onclick="return confirm('Are you sure you want to delete this book?')">Delete</a>
			</td>
		</tr>
		<%
		}
		%>
	</table>
	<%
	} else {
	%>
	<p>No books found!</p>
	<%
	}
	%>
</body>
</html>