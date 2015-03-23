package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Date;
import java.text.SimpleDateFormat;

public final class insere_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Insere cliente</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>Inserir Cliente</h1>\n");
      out.write("        <form method=\"post\" action=\"controle\">\n");
      out.write("            <input type=\"hidden\" name=\"acao\" value=\"inserir\">\n");
      out.write("            <p><label>Nome: <input type=\"text\" name=\"nome\"\n");
      out.write("                                   placeholder=\"Digite o seu nome\" required=\"true\"></label></p>\n");
      out.write("            <p><label>CPF: <input type=\"text\" name=\"cpf\" \n");
      out.write("                                  placeholder=\"Digite o seu cpf\" pattern=\".{11,11}\" title=\"Insira 11 characteres numéricos\"\n");
      out.write("                                  required=\"true\"/>\n");
      out.write("                </label></p>\n");
      out.write("            <p><label>\n");
      out.write("                    E-mail: <input type=\"text\" name=\"email\" pattern=\"[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}$\"\n");
      out.write("                                   required=\"true\" placeholder=\"Digite o seu email\" />\n");
      out.write("                </label></p>\n");
      out.write("            <p><label>\n");
      out.write("                    Telefone: <input type=\"number\" name=\"telefone\" \n");
      out.write("                                     required=\"true\" placeholder=\"Digite o seu telefone\" pattern=\"[0-9]\"></label></p>\n");
      out.write("            <p><label>Endereço: <input type=\"text\" name=\"endereco\" required=\"true\" placeholder=\"Digite o seu endereço\"></label><p>\n");
      out.write("                    ");

                        SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
                    
      out.write("\n");
      out.write("            <p><label>Data de nascimento: <input type=\"date\" name=\"data\" min=\"");
      out.print( formato.format(new Date(1)));
      out.write("\" max=\"");
      out.print( formato.format(new Date()));
      out.write("\" required=\"true\" placeholder=\"Digite sua data de nascimento\"></label></p>\n");
      out.write("            <p><input type=\"submit\" value=\"inserir\"></p>\n");
      out.write("        </form>\n");
      out.write("        <p><a href=\"controle?acao=default\">Voltar</a></p>\n");
      out.write("</html>\n");
      out.write("\n");
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
