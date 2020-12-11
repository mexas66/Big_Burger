<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <c:if test="${empty sessionScope.currentuser}">
        <c:redirect url="${pageContext.request.contextPath}/BigBurger.jsp?message=ACCESS_DENIED"/>
    </c:if>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Cuisine</title>
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">

</head>
<body style="background-color:#e6ddb7">

<h4 style="text-align:center;font-family:cursive;font-size:70px;color:#5b3500">Cuisine</h4>


<form action="recap" method ="post">
 <table>
     <thead>
         <th>Numéro de commande</th>
         <th>Nom et Prénom</th>
         <th>Heure de validation de commande</th>
         <th>Heure théorique de fin de préparation 4</th>
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
                      <a href="detail?order_id=${order.id}">Détail</a>
                  </td>
             </tr>
         </c:forEach>
     </tbody>
 </table>
 </form>
</body>
</html>