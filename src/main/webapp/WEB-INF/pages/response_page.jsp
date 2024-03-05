<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Response Page</title>
<style>
    table {
        border-collapse: collapse;
        width: 50%;
         
    }
    th, td {
        border: 1px solid black;
        padding: 5px;
        text-align: center;
        
    }
    td
    {
       color:#7B0099;
       font-size: 15px;
    }
    th {
        background-color: #0F7DC2;
        color:white;
         font-size: 15px;
    }
    .a1
    {
       text-decoration: none;
       color:red;
    }
    .a2
    {
       text-decoration: none;
       color:green;
    }
    h2
    {
        color:red;
        text-align: center;
    }
    #id1
   {
      text-align: center;
      color:green;
   }
</style>
</head>
<body>
<h2>Patient Reports</h2>
<hr>
  <c:choose>
      <c:when test="${!empty resList}">
          <table border="1" align="center">
          <tr>
            <th>ID</th><th>NAME</th><th>AGE</th><th>ADDRESS</th>
            <th>AADHAR</th><th>MOBILE</th><th>PINCODE</th><th>EMAIL</th>
            <th>FILE NAME</th><th>DOCUMENT</th><th>ACTION</th>
          </tr>
          <c:forEach var="patient"  items="${resList}">
            <tr>
              <td><b>${patient.id}</b></td><td><b>${patient.name}</b></td><td><b>${patient.age}</b></td><td><b>${patient.address}</b></td>
              <td><b>${patient.aadhar}</b></td><td><b>${patient.mobNo}</b></td><td><b>${patient.pincode}</b></td>
              <td><b>${patient.email}</b></td><td><b>${patient.dto.fileName}</b></td>
              <td><a href="downloadAndView?uniqueFileName=${patient.dto.uniqueFileName}" class="a2"><b>Download&View</b></a></td>
              
              <%-- <td><a href="edit?id=${emp1.id}" class="a2"><b>Edit</b></a></td>--%>
              <td><a href="delete?id=${patient.id}" class="a1" onclick="return confirm('Do you want to delete?')"><b>Delete</b></a></td>
            </tr>
          </c:forEach>
    </table>
      </c:when>
  </c:choose>
  <c:if test="${!empty res}">
   <h3 style="color:green;text-align: center;">${res}</h2>
  </c:if>
  <c:if test="${!empty emailMsg}">
   <h3 style="color:red;text-align: center;">${emailMsg}</h2>
  </c:if>
   <h3 style="text-align: center"><a href="./">Home</a></h3>
</body>
</html>