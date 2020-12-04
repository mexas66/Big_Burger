<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Commande</title>
</head>
<body style background-color="#e6ddb7 ">

<h4 style="text-align:center;font-family:cursive;font-size:50px"><u>MENU</u></h4>



<FORM>
    <h4 style="text-align:center;font-family:cursive;font-size:80px">Le Classique</h4>

<p style="text-align:center;font-size:30px"><i>Pain, sauce, salade, oignons, cornichons, fromage, tomates, steacks</i></p>
    <img src="https://www.fastnfood-ivry.fr/63-344-thickbox/double-cheese-burger.jpg" style="border:solid 5px" width="270" height="270"> <p style="font-size:30px"><B>Prix :</B> 6.50 €</p>

    <label style="font-size:30px">Quantité désirée:</label>

    <SELECT name="nom" size="1" style="font-size:20px">
        <OPTION>1
        <OPTION>2
        <OPTION>3
        <OPTION>4
        <OPTION>5
        <OPTION>6
        <OPTION>7
        <OPTION>8
        <OPTION>9
        <OPTION>10
    </SELECT>
    <button onclick="alert(this.value)" style="background-color:#6ca302;color:#5b3500"><B>Valider</B></button>

</FORM>
</body>
</html>