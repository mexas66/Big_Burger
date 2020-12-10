<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>Utilisateur</title>
</head>

<body style="background-color:#add8e6">

<h4 style="text-align:center;font-family:cursive;font-size:70px;color:#5b3500">Informations</h4>


                    <p> <c:out value="${requestScope.currentuser.firstname}"/></p>
                    <p> <c:out value="${requestScope.currentuser.lastname}"/></p>

                    <p> <c:out value="${requestScope.currentuser.addressDTO.number}"/></p>
                    <p> <c:out value="${requestScope.currentuser.addressDTO.street}"/></p>
                    <p> <c:out value="${requestScope.currentuser.addressDTO.zipCode}"/></p>
                    <p> <c:out value="${requestScope.currentuser.addressDTO.city}"/></p>

                    <p> <c:out value="${requestScope.currentuser.phone}"/></p>

                    <p> <c:out value="${requestScope.currentuser.email}"/></p>

          <table>

<thead>
        <th>Date de validation</th>
        <th>Date théorique de fin</th>
        <th>Total commande</th>
        <th>Etat commande</th>
</thead>

<tbody>
        <c:forEach items="${requestScope.orders}" var="order">
           <tr>
               <td>
           <c:out value="${order.beginning}"/>
               </td>
               <td>
           <c:out value="${order.end}"/>
               </td>
               <td>
           <c:out value="${order.total}"/>
               </td>
               <td>
           <c:out value="${order.state}"/>
               </td>
           </tr>
<<<<<<< HEAD
        </c:forEach>
=======
>>>>>>> origin/LudivineBranch
</tbody>
          </table>
</body>

</html>