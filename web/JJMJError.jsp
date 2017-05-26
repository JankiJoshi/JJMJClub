<%-- 
    Matthew Janes - Janki Joshi
    3/29/2017
    Assignment 3
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<jsp:include page="JJMJBanner.jsp"/><br>

<h1>Java Error</h1>
<p>Sorry, Java has thrown an exception.</p>
<p>To continue, click the Back button.</p>

<h2>Details</h2>
<p>Type: ${pageContext.exception["class"]}</p>
<p>Message: ${pageContext.exception.message}</p>


<jsp:include page="JJMJFooter.jsp"/><br>


