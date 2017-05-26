<%-- 
    Matthew Janes - Janki Joshi
    3/29/2017
    Assignment 3
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<jsp:include page="JJMJBanner.jsp"/><br>

<h2>List of Books</h2>
<table>
    <tr>
        <td>Code</td>
        <td>Description</td>
        <td>Quantity</td>
    </tr>
    <c:forEach var="item" items="${ReadBooks}">
        <tr>
            <td>${item.code}</td>
            <td>${item.description}</td>
            <td>${item.quantity}</td>
        </tr>
    </c:forEach>
</table>         

<a href="JJMJAddBook.jsp"><button type="button">Add Book</button></a>

<jsp:include page="JJMJFooter.jsp"/><br>

