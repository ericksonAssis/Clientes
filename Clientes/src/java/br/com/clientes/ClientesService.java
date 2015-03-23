/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.clientes;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Erickson
 */
public class ClientesService {

    private ClientesDAO dao;
    private String msg;
    final Date dataMinima;
    final Date dataMaxima;

    public ClientesService() {

        dataMinima = new Date(1);
        dataMaxima = new Date();
    }

    public String getMsg() {
        return msg;
    }

    public Clientes selecionarPorId(int idCliente) {

        dao = new ClientesDAO();
        Clientes cliente = dao.selecionarPorId(idCliente);
        msg = dao.getMsg();
        return cliente;
    }

    public List<Clientes> selecionarTodos() {

        dao = new ClientesDAO();
        List<Clientes> lista = dao.selecionarTodos();
        msg = dao.getMsg();
        return lista;
    }

    public void inserir(String nome, String cpf, String email, String telefone, String endereco, Date dataNascimento) {
        dao = new ClientesDAO();
        if (nome == null) {
            nome = "";
        }
        if (!nome.equals("")) {
            if (nome.trim().length() > 50) {
                nome = nome.trim().substring(0, 50);
            }
            if (dataNascimento.getTime() <= dataMinima.getTime()) {
                if (dataNascimento.getTime() >= dataMaxima.getTime()) {
                    if (!cpf.equals("") && cpf.length() == 11) {
                        if (!email.equals("") && email.length() <= 50) {
                            if (!telefone.equals("") && telefone.length() <= 14) {
                                if (!endereco.equals("") && endereco.length() <= 50) {

                                    Clientes cliente = new Clientes();
                                    cliente.setIdCliente(0);
                                    cliente.setNome((nome));
                                    cliente.setCpf(cpf);
                                    cliente.setEmail(email);
                                    cliente.setTelefone(telefone);
                                    cliente.setEndereco(endereco);
                                    cliente.setDataNascimento(dataNascimento);
                                    dao.inserir(cliente);
                                    msg = dao.getMsg();
                                } else {
                                    msg = "Endereço muito longo";
                                }
                            } else {
                                msg = "Telefone muito longo";
                            }
                        } else {
                            msg = "Endereço muito longo";
                        }
                    } else {
                        msg = "CPF muito longo";
                    }
                } else {
                    msg = "Data de Nascimento deve estar no passado" + dataNascimento;
                }
            } else {
                msg = "Data de Nascimento deve ser superior a 1/Jan/1970" + dataNascimento;
            }
        } else {
            msg = "Nome precisa ser informado";
        }
    }

    public void alterar(String nome, String cpf, String email, String telefone, String endereco, Date dataNascimento) {


        dao = new ClientesDAO();
        if (nome == null) {
            nome = "";
        }
        if (!nome.equals("")) {
            if (nome.trim().length() > 50) {
                nome = nome.trim().substring(0, 50);
            }
            if (dataNascimento.getTime() <= dataMinima.getTime()) {
                if (dataNascimento.getTime() >= dataMaxima.getTime()) {
                    if (!cpf.equals("") && cpf.length() == 11) {
                        if (!email.equals("") && email.length() <= 50) {
                            if (!telefone.equals("") && telefone.length() <= 14) {
                                if (!endereco.equals("") && endereco.length() <= 50) {

                                    Clientes cliente = new Clientes();
                                    cliente.setNome((nome));
                                    cliente.setCpf(cpf);
                                    cliente.setEmail(email);
                                    cliente.setTelefone(telefone);
                                    cliente.setEndereco(endereco);
                                    cliente.setDataNascimento(dataNascimento);
                                    dao.alterar(cliente);
                                    msg = dao.getMsg();
                                } else {
                                    msg = "Endereço muito longo";
                                }
                            } else {
                                msg = "Telefone muito longo";
                            }
                        } else {
                            msg = "Endereço muito longo";
                        }
                    } else {
                        msg = "CPF muito longo";
                    }
                } else {
                    msg = "Data de Nascimento deve estar no passado";
                }
            } else {
                msg = "Data de Nascimento deve ser superior a 1/Jan/1970" + dataNascimento;
            }
        } else {
            msg = "Nome precisa ser informado";
        }
    }

    public void apagar(int idCliente) {
        dao = new ClientesDAO();
        Clientes cliente = new Clientes();
        cliente.setNome("");
        cliente.setDataNascimento(new Date());
        cliente.setCpf("");
        cliente.setEmail("");
        cliente.setEndereco("");
        cliente.setTelefone("");
        dao.apagar(cliente);
        msg = dao.getMsg();
    }
}
