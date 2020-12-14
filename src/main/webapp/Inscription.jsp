<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  

    <c:if test="${not empty sessionScope.currentuser && sessionScope.currentuser.role != 'ADMIN'}">
        <c:redirect url="${pageContext.request.contextPath}/BigBurger.jsp?message=ACCESS_DENIED"/>
    </c:if>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Inscription</title>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />

</head>
<body style="text-align:center;background-color:#e0cda9">

    <nav class="navbar navbar-light" style="background-color: rgb(255, 129, 129);">
        <a class="navbar-brand" href="BigBurger.jsp" style="color: white;">BigBurger</a>
    </nav>

<h4 style="text-align:center;font-family:cursive;font-size:70px;color:#5b3500">Inscription</h4>


<form action="register" method="post">

    <div class="form-group">
    <label for="Lastname"><B>Nom</B></label>
    <input id="Lastname" name="lastname" type="text" required/>
    </div>
    
    <div class="form-group">
    <label for="firstname"><B>Prénom</B> </label>
    <input id="Firstname" name="firstname" type="text" required/>
    </div>

    <div class="form-group">
        <label><B>Numéro de rue</B></label>
        <input id="number" name="number" type="text" required/>
    </div>

    <div class="form-group">
        <label><B>Rue</B></label>
        <input id="street" name="street" type="text" required/>
    </div>

    <div class="form-group">
        <label><B>Code postal</B></label>
        <input id="zipcode" name="zipcode" type="text" required/>
    </div>

    <div class="form-group">
        <label><B>Ville</B></label>
        <input id="city" name="city" type="text" required/>
    </div>

    <div class="form-group">
    <label for="phone"><B>Téléphone</B></label>
    <input id="phone" name="phone" type="text" required/>
    </div>

    <div class="form-group">
        <label for="email"><B>Mail</B></label>
        <input id="email" name="email" type="text" required/>
    </div>

    <div class="form-group">
        <label for="password"><B>Mot de passe</B></label>
        <input id="password" name="password" type="password" required/>
    </div>

    <c:if test="${not empty sessionScope.currentuser}">
        <c:if test="${currentuser.role == 'ADMIN'}">
            <select name="role">
                <option value="COOKER">Cuisinier</option>
                <option value="DELIVER">Livreur</option>
            </select>
        </c:if>
    </c:if>

    <button type="submit" name="submit" class="btn btn-primary"><B>Valider</B></button>

</form>
</body>
</html>