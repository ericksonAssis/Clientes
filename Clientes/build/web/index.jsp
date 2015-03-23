<%-- 
    Document   : index
    Created on : 22/03/2015, 10:08:13
    Author     : Erickson
--%>

<%@page import="br.com.clientes.Clientes"%>
<%@page import="java.util.List"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="br.com.clientes.ClientesService"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <style>

            table{border-collapse: collapse;}
            th{background-color: gray; color: white;}
            th, td{padding: 10px;}
            a{font-weight: bold;color: blue;}
            a:link, a:visited{text-decoration: none;}
            a:hover, a:active{text-decoration: underline;}



        </style>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manutenção de Clientes</title>
    </head>
    <body>
        <%
            ClientesService service = new ClientesService();
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            List<Clientes> clientes = service.selecionarTodos();
            String msg = service.getMsg();
            if (!msg.equals("Sucesso")) {
                response.sendRedirect(
                        String.format("controle?acao=exibirErro&msg=%s", msg));
            }

        %>
        <section>
            <h1>Manutenção de Clientes</h1>
            <table>
                <thead>
                    <tr>
                        <th>ID Cliente</th><th>Nome</th>
                        <th>CPF</th>
                        <th>Email</th><th>Telefone</th>
                        <th>Data de Nascimento</th>
                        <th>Ações</th>

                    </tr>
                </thead>
                <tbody>
                    <%
                        if (clientes != null) {
                            for (Clientes cliente : clientes) {

                    %>
                    <tr>
                        <td><%=cliente.getIdCliente()%></td><td><%=cliente.getNome()%></td>
                        <td><%=cliente.getCpf()%></td><td><%=cliente.getEmail()%></td><td><%=cliente.getTelefone()%></td>
                        <td><%=cliente.getDataNascimento()%></td>
                        <td>
                            <a href="controle?acao=excluir&id=<%=cliente.getIdCliente()%>">
                                Exluir</a>&nbsp;
                            <a href="controle?acao=formAlterar&id=<%=cliente.getIdCliente()%>">
                                Alterar</a>&nbsp;
                        </td>
                    </tr>
                    <%
                            }
                        }
                    %>
                </tbody>
            </table>
            <p><a href="controle?acao=formIncluir">Incluir</a></p>
        </section>
    </body>
</html>
