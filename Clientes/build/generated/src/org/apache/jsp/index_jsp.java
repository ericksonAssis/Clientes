package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import br.com.clientes.Clientes;
import java.util.List;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import br.com.clientes.ClientesService;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.Vector _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <style>\n");
      out.write("\n");
      out.write("            table{border-collapse: collapse;}\n");
      out.write("            th{background-color: gray; color: white;}\n");
      out.write("            th, td{padding: 10px;}\n");
      out.write("            a{font-weight: bold;color: blue;}\n");
      out.write("            a:link, a:visited{text-decoration: none;}\n");
      out.write("            a:hover, a:active{text-decoration: underline;}\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        </style>\n");
      out.write("\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Manutenção de Clientes</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");

            ClientesService service = new ClientesService();
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            List<Clientes> clientes = service.selecionarTodos();
            String msg = service.getMsg();
            if (!msg.equals("Sucesso")) {
                response.sendRedirect(
                        String.format("controle?acao=exibirErro&msg=%s", msg));
            }

        
      out.write("\n");
      out.write("        <section>\n");
      out.write("            <h1>Manutenção de Clientes</h1>\n");
      out.write("            <table>\n");
      out.write("                <thead>\n");
      out.write("                    <tr>\n");
      out.write("                        <th>ID Cliente</th><th>Nome</th>\n");
      out.write("                        <th>CPF</th>\n");
      out.write("                        <th>Email</th><th>Telefone</th>\n");
      out.write("                        <th>Data de Nascimento</th>\n");
      out.write("                        <th>Ações</th>\n");
      out.write("\n");
      out.write("                    </tr>\n");
      out.write("                </thead>\n");
      out.write("                <tbody>\n");
      out.write("                    ");

                        if (clientes != null) {
                            for (Clientes cliente : clientes) {

                    
      out.write("\n");
      out.write("                    <tr>\n");
      out.write("                        <td>");
      out.print(cliente.getIdCliente());
      out.write("</td><td>");
      out.print(cliente.getNome());
      out.write("</td>\n");
      out.write("                        <td>");
      out.print(cliente.getCpf());
      out.write("</td><td>");
      out.print(cliente.getEmail());
      out.write("</td><td>");
      out.print(cliente.getTelefone());
      out.write("</td>\n");
      out.write("                        <td>");
      out.print(cliente.getDataNascimento());
      out.write("</td>\n");
      out.write("                        <td>\n");
      out.write("                            <a href=\"controle?acao=excluir&id=");
      out.print(cliente.getIdCliente());
      out.write("\">\n");
      out.write("                                Exluir</a>&nbsp;\n");
      out.write("                            <a href=\"controle?acao=formAlterar&id=");
      out.print(cliente.getIdCliente());
      out.write("\">\n");
      out.write("                                Alterar</a>&nbsp;\n");
      out.write("                        </td>\n");
      out.write("                    </tr>\n");
      out.write("                    ");

                            }
                        }
                    
      out.write("\n");
      out.write("                </tbody>\n");
      out.write("            </table>\n");
      out.write("            <p><a href=\"controle?acao=formIncluir\">Incluir</a></p>\n");
      out.write("        </section>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
