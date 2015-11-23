<%-- 
    Document   : Form
    Created on : 23/11/2015, 19:27:18
    Author     : 31432778
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sistema</title>
    </head>
    <body>
        <div>
            <form method="POST" action="FrontControllerServlet?control=Pesquisa">
                Insira o Nome: <input type="text" name="nome" required><br>
                Insira o Sobrenome: <input type="text" name="sobrenome" required><br>
                <input type="submit" value="Pesquisar!">
            </form>
        </div>
    </body>
</html>
