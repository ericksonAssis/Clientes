<%-- 
    Document   : insere
    Created on : 22/03/2015, 10:29:38
    Author     : Erickson
--%>

<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insere cliente</title>
    </head>
    <body>
        <h1>Inserir Cliente</h1>
        <form method="post" action="controle">
            <input type="hidden" name="acao" value="inserir">
            <p><label>Nome: <input type="text" name="nome"
                                   placeholder="Digite o seu nome" required="true"></label></p>
            <p><label>CPF: <input type="text" name="cpf" 
                                  placeholder="Digite o seu cpf" pattern=".{11,11}" title="Insira 11 characteres numéricos"
                                  required="true"/>
                </label></p>
            <p><label>
                    E-mail: <input type="text" name="email" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$"
                                   required="true" placeholder="Digite o seu email" />
                </label></p>
            <p><label>
                    Telefone: <input type="number" name="telefone" 
                                     required="true" placeholder="Digite o seu telefone" pattern="[0-9]"></label></p>
            <p><label>Endereço: <input type="text" name="endereco" required="true" placeholder="Digite o seu endereço"></label><p>
                    <%
                        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
                    %>
            <p><label>Data de nascimento: <input type="date" name="dataNascimento" min="<%= formato.format(new Date(1))%>" max="<%= formato.format(new Date())%>" required="true" placeholder="Digite sua data de nascimento"></label></p>
            <p><input type="submit" value="inserir"></p>
        </form>
        <p><a href="controle?acao=default">Voltar</a></p>
</html>

