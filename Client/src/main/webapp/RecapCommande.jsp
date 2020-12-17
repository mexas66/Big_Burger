<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>

 <!DOCTYPE html>
 <html lang="en">

 <head>
     <meta charset="UTF-8">
     <title>RecapCommande</title>
     <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
         <link rel="stylesheet" type="text/css" href="css/stylesheet.css" />
     

 </head>

 <body style="background-color:#d6d6d6">

    <nav class="navbar navbar-light" style="background-color: rgb(255, 129, 129);">
        <a class="navbar-brand" href="BigBurger.jsp" style="color: white;">BigBurger</a>
    </nav>


 <h4 style="text-align:center;font-family:cursive;font-size:50px">RECAPITULATIF</h4>

<form action="validate" method="POST" >
    <table>
<thead>
         <th>Nom du Burger</th>
         <th>Prix</th>
         <th>Quantité</th>

 </thead>

 <tbody>

         <c:forEach items="${orderDTO.burgerDTOs}" var="burger">

             <tr>
                 <td>
                     <c:out value="${burger.key.label}" />
                 </td>
                 <td>
                     <c:out value="${burger.key.price}" />€
                 </td>
                <td>
                    <c:out value="${burger.value}" />
                </td>

             </tr>
         </c:forEach>
     </tbody>

 </table>
 </br>
 <B>Type de livraison : <c:out value="${orderDTO.type}"/></B>
 <B>Total = <B/></th>
    <B><c:out value="${orderDTO.total}" />€</B>
      <button type="submit" style="background-color:#bbd2e1;color:black"><B>Valider Commande</B></button>

</form>


 </body>