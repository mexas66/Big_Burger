<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <c:if test="${empty sessionScope.currentemployee}">
        <c:redirect url="/BigBurger.jsp?message=ACCESS_DENIED"/>
    </c:if>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Cuisine</title>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
        <link rel="stylesheet" type="text/css" href="css/stylesheet.css" />
    

</head>
<body style="background-color:#e6ddb7">

    <nav class="navbar navbar-light" style="background-color: rgb(255, 129, 129);">
        <a class="navbar-brand" href="BigBurger.jsp" style="color: white;">BigBurger</a>
    </nav>

<h4 style="text-align:center;font-family:cursive;font-size:70px;color:#5b3500">Cuisine</h4>


<form action="recap" method ="post">
 <table class="table">
     <thead>
         <th>Numéro de commande</th>
         <th>Nom et Prénom</th>
         <th>Heure de validation de commande</th>
         <th>Heure théorique de fin de préparation 4</th>
         <th>Type de retrait</th>
         <th>Détail</th>
     </thead>
     <tbody>
         <c:forEach items="${requestScope.orderlist}" var="order">
             <tr>
              <td>
                 <c:out value="${order.id}"/>
                </td>
                 <td>
                     <c:out value="${order.userDTO.firstname} ${order.userDTO.lastname}" />
                 </td>
                 <td>
                     <c:out value="${order.beginning}" />
                 </td>
                  <td>
                    <c:out value="${order.end}" />
                  </td>
                  <td>
                  	<c:out value="${order.type}"/>
                  </td>
                  <td>
                      <a href="detail?order_id=${order.id}">Détail</a>
                  </td>
             </tr>
         </c:forEach>
     </tbody>
 </table>
 </form>
</body>
</html>