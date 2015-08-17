<%-- 
    Document   : retorno
    Created on : 16/08/2015, 16:00:14
    Author     : Leonardo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Retorno da Busca</h1>
      <% int retorno
                    = (int) request.getAttribute("retorno");
        
        if(retorno == 1){%>
        <h2> <%System.out.print("O nome foi encontrado"); %> </h2>
       <%}else{ %>
        <h2> <%System.out.print("O nome não foi encontrado"); %> </h2>
        <%}%>
    </body>
</html>
