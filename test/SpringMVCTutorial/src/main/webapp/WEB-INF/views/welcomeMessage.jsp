<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
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
                  <input type = "submit" value = "hello Page"/>
               </td>
            </tr>
         </table>  
      </form:form>
</body>
</html>