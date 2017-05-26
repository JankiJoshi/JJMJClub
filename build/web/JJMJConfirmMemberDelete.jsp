<%-- 
    Document   : JJMJConfirmMemberDelete
    Created on : Mar 29, 2017, 5:44:39 PM
    Author     : mjanes5520
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<jsp:include page="JJMJBanner.jsp"/><br>
<body>
    <h2> Do you want to delete this member? </h2>

    <form method="post" action="JJMJMemberAdmin">
        <input type="hidden" name="email" value="${memberList.emailAddress}">
        <input type="hidden" name="action" value="deleteMember">
        <div id="displayDiv">
            <p class="displayInfo">
                <label class="displayLabels">Full Name:</label>
                <span>${memberList.fullName}</span><br>
            </p>        
            <p class="displayInfo">
                <label class="displayLabels">Email: </label>
                <span>${memberList.emailAddress}</span><br>
            </p>        
            <p class="displayInfo">           
                <label class="displayLabels">Phone: </label>
                <span>${memberList.phoneNumber}</span><br>
            </p>
            <p class="displayInfo">           
                <label class="displayLabels">IT Program: </label>
                <span>${memberList.programName}</span><br>
            </p>
            <p class="displayInfo">
                <label class="displayLabels">Year Level: </label>
                <span>${memberList.yearLevel}</span><br>
            </p>
        </div>

        <button type="submit">Yes</button>
        <a href="<c:url value='JJMJMemberAdmin?action=displayMembers'/>"><button type="button">No</button></a>
    </form>

</body>

<jsp:include page="JJMJFooter.jsp"/><br>
