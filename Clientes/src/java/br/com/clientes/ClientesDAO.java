/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.clientes;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Erickson
 */
public class ClientesDAO {

    private String msg;


    Clientes selecionarPorId(int id) {
        Conexao conexao = new Conexao();
        msg = conexao.consultar(String.format(
                "Select * from App.Clientes where idCliente=%d", id));
        if (msg.equals("Sucesso")) {
            ResultSet r = conexao.getRetorno();
            try {
                r.next();
                Clientes cliente = new Clientes();
                cliente.setIdCliente(r.getInt("idCliente"));
                cliente.setNome(r.getString("nome"));
                cliente.setCpf(r.getString("cpf"));
                cliente.setEmail(r.getString("email"));
                cliente.setTelefone(r.getString("telefone"));
                cliente.setEndereco(r.getString("endereco"));
                cliente.setDataNascimento(r.getDate("dataNascimento"));
                return cliente;
            } catch (SQLException ex) {
                msg = String.format("Problemas em consulta : %s", ex.getLocalizedMessage());
                return null;
            }
        } else {
            return null;
        }
    }

    List<Clientes> selecionarTodos() {

        Conexao conexao = new Conexao();
        msg = conexao.consultar("Select * From App.Clientes");
        if (msg.equals("Sucesso")) {
            ResultSet r = conexao.getRetorno();
            try {
                List<Clientes> lista = new ArrayList();
                while (r.next()) {
                    Clientes cliente = new Clientes();
                    cliente.setIdCliente(r.getInt("idCliente"));
                    cliente.setNome(r.getString("nome"));
                    cliente.setCpf(r.getString("cpf"));
                    cliente.setEmail(r.getString("email"));
                    cliente.setTelefone(r.getString("telefone"));
                    cliente.setEndereco(r.getString("endereco"));
                    cliente.setDataNascimento(r.getDate("dataNascimento"));
                    lista.add(cliente);
                }
                return lista;
            } catch (SQLException ex) {

                msg = String.format("Problemas em consulta %s", ex.getLocalizedMessage());
                return null;
            }
        } else {
            return null;
        }
    }

    void inserir(Clientes cliente) {
        Conexao conexao = new Conexao();
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        String sql = String.format("Insert into App.Clientes "
                + "(nome, cpf, email, telefone, endereco, dataNascimento)"
                + "values('%s','%s','%s', '%s','%s','%s')",
                cliente.getNome(), cliente.getCpf(), cliente.getEmail(), cliente.getTelefone(),
                cliente.getEndereco(), formato.format(cliente.getDataNascimento()));
        msg = conexao.executar(sql);

    }

    void alterar(Clientes cliente) {
        Conexao conexao = new Conexao();
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        String sql = String.format("Update App.Clientes "
                + "set nome = '%s', cpf = '%s', email = '%s', telefone = '%s', endereco = '%s', dataNascimento = '%s'",
                cliente.getNome(), cliente.getCpf(), cliente.getEmail(), cliente.getTelefone(),
                cliente.getEndereco(), formato.format(cliente.getDataNascimento()));
        msg = conexao.executar(sql);


    }

    void apagar(Clientes cliente) {
        if (msg.equals("Sucesso")) {

            Conexao conexao = new Conexao();
            String sql = String.format("Delete from app.Clientes "
                    + "Where id = %d", cliente.getIdCliente());
            msg = conexao.executar(sql);

        }
    }

    String getMsg() {
        return msg;
    }
}
