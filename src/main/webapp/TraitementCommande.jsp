<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>Traitement commande</title>
</head>

<body style="background-color:#add8e6">

<h4 style="text-align:center;font-family:cursive;font-size:70px;color:#5b3500">Traitement commande</h4>


                    <p> <c:out value="${requestScope.currentuser.firstname}"/></p>
                    <p> <c:out value="${requestScope.currentuser.lastname}"/></p>

                    <p> <c:out value="${requestScope.currentuser.addressDTO.number}"/></p>
                    <p> <c:out value="${requestScope.currentuser.addressDTO.street}"/></p>
                    <p> <c:out value="${requestScope.currentuser.addressDTO.zipCode}"/></p>
                    <p> <c:out value="${requestScope.currentuser.addressDTO.city}"/></p>

                    <p> <c:out value="${requestScope.currentuser.phone}"/></p>

                    <p> <c:out value="${requestScope.currentuser.email}"/></p>

        <p>Numero de commande: <c:out value="{orderDTO.id}" /></p>
        <p>Date de validation:<c:out value="{order.beginning}" /></p>
        <p>Date théorique de fin:<c:out value="{order.end}" /></p>
        <p>Etat commande:<c:out value="{order.state}" /></p>

          <table>

<thead>
      >
         <th>Nom du Burger</th>
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

<c:if test="${requestScope.currentuser.role == 'COOKER'}">

<c:if test="${requestScope.orderDTO.state == 'VALIDATED' || requestScope.orderDTO.state == 'PREPARING'}">

<a href="next"> <input type="button" value="Suivant"> </a>

</c:if>

</c:if>




<c:if test="${requestScope.currentuser.role == 'DELIVERY'}">

<c:if test="${requestScope.orderDTO.state == 'READY' || requestScope.orderDTO.state == 'DELIVERING'}">

<a href="next" target="_blank"> <input type="button" value="Suivant"> </a>


</c:if>

</c:if>


</tbody>
          </table>

</body>

</html>