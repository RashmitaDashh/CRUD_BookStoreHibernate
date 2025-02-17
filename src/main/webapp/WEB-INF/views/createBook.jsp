<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@ page import="java.util.List"%>
<%@ page import="com.hibernateCrud.CRUD_hibernate.entities.Book"%>

<%@ page isELIgnored="false"%>

<html>
<head>
<meta charset="UTF-8">
<title> Add Book page </title>
</head>
<body>
<h1> Add Book </h1>

<form action="${pageContext.request.contextPath}/saveBook" method="post">
        <label for="name">Name :</label>
        <input type="text" id="name" name="name" required>
        <br><br>
        
        <label for="author">Author :</label>
        <input type="text" id="author" name="author" required>
        <br><br>
        
        <label for="language">Language :</label>
        <input type="text" id="language" name="language" required>
        <br><br>
        
        <label for="seller">Seller :</label>
        <input type="text" id="seller" name="seller" required>
        <br><br>
        
        <!-- <label>Gender :</label>
        <input type="radio" id="male" name="gender" value="Male" required>
        <label for="male">Male</label>
        <input type="radio" id="female" name="gender" value="Female" required>
        <label for="female">Female</label>
        <input type="radio" id="other" name="gender" value="Other" required>
        <label for="other">Other</label>
        <br><br> -->
        
        <label for="publisher">Publisher :</label>
        <input type="text" id="publisher" name="publisher" required>
        <br><br>
        
        <button type="submit"> Submit </button>
        
    </form>
    <br>
    <a href="${pageContext.request.contextPath}/toAllBooks">Back to Book List</a>

</body>
</html>