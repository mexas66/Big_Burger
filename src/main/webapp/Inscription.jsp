<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Inscription</title>
    <script>

 </script>

</head>
<body style="text-align:center;background-color:#e0cda9 ">

<h4 style="text-align:center;font-family:cursive;font-size:70px;color:#5b3500">Inscription</h4>


<form action="register" method="post">


    <label for="Lastname"><B>Nom</B></label>
    <input id="Lastname" name="lastname" type="text" required/><br />
    <br/>
    <label for="firstname"><B>Prénom</B> </label>
    <input id="Firstname" name="firstname" type="text" required/><br />
    <br/>
    <br/>
    <br/>
        <label><B>Numéro de rue</B></label>
        <input id="number" name="number" type="text" required/><br />
    <br/>
        <label><B>Rue</B></label>
        <input id="street" name="street" type="text" required/><br />
    <br/>
        <label><B>Code postal</B></label>
        <input id="zipcode" name="zipcode" type="text" required/><br />
    <br/>
        <label><B>Ville</B></label>
        <input id="city" name="city" type="text" required/><br/>
    <br/>
    <br/>
    <br/>
    <label for="phone"><B>Téléphone</B></label>
    <input id="phone" name="phone" type="text" required/><br/>
    <br/>
    <br/>
    <br/>
        <label for="email"><B>Mail</B></label>
        <input id="email" name="email" type="text" required/><br/>
    <br/>
        <label for="password"><B>Mot de passe</B></label>
        <input id="password" name="password" type="password" required/><br/>
    <br/>

    <c:if test="${not empty sessionScope.currentuser}">
        <c:if test="${currentuser.role == 'ADMIN'}">
            <select name="role">
                <option value="COOKER">Cuisinier</option>
                <option value="DELIVER">Livreur</option>
            </select>
        </c:if>
    </c:if>

    <button type="submit" name="submit" style="background-color:#bbd2e1;color:#5b3500"><B>Valider</B></button>

</form>
</body>
</html>