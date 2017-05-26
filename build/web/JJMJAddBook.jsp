<%-- 
    Matthew Janes - Janki Joshi
    3/29/2017
    Assignment 3
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<jsp:include page="JJMJBanner.jsp"/><br>

<p style="color: red">${message}</p>

<form class="registerForm" method="post" action="JJMJAddBook">
    <h2>Add a Book</h2>

    <p>
        <label for="code">Code: </label>
        <input type="text" name="code" style="width: 200px" value="${book.code}"></input>
    </p>
    <p>
        <label for="description">Description: </label>
        <input type="text" name="description" style="width: 500px" value="${book.description}"></input>
    </p>
    <p>
        <label for="quantity">Quantity </label>
        <input type="text" name="quantity" style="width: 100px" value="${book.quantity}"></input>
    </p>

    <button type="submit" value="Save">Save</button>
    <a href="JJMJDisplayBooks"><button type="button">Cancel</button></a>

</form>

<jsp:include page="JJMJFooter.jsp"/><br>

