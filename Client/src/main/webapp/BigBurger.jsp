<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>BIG BURGER</title>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
    <link rel="stylesheet" type="text/css" href="css/stylesheet.css" />
    

</head>

<body>

<nav class="navbar navbar-light">
    <a class="navbar-brand" href="#">BigBurger</a>

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

</c:otherwise>

</c:choose>
</div>

</nav>


<div id="carouselExampleSlidesOnly" class="carousel slide" data-bs-ride="carousel">
  <div class="carousel-inner">
    <div class="carousel-item active">
      <img src="https://burgermix.files.wordpress.com/2016/02/burgergraffiti.jpg" class="d-block w-100" alt="...">
    </div>
    <div class="carousel-item">
      <img src="https://i.ytimg.com/vi/Bzqwv3nNR3o/maxresdefault.jpg" class="d-block w-100" alt="...">
    </div>
    <div class="carousel-item">
      <img src="https://4.bp.blogspot.com/-WVzYH2H3J6s/UMSl4rvWF_I/AAAAAAAAseI/otJJO_4UiTc/s1600/IMG_3656.JPG" class="d-block w-100" alt="...">
    </div>
  </div>
</div>

</body>

</html>