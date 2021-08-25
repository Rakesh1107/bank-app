<%@page import="pojo.Customer"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customers</title>
</head>
<body>
<h1>Customers</h1>

<table border ="1" width="500" align="center">
         <tr bgcolor="00FF7F">
          <th><b>Account Number</b></th>
          <th><b>Branch</b></th>
          <th><b>Balance</b></th>
         </tr>
      
        <%List<Customer> customers = 
            (List<Customer>)request.getAttribute("data");
        for(Customer customer : customers){%>
        
            <tr>
                <td><%=customer.getName()%></td>
                <td><%=customer.getMobileNumber()%></td>
                <td><%=customer.getAddress()%></td>
            </tr>
            <%}%>
        </table> 

</body>
</html>