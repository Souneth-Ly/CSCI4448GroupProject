<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
    <form:form name="submitForm" method="POST">
        <div align="center">
            <table>
            <tr>
                    <td>User Type</td>
                    <td><input type="text" name="type" /></td>
                </tr>
                <tr>
                    <td>Name</td>
                    <td><input type="text" name="name" /></td>
                </tr>
                <tr>
                    <td>Username</td>
                    <td><input type="text" name="username" /></td>
                </tr>
                <tr>
                    <td>Password</td>
                    <td><input type="text" name="password" /></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Create User" /></td>
                </tr>
                <tr>
               <td>
                  <input type = "button" onclick="location.href='/SpringMVCTutorial/dean'" value = "Back"/>
               </td>
            </tr>
            </table>
        </div>
    </form:form>
</body>
</html>