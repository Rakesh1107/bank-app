<%@page import="pojo.Account"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Accounts</title>
</head>
<body>
<h1>Accounts</h1>

 
 <table border ="1" width="500" align="center">
         <tr bgcolor="00FF7F">
         <th><b>User id</b></th>
          <th><b>Account Number</b></th>
          <th><b>Branch</b></th>
          <th><b>Balance</b></th>
         </tr>
      
        <%List<Account> accounts = 
            (List<Account>)request.getAttribute("data");
        for(Account account : accounts){%>
        
            <tr>
             <td><%=account.getUserId()%></td>
                <td><%=account.getAccountNumber()%></td>
                <td><%=account.getBranch()%></td>
                <td><%=account.getBalance()%></td>
            </tr>
            <%}%>
        </table> 
</body>
</html>