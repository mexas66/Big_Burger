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

<body style="background-image: url(https://consequenceofsound.net/wp-content/uploads/2017/04/homer-simpson-feature1.png?resize=807,538); background-size: 100%; background-repeat: no-repeat;">

<nav class="navbar navbar-light" style="background-color: rgb(255, 129, 129);">
    <a class="navbar-brand" href="#" style="color: white;">BigBurger</a>

    <div>
    <c:choose>
     <c:when test="${empty sessionScope.currentuser}">

        <a href="PageConnexion.jsp"><button type="button" class="btn btn-primary">Se connecter</button></a>
        <a href="Inscription.jsp"><button type="button" class="btn btn-primary">S'inscrire</button></a>
</c:when>
<c:otherwise>
    <a href="user"><button type="button" class="btn btn-primary">Infos Utilisateur</button></a>
    <a href="menu"><button type="button" class="btn btn-primary">Menu</button></a>
    <a href="disconnect"><button type="button" class="btn btn-primary">Se déconnecter</button></a>

    <c:if test="${sessionScope.currentuser.role == 'COOKER' || sessionScope.currentuser.role == 'DELIVERY'}">
        <a href="orderlist"><button type="button" class="btn btn-primary">Commandes à traiter</button></a>
    </c:if>
    <c:if test="${sessionScope.currentuser.role == 'ADMIN'}">
        <a href="Inscription.jsp"><button type="button" class="btn btn-primary">Inscrire un employé</button></a>

    </c:if>
</c:otherwise>

</c:choose>
</div>

</nav>


<img src="https://www.gifimili.com/gif/2018/02/hamburger.gif" style="border:solid 5px" width="300" height="300"
     title="LE BURGER CLASSIQUE 6.50€" alt="" class="arrondie">


</body>

</html>