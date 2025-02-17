<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@ page import="java.util.List"%>
<%@ page import="com.hibernateCrud.CRUD_hibernate.entities.Book"%>

<%@ page isELIgnored="false"%>

<html>
<head>
<meta charset="UTF-8">
<title>UpdateBook page</title>
</head>
<body>
<h1> Update Book </h1>

<form action="${pageContext.request.contextPath}/updateBook" method="post">

		<%
		Book book = new Book();
		%>

        <label for="id">Book ID:</label>
        <input type="text" id="id" name="id" readonly value="${book.id}">
        <br><br>
        
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" value="${book.name}" required>
        <br><br>
        
        <label for="email">Email:</label>
        <input type="text" id="email" name="email" value="${book.author}" required>
        <br><br>
        
        <label for="language">language :</label>
        <input type="text" id="language" name="language" value="${book.language}" required>
        <br><br>
        
        <label for="seller">Seller :</label>
        <input type="text" id="seller" name="seller" value="${book.seller}" required>
        <br><br>
        
        <label for="publisher">Publisher :</label>
        <input type="text" id="publisher" name="publisher" value="${book.publisher}" required>
        <br><br>
        
        
        <%-- <label>Gender:</label>
        <input type="radio" id="male" name="gender" value="Male" ${user.gender == 'Male' ? 'checked' : ''}>
        <label for="male">Male</label>
        <input type="radio" id="female" name="gender" value="Female" ${user.gender == 'Female' ? 'checked' : ''}>
        <label for="female">Female</label>
        <input type="radio" id="other" name="gender" value="Other" ${user.gender == 'Other' ? 'checked' : ''}>
        <label for="other">Other</label>
        <br><br> --%>
        
        <button type="submit"> Submit </button>
    </form>
    <br>
    <a href="${pageContext.request.contextPath}/toAllBooks">Back to Book List</a>

</body>
</html>