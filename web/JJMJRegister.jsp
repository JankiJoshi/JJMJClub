<%-- 
    Matthew Janes - Janki Joshi
    3/29/2017
    Assignment 3
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<jsp:include page="JJMJBanner.jsp"/><br><br>
<section>
    <h2> New Member Registration Form </h2>
    <form class="registerForm" action="JJMJDisplayMember.jsp" method="post">
        <p>
            <label for="fullName">Full Name: </label>
            <input type="text" name="fullName" style="width: 200px" required></input>
        </p>
        <p>
            <label for="email">Email: </label>
            <input type="email" name="email" style="width: 300px" required></input>
        </p>
        <p>
            <label for="phone">Phone: </label>
            <input type="tel" name="phone" style="width: 100px"></input>
        </p>
        <p>
            <label for="program">IT Program </label>
            <select name="program">
                <option value="CAD"> CAD </option>
                <option value="CP"> CP </option>
                <option value="CPA"> CPA </option>
                <option value="ITID"> ITID </option>
                <option value="ITSS"> ITSS </option>
                <option value="MSD"> MSD </option>
                <option value="Others"> Others </option>
            </select>
        </p>
        <p>
            <label for="year">Year: </label>
            <select name="year">
                <option value="1">1</option>
                <option value="2">2</option>
                <option value="3">3</option>
                <option value="4">4</option>
            </select>
        </p> <br>                 
        <button type="submit" value="Register Now!">Register Now!</button>
        <button type="reset">Reset</button>                        
    </form>
</section>
<br>
<jsp:include page="JJMJFooter.jsp"/>
