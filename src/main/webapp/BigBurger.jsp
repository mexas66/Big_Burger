<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>BIG BURGER</title>

</head>


<body style background="https://i.pinimg.com/originals/58/67/d8/5867d8f8218432be5f16ccefe8c03fd0.jpg">
<h4 style="text-align:center;font-family:cursive;font-size:100px;color:#003344">BIG BURGER</h4>

<img src="https://www.gifimili.com/gif/2018/02/hamburger.gif" style="border:solid 5px" width="300" height="300"
     title="LE BURGER CLASSIQUE 6.50€" alt="" class="arrondie">

<form action="connect" method="post">
    <legend style="color:#456802;font-size:30px"><B>Se connecter</B></legend>
    <label for="login" style="color:"><B>Mail</B></label>
    <input id="login" name="login" type="text" required/><br/>
    <label for="password"><B>Mot de passe</B></label>
    <input id="password" name="password" type="password" required/>
    <button onclick="alert(this.value)" style="background-color:#6ca302;color:#5b3500"><B>Valider</B></button>

</form>
<p style="font-size:20px;color:#003344"><B>Souhaitez-vous vous inscrire ? </B><a href="Inscription.jsp">Page d'inscription</a></p>
<p style="font-size:20px;color:#003344"><B>Souhaitez-vous commander ? </B><a href="Commande.jsp">Menu</a></p>

</body>

</html>