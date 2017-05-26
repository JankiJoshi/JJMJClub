<%-- 
    Matthew Janes - Janki Joshi
    3/29/2017
    Assignment 3
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:include page="JJMJBanner.jsp"/><br>

<table>
    <tr>
        <td>Code</td>      
        <td>Description</td>
        <td>QOH</td>
        <td>Action</td>
    </tr>
    <c:forEach var="item" items="${loanItems}">
        <tr>
            <td><c:out value="${item.code}"/></td> 
            <td><c:out value="${item.description}"/></td>
            <td align="right"><c:out value="${item.quantity}"/></td>
            <c:choose>
                <c:when test="${item.quantity > 0}">
                    <td>
                        <a href="<c:url 
                               value='/JJMJCart?action=reserve&code=${item.code}'/>">
                            Reserve
                        </a>
                    </td>
                </c:when>
                <c:otherwise>
                    <td>NA</td>
                </c:otherwise>
            </c:choose>
        </tr>
    </c:forEach>
</table>    

<jsp:include page="JJMJFooter.jsp"/><br>

