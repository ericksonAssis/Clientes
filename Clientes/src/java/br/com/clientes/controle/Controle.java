/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.clientes.controle;

import br.com.clientes.Clientes;
import br.com.clientes.ClientesService;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Erickson
 */
@WebServlet(name = "Controle", urlPatterns = {"/controle"})
public class Controle extends HttpServlet {

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        ClientesService service = new ClientesService();
        RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
        String acao = request.getParameter("acao");
        if (acao == null) {
            acao = "default";
        }
        if (acao.equals("")) {
            acao = "default";
        }

        String msg = request.getParameter("msg");
        String idCliente = request.getParameter("id");
        int idN;
        String nome = request.getParameter("nome");
        String data = request.getParameter("dataNascimento");
        String cpf = request.getParameter("cpf");
        String email = request.getParameter("email");
        String endereco = request.getParameter("endereco");
        String telefone = request.getParameter("telefone");
        Date dataD;
        if (acao.equals("formIncluir")) {
            rd = request.getRequestDispatcher("insere.jsp");
        }
        if (acao.equals("formAlterar")) {
            idN = Integer.parseInt(idCliente);
            Clientes cliente = service.selecionarPorId(idN);
            msg = service.getMsg();
            if (msg.equals("Sucesso")) {
                rd = request.getRequestDispatcher("altera.jsp");
                request.setAttribute("cliente", cliente);
            } else {
                rd = request.getRequestDispatcher("mensagem.jsp");
                {
                    request.setAttribute("msg", msg);
                }
            }
        }

        if (acao.equals("alterar")) {
            idN = Integer.parseInt(idCliente);
            try {
                dataD = formato.parse(data);
            } catch (ParseException ex) {
                dataD = new Date();
            }

            service.alterar(nome, cpf, email, telefone, endereco, dataD);
            msg = service.getMsg();
            if (!msg.equals("Sucesso")) {
                rd = request.getRequestDispatcher("mensagem.jsp");
                request.setAttribute("msg", msg);
            }
        }

        if (acao.equals("inserir")) {
            try {
                dataD = formato.parse(data);
            } catch (ParseException ex) {
                dataD = new Date();
            }

            service.inserir(nome, cpf, email, telefone, endereco, dataD);
            msg = service.getMsg();
            if (!msg.equals("Sucesso")) {
                rd = request.getRequestDispatcher("mensagem.jsp");
                request.setAttribute("msg", msg);
            }

        }

        if (acao.equals("excluir")) {
            idN = Integer.parseInt(idCliente);
            service.apagar(idN);
            msg = service.getMsg();
            if (!msg.equals("Sucesso")) {
                rd = request.getRequestDispatcher("mensagem.jsp");
                request.setAttribute("msg", msg);
            }

        }

        if (acao.equals("exibirErro")) {
            rd = request.getRequestDispatcher("mensagem.jsp");
            request.setAttribute("msg", msg);
        }
        if (acao.equals("default")) {
        }
        
        rd.forward(request, response);


        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Controle</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Controle at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
             */
        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
