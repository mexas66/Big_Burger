<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <c:if test="${empty sessionScope.currentuser}">
        <c:redirect url="${pageContext.request.contextPath}/BigBurger.jsp?message=ACCESS_DENIED"/>
    </c:if>

<head>
    <meta charset="UTF-8">
    <title>Utilisateur</title>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
        <link rel="stylesheet" type="text/css" href="css/stylesheet.css" />
    
    

</head>

<body>

    <nav class="navbar navbar-light" style="background-color: rgb(255, 129, 129);">
        <a class="navbar-brand" href="BigBurger.jsp">BigBurger</a>
    </nav>


<h4>Informations</h4>

					<div id="user-info">
                    <p> <c:out value="${requestScope.currentuser.firstname}"/></p>
                    <p> <c:out value="${requestScope.currentuser.lastname}"/></p>

                    <p> <c:out value="${requestScope.currentuser.addressDTO.number}"/></p>
                    <p> <c:out value="${requestScope.currentuser.addressDTO.street}"/></p>
                    <p> <c:out value="${requestScope.currentuser.addressDTO.zipCode}"/></p>
                    <p> <c:out value="${requestScope.currentuser.addressDTO.city}"/></p>

                    <p> <c:out value="${requestScope.currentuser.phone}"/></p>

                    <p> <c:out value="${requestScope.currentuser.email}"/></p>

                    <a href="hystoric"><button type="button" class="btn btn-primary" >Historique de Commande</button></a>
                    </div>
          <table class="table">

<thead>
		<th>Type de livraison</th>
        <th>Date de validation</th>
        <th>Date théorique de fin</th>
        <th>Total commande</th>
        <th>Etat commande</th>
        <th>Détail de la commande</th>
</thead>

<tbody>
        <c:forEach items="${requestScope.orders}" var="order">
           <tr>
           	<td>
           		<c:out value="${order.type}"/>
           	</td>
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
               <td>
                <a href="detail?order_id=${order.id}">Détail</a>
               </td>
           </tr>

        </c:forEach>

</tbody>
          </table>
</body>

</html>