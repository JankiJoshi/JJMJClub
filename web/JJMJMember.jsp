<%-- 
    Document   : JJMJMember
    Created on : Mar 29, 2017, 5:39:58 PM
    Author     : mjanes5520
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:include page="JJMJBanner.jsp"/><br>
<body>    
    <h2>New Member Registration Form</h2>
    <p style="color: red">${message}</p>
    <form class="registerForm"  method="post" action="JJMJMemberAdmin">
        <p>            
            <label for="fullName">Full Name: </label>
            <input type="text" name="fullName" style="width: 200px" value="${memberList.fullName}"></input>
        </p>
        <p>
            <label for="email">Email: </label>
            <input type="email" name="email" style="width: 300px" value="${memberList.emailAddress}"></input>
        </p>
        <p>
            <label for="phone">Phone: </label>
            <input type="tel" name="phone" style="width: 100px" value="${memberList.phoneNumber}"></input>
        </p>
        <p>
            <label for="program">IT Program </label>
            <select name="program">
                <option value="CAD" ${memberList.programName == "CAD"? "selected" : ""}> CAD </option>
                <option value="CP" ${memberList.programName == "CP"? "selected" : ""}> CP </option>
                <option value="CPA" ${memberList.programName == "CPA"? "selected" : ""}> CPA </option>
                <option value="ITID" ${memberList.programName == "ITID"? "selected" : ""}> ITID </option>
                <option value="ITSS" ${memberList.programName == "ITSS"? "selected" : ""}> ITSS </option>
                <option value="MSD" ${memberList.programName == "MSD"? "selected" : ""}> MSD </option>
                <option value="Others" ${memberList.programName == "Others"? "selected" : ""}> Others </option>
            </select>
        </p>
        <p>
            <label for="year">Year: </label>
            <select name="year">
                <option value="1" ${memberList.yearLevel == 1? "selected" : ""}>1</option>
                <option value="2" ${memberList.yearLevel == 2? "selected" : ""}>2</option>
                <option value="3" ${memberList.yearLevel == 3? "selected" : ""}>3</option>
                <option value="4" ${memberList.yearLevel == 4? "selected" : ""}>4</option>
            </select>
        </p> <br>                 
        <button type="submit" value="Save">Save</button>
        <button type="reset">Reset</button>                        
    </form>

</body>
<jsp:include page="JJMJFooter.jsp"/><br>