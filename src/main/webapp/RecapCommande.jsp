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

<form>
<thead>
         <th>Nom du Burger</th>
         <th>Prix</th>
         <th>Quantité</th>
         <th>Total</th>
 </thead>
 <tbody>
         <c:forEach items="${order.burgers}" var="burger">
             <tr>
                 <td>
                     <c:out value="${burger.label}" />
                 </td>
                 <td>
                     <c:out value="${burger.price}" />€
                 </td>
                <td>
                    <c:out value="${}" />
                </td>

             </tr>
         </c:forEach>
     </tbody>
     <c:out value="${order.total}" />€
     <button type="submit" name="submit">Valider Commande</button>

</form>


 </body>