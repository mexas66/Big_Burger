<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Cuisine</title>
</head>
<body style="background-color:#e6ddb7">



<form action="recap" method ="post">
 <table>
     <thead>
         <th>Numéro de commande</th>
         <th>Nom et Prénom</th>
         <th>Heure de validation de commande</th>
         <th>Heure théorique de fin de préparation 4</th>
     </thead>
     <tbody>
         <c:forEach items="${requestScope.orderlist}" var="order">
         <a href="/detail?order_id=${order.id}">
             <tr>
              <td>
                 <c:out value="${order.id}"/>€
                </td>
                 <td>
                     <c:out value="${order.userDTO.firstname} ${order.userDTO.lastname}" />
                 </td>
                 <td>
                     <c:out value="${order.beginning}" />€
                 </td>
                  <td>
                    <c:out value="${order.end}" />€
                  </td>

             </tr>
             </a>
         </c:forEach>
     </tbody>
 </table>
 </form>
</body>
</html>