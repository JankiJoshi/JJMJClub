<%-- 
    Matthew Janes - Janki Joshi
    3/29/2017
    Assignment 3
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:include page="JJMJBanner.jsp"/><br>
<body>
    <h2> Your Loan Cart </h2>
    <table>
        <tr>
            <td><b>Code</b></td>      
            <td><b>Description</b></td>
            <td><b>Quantity</b></td>
        </tr>

        <c:set var="quantity" scope="session" value="${0}"></c:set>
        <c:choose>
            <c:when test="${sessionScope.loanCart != null}">
                <c:forEach var="item" items="${sessionScope.loanCart.items}">
                    <tr>
                        <td><c:out value="${item.code}"/></td> 
                        <td><c:out value="${item.description}"/></td>
                        <td align="right"><c:out value="${item.quantity}"/></td>
                        <c:set var="quantity" scope="session" value="${quantity + item.quantity}"></c:set>
                    </tr>
                </c:forEach>                 
                <tr>                    
                    <td></td>
                    <td align="right"><c:out value="Total:"/></td>
                    <td align="right"><c:out value="${quantity}"/></td>
                </tr>
            </c:when>
            <c:otherwise>
                <tr>
                    <td>All items have been removed from your cart!</td>
                </tr>
            </c:otherwise>
        </c:choose>
    </table>   
    <p><a href="JJMJClearCart">Clear the cart</a></p>
    <p><a href="JJMJELoan.jsp">Return to eLoan</a></p>        
</body>
<jsp:include page="JJMJFooter.jsp"/><br>
