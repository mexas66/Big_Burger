<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Commande</title>
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">

</head>
<body style="background-color:#add8e6">

    <nav class="navbar navbar-light" style="background-color: rgb(255, 129, 129);">
        <a class="navbar-brand" href="BigBurger.jsp" style="color: white;">BigBurger</a>
    </nav>

<h4 style="text-align:center;font-family:cursive;font-size:70px;color:#5b3500">Menu</h4>


<form action="recap" method ="post">
 <table class="table">
     <thead>
         <th>Nom du Burger</th>
         <th>Prix</th>
         <th>Quantité</th>

     </thead>
     <tbody>
         <c:forEach items="${requestScope.burgers}" var="burger">
             <tr>
                 <td>
                     <c:out value="${burger.label}" />
                 </td>
                 <td>
                     <c:out value="${burger.price}" />€
                 </td>
                <td>
                    <input type="number" min="0" value="0" name="${burger.id}to_add">
                </td>-
             </tr>
         </c:forEach>
     </tbody>
 </table>
<button type="submit" class="btn btn-primary" name="submit"><B>Ajouter</B></button>

 </form>
</body>
</html>