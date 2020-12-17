<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <c:if test="${not empty sessionScope.currentuser}">
        <c:redirect url="${pageContext.request.contextPath}/BigBurger.jsp?message=ACCESS_DENIED"/>
    </c:if>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Connexion</title>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
        <link rel="stylesheet" type="text/css" href="css/stylesheet.css" />
    

</head>

<body>

    <nav class="navbar navbar-light">
        <a class="navbar-brand" href="BigBurger.jsp">BigBurger</a>
    </nav>


     <thead>

     </thead>
     <body>

          <form action="userconnect" method="post">
              <legend><B>Se connecter</B></legend>
              <br/>
              <br/>
              <br/>
              <div class="mb-3">
              <label for="login" class="form-label"><B>Mail</B></label>
              <br/>
              <input id="login" name="login" type="text" class="form-control" required/><br/>
               <br/>
               </div>
               <br/>
               <div class="mb-3">
              <label for="password"  class="form-label"><B>Mot de passe</B></label>
              <br/>
              <input id="password" name="password" type="password"  class="form-control" required/>
              <br/>
              </div>
              <br/>
              <br/>

              <button type="submit" class="btn btn-primary" name="submit"><B>Valider</B></button>
          </form>
     </tbody>

</body>
</html>