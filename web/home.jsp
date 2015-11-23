<%-- 
    Document   : home
    Created on : 23/11/2015, 19:30:23
    Author     : 31432778
--%>

 <%
 //allow access only if session exists
 String user = (String) session.getAttribute("usuario");
 String userName = null;
 String sessionID = null;
 Cookie[] cookies = request.getCookies();
 if (cookies != null) {
 for (Cookie cookie : cookies) {
 if (cookie.getName().equals("usuario")) {
 userName = cookie.getValue();
 }
 if (cookie.getName().equals("JSESSIONID")) {
 sessionID = cookie.getValue();
 }
 }
 }
 %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    
    <body>
         <h1>Exemplo de uso de FrontController</h1>
        <a href="FrontControllerServlet?control=Lista">Lista</a><br><!--Chama o a classe controller com
        o atributo control com valor de Lista, para ir pro ListaController -->
        <a href="Form.jsp">Pesquisa</a><br><!--Vai para a pagina HTML de form para pesquina na base de dados -->
        <a href="FrontControllerServlet?control=SetupBancoDados">Setup Banco Dados</a><br><!--Chama o a classe controller 
        com o atributo control com valor de SetupBancoDados,para ir pro controller do mesmo -->
        <a href="login.html">Login</a><br><!-- chama pagina HTML de form para login de sessão -->
    
        <form action="LogoutServlet" method="post">
            <input type="submit" value="Logout" >
        </form>
    </body>
</html>