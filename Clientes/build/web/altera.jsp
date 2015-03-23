<%-- 
    Document   : altera
    Created on : 22/03/2015, 11:06:15
    Author     : Erickson
--%>

<%@page import="java.util.Date"%>
<%@page import="java.util.Date"%>
<%@page import="br.com.clientes.Clientes"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alterar cadastro cliente</title>
    </head>
    <body>
        <%
            Clientes cliente = (Clientes) request.getAttribute("cliente");
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        %>

        <h1>Alterar cadastro cliente</h1>
        <form method="post" action="controle">
            <input type="hidden" name="acao" value="alterar">
            <input type="hidden" name="id" value="<%= cliente.getIdCliente() %>">

            <p><label>Nome: <input type="text" name="nome" value="<%= cliente.getNome() %>"
                                   placeholder="Digite o seu nome" required="true"></label></p>
            <p><label>CPF: <input type="text" name="cpf" value="<%= cliente.getCpf() %>"
                                  placeholder="Digite o seu cpf" pattern=".{11,11}" title="Insira 11 characteres numéricos"
                                  required="true"/>
                </label></p>
            <p><label>
                    E-mail: <input type="text" name="email" value="<%= cliente.getEmail() %>" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$"
                                   required="true" placeholder="Digite o seu email" />
                </label></p>
            <p><label>
                    Telefone: <input type="number" name="telefone" value="<%= cliente.getTelefone() %>"
                                     required="true" placeholder="Digite o seu telefone" pattern="[0-9]"></label></p>
            <p><label>Endereço: <input type="text" name="endereco" value="<%= cliente.getEndereco() %>" required="true" placeholder="Digite o seu endereço"></label><p>
            <p><label>Data de nascimento: <input type="date" name="dataNascimento" value="<%= formato.format(cliente.getDataNascimento()) %>" min="<%= formato.format(new Date(0)) %>" max="<%= formato.format(new Date())%>" required="true" placeholder="Digite sua data de nascimento"></label></p>

            <p><input type="submit" value="Alterar"></p>
        </form>
        <p><a href="controle?acao=default">Voltar</a></p>

    </body>
</html>
