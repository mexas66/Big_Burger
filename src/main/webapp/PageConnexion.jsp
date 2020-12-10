<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Connexion</title>
</head>

<h4 style="text-align:center;font-family:cursive;font-size:70px;color:#5b3500">Connexion</h4>

     <thead>

     </thead>
     <body style="text-align:center;background-color:#ffffd4">

          <form action="connect" method="post">
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