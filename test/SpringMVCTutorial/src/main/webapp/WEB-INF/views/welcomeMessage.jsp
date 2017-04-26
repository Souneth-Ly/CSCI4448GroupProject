<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
	<title>Spring 4 MVC Hello World Example with Maven Eclipse</title>
</head>
<body>
	<h2>Hello World, Spring MVC</h2>

	<p>${msg}</p>
      <p>Click below button to redirect the result to new page</p>
      
      <form:form method = "GET" action = "/SpringMVCTutorial/hello">
         <table>
            <tr>
               <td>
                  <input type = "submit" name="hello" value = "Hello Page"/>
               </td>
            </tr>
         </table>  
      </form:form>
      <form:form method = "GET" action = "/SpringMVCTutorial/login">
         <table>
            <tr>
               <td>                  
               		<input type = "submit"  name= "index" value = "Index Page"/>
               </td>
            </tr>
         </table>  
      </form:form>
</body>
</html>