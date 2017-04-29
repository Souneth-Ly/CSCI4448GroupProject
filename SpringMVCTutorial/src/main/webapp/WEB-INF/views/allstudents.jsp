<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>University Enrollments</title>
 
    <style>
        tr:first-child{
            font-weight: bold;
            background-color: #C6C9C4;
        }
    </style>
 
</head>
 
 
<body>
    <h2>List of Students</h2>  
    <table>
        <tr>
            <td>NAME</td><td>ID</td><td>Report</td><td>Tuition</td><td></td>
        </tr>
        <c:forEach items="${Students}" var="Student">
            <tr>
            <td>${Student.name}</td>
            <td>${Student.joiningDate}</td>
            <td>${Student.salary}</td>
            <td><a href="<c:url value='/edit-${Student.ssn}-Student' />">${Student.ssn}</a></td>
            <td><a href="<c:url value='/delete-${Student.ssn}-Student' />">delete</a></td>
            </tr>
        </c:forEach>
    </table>
    <br/>
    <a href="<c:url value='/new' />">Add New Student</a>
</body>
</html>