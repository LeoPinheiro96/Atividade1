<%-- 
    Document   : retorno
    Created on : 16/08/2015, 16:00:14
    Author     : Leonardo
--%>

<%@page import="mack.entities.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Retorno da Busca</h1>
      <% Usuario usuarioEncontrado = (Usuario) request.getAttribute("usuarioEncontrado");
      
        if(usuarioEncontrado != null){%>
        <h2> Usuario existe!</h2> <br>
        <%= usuarioEncontrado.toString() %>
       <%}else{ %>
        <h2> Não existe </h2>
        <%}%>
    </body>
</html>
