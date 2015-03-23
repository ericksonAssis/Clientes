<%-- 
    Document   : mensagem
    Created on : 22/03/2015, 11:11:07
    Author     : Erickson
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mensagem</title>
    </head>
    <body>
        <%
        String msg = (String) request.getAttribute("msg");
        %>
        <h1>Mensagem</h1>
        <h2><%=msg%></h2>
        <p><a href="controle">Voltar</a></p>
    </body>
</html>
