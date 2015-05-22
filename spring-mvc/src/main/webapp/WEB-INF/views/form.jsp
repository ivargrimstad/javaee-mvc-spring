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
      FirstName: ${firstName}<br/>
      LastName : ${lastName}<br/>
   </body>
</html>
