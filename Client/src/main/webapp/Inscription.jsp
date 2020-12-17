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
        <link rel="stylesheet" type="text/css" href="css/stylesheet.css" />
    

</head>
<body>

    <nav class="navbar navbar-light">
        <a class="navbar-brand" href="BigBurger.jsp">BigBurger</a>
    </nav>

<h4 style="text-align:center;font-family:cursive;font-size:70px;color:#5b3500">Inscription</h4>


<form action="register" method="post">

    <div class="mb-3">
    <label for="Lastname" class="form-label"><B>Nom</B></label>
    <input id="Lastname" name="lastname" type="text" class="form-control" required/>
    </div>
    
    <div class="mb-3">
    <label for="firstname" class="form-label"><B>Prénom</B> </label>
    <input id="Firstname" name="firstname" type="text" class="form-control" required/>
    </div>

    <div class="mb-3">
        <label class="form-label"><B>Numéro de rue</B></label>
        <input id="number" name="number" type="text" class="form-control" required/>
    </div>

    <div class="mb-3">
        <label class="form-label"><B>Rue</B></label>
        <input id="street" name="street" type="text" class="form-control"  required/>
    </div>

    <div class="mb-3">
        <label class="form-label"><B>Code postal</B></label>
        <input id="zipcode" name="zipcode" type="text" class="form-control"  required/>
    </div>

    <div class="mb-3">
        <label class="form-label"><B>Ville</B></label>
        <input id="city" name="city" type="text" class="form-control" required/>
    </div>

    <div class="mb-3">
    <label for="phone" class="form-label"><B>Téléphone</B></label>
    <input id="phone" name="phone" type="text" class="form-control" required/>
    </div>

    <div class="mb-3">
        <label for="email" class="form-label"><B>Mail</B></label>
        <input id="email" name="email" type="text" class="form-control" required/>
    </div>

    <div class="mb-3">
        <label for="password" class="form-label"><B>Mot de passe</B></label>
        <input id="password" name="password" type="password" class="form-control" required/>
    </div>

    <!--<c:if test="${not empty sessionScope.currentuser}">
        <c:if test="${currentuser.role == 'ADMIN'}">
            <select name="role">
                <option value="COOKER">Cuisinier</option>
                <option value="DELIVER">Livreur</option>
            </select>
        </c:if>
    </c:if>-->

    <button type="submit" name="submit" class="btn btn-primary"><B>Valider</B></button>

</form>
</body>
</html>