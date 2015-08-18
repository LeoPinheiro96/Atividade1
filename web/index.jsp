<%-- 
    Document   : index
    Created on : 16/08/2015, 12:51:36
    Author     : Leonardo
--%>

<%@page import="mack.entities.Usuario"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Usuarios!</h1>
        <%
            List<Usuario> usuarios = (List<Usuario>) request.getAttribute("usuarios");
        %>
        <%if (usuarios.size() > 0) { %>
        <table>
            <% for (Usuario u : usuarios){%>
            <tr>
                <td><%=u.getNome()%></td>
                <td><%=u.getSobrenome()%></td>
            </tr>
            <%}%>
        </table>
        <%}%>
    </body>
</html>
