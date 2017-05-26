<%-- 
    Document   : JJMJDisplayMembers
    Created on : Mar 29, 2017, 5:30:22 PM
    Author     : mjanes5520
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<jsp:include page="JJMJBanner.jsp"/><br>
<body>
    <table>
    <tr>
        <td><srtong>Email</srtong></td>
        <td><strong>Program</strong></td>
        <td><strong>Year</strong></td>
    </tr>
    <c:forEach var="item" items="${memberList}">
        <tr>
            <td>${item.emailAddress}</td>
            <td>${item.programName}</td>
            <td>${item.yearLevel}</td>
            <td><a href="<c:url value='JJMJMemberAdmin?action=displayMember&email=${item.emailAddress}'/>">Update</a></td>
            <td><a href="<c:url value='JJMJMemberAdmin?action=confirmDeleteMember&email=${item.emailAddress}'/>">Delete</a></td>
        </tr>
    </c:forEach>
</table> 
    <a href="<c:url value='JJMJMemberAdmin?action=addMember'/>"><button>Add Member</button></a>
</body>
<jsp:include page="JJMJFooter.jsp"/><br>