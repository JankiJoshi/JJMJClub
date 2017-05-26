<%-- 
    Matthew Janes - Janki Joshi
    3/29/2017
    Assignment 3
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<jsp:include page="JJMJBanner.jsp"/><br>
<h1>Admin : Data Maintenance</h1>
<span><a href="<c:url value='JJMJDisplayBooks'/>">Maintain Books</a></span><br>
<span><a href="<c:url value='JJMJMemberAdmin?action=displayMembers'/>">Display of Members</a></span>           
<jsp:include page="JJMJFooter.jsp"/><br>

