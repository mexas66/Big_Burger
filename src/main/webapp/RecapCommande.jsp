<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>

 <!DOCTYPE html>
 <html lang="en">

 <head>
     <meta charset="UTF-8">
     <title>RecapCommande</title>
 </head>

 <body>

 <h4 style="text-align:center;font-family:cursive;font-size:50px"><u>RECAPITULATIF</u></h4>

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

     <c:out value="${orderDTO.total}" />€
     <button type="submit" name="order" value=${order}>Valider Commande</button>
    </table>
</form>


 </body>