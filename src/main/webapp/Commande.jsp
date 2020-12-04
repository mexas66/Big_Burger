<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Commande</title>
</head>
<body style background-color="#e6ddb7 ">

<h4 style="text-align:center;font-family:cursive;font-size:50px"><u>MENU</u></h4>



<form>
 <table>
     <thead>
         <th>Nom du Burger</th>
         <th>Prix</th>
         <th>Quantité</th>
         <th>Ajouter à la commande</th>
     </thead>
     <tbody>
         <c:forEach items="${requestScope.burgers}" var="burger">
             <tr>
                 <td>
                     <c:out value="${burger.label}" />
                 </td>
                 <td>
                     <c:out value="${burger.price}" />€
                 </td>
                <td>
                    <input type="number" name="to_add">
                </td>
                <td>
                    <button type="submit" name="submit">Ajouter</button>
                </td>
             </tr>
         </c:forEach>
     </tbody>
 </table>
 </form>
</body>
</html>