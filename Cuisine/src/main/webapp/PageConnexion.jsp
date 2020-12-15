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

</head>

<body>

    <nav class="navbar navbar-light" style="background-color: rgb(255, 129, 129);">
        <a class="navbar-brand" href="BigBurger.jsp" style="color: white;">BigBurger</a>
    </nav>


<h4 style="text-align:center;font-family:cursive;font-size:70px;color:#5b3500">Connexion</h4>

     <thead>

     </thead>
     <body style="text-align:center;background-color:#ffffd4">

          <form action="connect" method="post" class="form-group">
              <legend style="color:#456802;font-size:30px"><B>Se connecter</B></legend>
              <br/>
              <br/>
              <br/>
              <label for="login" style="color:"><B>Mail</B></label>
              <br/>
              <input id="login" name="login" type="text" required/><br/>
               <br/>
               <br/>
              <label for="password"><B>Mot de passe</B></label>
              <br/>
              <input id="password" name="password" type="text" required/>
              <br/>
              <br/>
              <br/>

              <button type="submit" style="background-color:#bbd2e1;color:black" name="submit"><B>Valider</B></button>

          </form>
     </tbody>

</body>
</html>