<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Commande</title>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
        <link rel="stylesheet" type="text/css" href="css/stylesheet.css" />
    

</head>
<body style="background-color:#add8e6">

    <nav class="navbar navbar-light"">
        <a class="navbar-brand" href="BigBurger.jsp">BigBurger</a>
    </nav>

<h4>Menu</h4>


<form action="recap" method ="post">
 <table class="table">
     <thead>
         <th>Nom du Burger</th>
         <th>Prix</th>
         <th>Quantité</th>

     </thead>
     <tbody>
         <c:forEach items="${requestScope.burgers}" var="burger">
             <tr class="mb-3">
                 <td>
                     <label name="burger-label" class="form-laber"><c:out value="${burger.label}" /></label>
                 </td>
                 <td>
                     <c:out value="${burger.price}" />€
                 </td>
                <td>
                    <input class="form-control" type="number" min="0" value="0" name="${burger.id}to_add">
                </td>
             </tr>
         </c:forEach>
     </tbody>
 </table>
 
 <label>Type de retrait</label>
 <select name="type" class="form-select">
 	<option value="CLICK & COLLECT">Click & Collect</option>
 	<option value="DELIVERY">Livraison</option>
 </select>
<button type="submit" class="btn btn-primary" name="submit"><B>Ajouter</B></button>

 </form>
</body>
</html>