<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>BIG BURGER</title>
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">

</head>

<h4 style="text-align:center;font-family:cursive;font-size:100px;color:#003344">BIG BURGER</h4>

<body style background="https://i.pinimg.com/originals/58/67/d8/5867d8f8218432be5f16ccefe8c03fd0.jpg">

<img src="https://www.gifimili.com/gif/2018/02/hamburger.gif" style="border:solid 5px" width="300" height="300"
     title="LE BURGER CLASSIQUE 6.50€" alt="" class="arrondie">

<c:when test="${sessionScope.currentuser empty}"></c:if>
<p style="font-size:20px;color:#003344"><B>Souhaitez-vous vous connecter ? </B><a href="PageConnexion.jsp">Page de connexion</a></p>
<p style="font-size:20px;color:#003344"><B>Souhaitez-vous vous inscrire ? </B><a href="Inscription.jsp">Page d'inscription</a></p>
</c:when>
<c:otherwise>
    <p style="font-size:20px;color:#003344"><B>Informations utilisateur   :  </B><a href="user">Menu</a></p>
    <p style="font-size:20px;color:#003344"><B>Souhaitez-vous commander ? </B><a href="menu">Menu</a></p>
    <c:if test="${sessionScope.currentuser.role == 'COOKER' || sessionScope.currentuser.role == 'DELIVERY'}">
        <p style="font-size:20px;color:#003344"><B>Acceder aux commandes à traiter ? </B><a href="orderlist">Commandes à traiter</a></p>
    </c:if>
    <c:if test="${sessionScope.currentuser.role == 'ADMIN'}">
        <p style="font-size:20px;color:#003344"><B>Souhaitez-vous inscrire un employé ? </B><a href="Inscription.jsp">Page d'inscription</a></p>

    </c:if>
</c:otherwise>




</body>

</html>