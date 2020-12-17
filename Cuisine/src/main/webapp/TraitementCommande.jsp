<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>Traitement commande</title>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
    <link rel="stylesheet" type="text/css" href="css/stylesheet.css" />

</head>

<body style="background-color:#add8e6">

  <nav class="navbar navbar-light" style="background-color: rgb(255, 129, 129);">
    <a class="navbar-brand" href="BigBurger.jsp" style="color: white;">BigBurger</a>
</nav>


<h4 style="text-align:center;font-family:cursive;font-size:70px;color:#5b3500">Traitement commande</h4>


                    <p> <c:out value="${orderDTO.userDTO.firstname}"/></p>
                    <p> <c:out value="${orderDTO.userDTO.lastname}"/></p>

                    <p> <c:out value="${orderDTO.userDTO.addressDTO.number}"/></p>
                    <p> <c:out value="${orderDTO.userDTO.addressDTO.street}"/></p>
                    <p> <c:out value="${orderDTO.userDTO.addressDTO.zipCode}"/></p>
                    <p> <c:out value="${orderDTO.userDTO.addressDTO.city}"/></p>

                    <p> <c:out value="${orderDTO.userDTO.phone}"/></p>

                    <p> <c:out value="${orderDTO.userDTO.email}"/></p>

        <p>Numero de commande: <c:out value="${orderDTO.id}" /></p>
        <p>Date de validation:<c:out value="${orderDTO.beginning}" /></p>
        <p>Date théorique de fin:<c:out value="${orderDTO.end}" /></p>
        <p>Etat commande:<c:out value="${orderDTO.state}" /></p>
        <p>Type de retrait: <c:out value="${orderDTO.type}"/></p>

          <table class="table">

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


<c:choose>
    <c:when test="${requestScope.currentemployee.role == 'COOKER'}">
      <c:if test="${orderDTO.state == 'VALIDATED' || orderDTO.state == 'PREPARING'}">

<a href="next?order_id=${orderDTO.id}"> <button type="button" class="btn btn-primary">Suivant</button> </a>

      </c:if>

    </c:when>




<c:when test="${requestScope.currentemployee.role == 'DELIVERY'}">

<c:if test="${orderDTO.state == 'READY' || orderDTO.state == 'DELIVERING'}">

<a href="next?order_id=${orderDTO.id}"> <button type="button" class="btn btn-primary">Suivant</button> </a>


</c:if>

</c:when>


</c:choose>



</body>

</html>