<%-- 
    Matthew Janes - Janki Joshi
    3/29/2017
    Assignment 3
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">        
        <link rel="stylesheet" type="text/css" href="styles/main.css"/>
        <title> JJMJ Programming Club </title>
    </head>
    <body>
        <header>
            <div>
                <img id="iconImg" src="images/JJMJ-icon.png" alt="JJMJ Icon">
            </div>
            <div>
                <h1>JJMJ Computer Programming Club</h1>
                <h2>IT@Conestoga</h2>
            </div>      
            <div id="navbar">
                <span><a href="<c:url value='/JJMJIndex.jsp'></c:url>">Home</a></span>
                <span><a href="<c:url value='/JJMJMember.jsp'></c:url>">Register</a></span>                
                <span><a href="<c:url value='JJMJLoan'></c:url>">eloan</a></span>
                <span><a href="<c:url value='JJMJCart'></c:url>">eCart</a></span>
                <span><a href="<c:url value='/JJMJAdmin.jsp'></c:url>">Admin</a></span>
            </div>
        </header>

