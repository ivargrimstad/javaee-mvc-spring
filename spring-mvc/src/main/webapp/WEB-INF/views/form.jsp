<%-- 
    Document   : form
    Created on : Apr 30, 2015, 2:12:17 PM
    Author     : Ivar Grimstad (ivar.grimstad@gmail.com)
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   <head>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <title>Spring MVC Application</title>
   </head>
   <body>
      <p>An empty first and/or last name will result in a 400 (validation error)</p>
      <form name="form" action="hello" method="post">
         <label id="firstName">First Name:</label>
         <input type="text" name="firstName">
         <label id="lastName">Last Name:</label>
         <input type="text" name="lastName">
         <input type="submit" value="Submit" name="button">
      </form>
      <p/>
   <c:if test="${firstName != null}">
      <font color="red">FirstName: ${firstName}</font><br/>
   </c:if>
   <c:if test="${lastName != null}">
      <font color="red">LastName: ${lastName}</font><br/>
   </c:if>
</body>
</html>
