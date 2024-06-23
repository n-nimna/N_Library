package org.apache.jsp.views.Admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.team2.controller.utill.assetsUrl;

public final class admin_005fpage_005ftemplate_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/views/Admin/admincommon/sidebar.jspf");
  }

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
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
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"UTF-8\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("    <title>N-Library Dashboard</title>\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css\" integrity=\"sha512-iecdLmaskl7CVkqk1wZxL+h7yzfrPLIXD\" crossorigin=\"anonymous\" referrerpolicy=\"no-referrer\" />\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"");
      out.print(assetsUrl.giveUrl(request, "styles/admin.css"));
      out.write("\"/>\r\n");
      out.write("   <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\">\r\n");
      out.write("    <style>\r\n");
      out.write("        .sidebar {\r\n");
      out.write("            height: 100vh;\r\n");
      out.write("            position: fixed;\r\n");
      out.write("            width: 200px;\r\n");
      out.write("            top: 0;\r\n");
      out.write("            left: 0;\r\n");
      out.write("            background-color: #343a40;\r\n");
      out.write("            color: white;\r\n");
      out.write("        }\r\n");
      out.write("        .sidebar a {\r\n");
      out.write("            color: white;\r\n");
      out.write("            padding: 15px;\r\n");
      out.write("            display: block;\r\n");
      out.write("            text-decoration: none;\r\n");
      out.write("        }\r\n");
      out.write("        .sidebar a:hover {\r\n");
      out.write("            background-color: #575d63;\r\n");
      out.write("        }\r\n");
      out.write("        .content {\r\n");
      out.write("            margin-left: 200px;\r\n");
      out.write("            padding: 20px;\r\n");
      out.write("        }\r\n");
      out.write("    </style>\r\n");
      out.write("    \r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("    ");
      out.write("<div class=\"sidebar\">\r\n");
      out.write("        <a href=\"#\">\r\n");
      out.write("            <i class=\"fas fa-book-open\" style=\"margin: 0;\"></i>\r\n");
      out.write("            <span>N Library</span>\r\n");
      out.write("        </a>\r\n");
      out.write("        <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/admin/home\">\r\n");
      out.write("            <i class=\"fas fa-home\"></i>\r\n");
      out.write("            <span>Home</span>\r\n");
      out.write("        </a>\r\n");
      out.write("        <a href=\"#\">\r\n");
      out.write("            <i class=\"fas fa-arrow-down\"></i>\r\n");
      out.write("            <span>Borrow Books</span>\r\n");
      out.write("        </a>\r\n");
      out.write("        <a href=\"#\">\r\n");
      out.write("            <i class=\"fas fa-arrow-up\"></i>\r\n");
      out.write("            <span>Return Books</span>\r\n");
      out.write("        </a>\r\n");
      out.write("        <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/admin/students/\">\r\n");
      out.write("            <i class=\"fas fa-users\"></i>\r\n");
      out.write("            <span>Students</span>\r\n");
      out.write("        </a>\r\n");
      out.write("        <a href=\"#\">\r\n");
      out.write("            <i class=\"fas fa-book\"></i>\r\n");
      out.write("            <span>Books</span>\r\n");
      out.write("        </a>\r\n");
      out.write("        <a href=\"#\">\r\n");
      out.write("            <i class=\"fas fa-tags\"></i>\r\n");
      out.write("            <span>Book Categories</span>\r\n");
      out.write("        </a>\r\n");
      out.write("        <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/admin/manage-admin/\">\r\n");
      out.write("            <i class=\"fas fa-user-shield\"></i>\r\n");
      out.write("            <span>Admins</span>\r\n");
      out.write("        </a>\r\n");
      out.write("        <a href=\"#\">\r\n");
      out.write("            <i class=\"fas fa-sign-out-alt\"></i>\r\n");
      out.write("            <span>Log Out</span>\r\n");
      out.write("        </a>\r\n");
      out.write("    </div>");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    <div class=\"content\">\r\n");
      out.write("        <div class=\"adminName\">\r\n");
      out.write("            <h2>Kavindu Kaveesha</h2>\r\n");
      out.write("            \r\n");
      out.write("           <div class=\"content container-fluid\">\r\n");
      out.write("            <button class=\"btn btn-success my-3\">Add New Book</button>\r\n");
      out.write("            <table class=\"table table-hover\">\r\n");
      out.write("                <thead class=\"thead-light\">\r\n");
      out.write("                    <tr>\r\n");
      out.write("                        <th>Book ID</th>\r\n");
      out.write("                        <th>Name</th>\r\n");
      out.write("                        <th>Category</th>\r\n");
      out.write("                        <th>Quantity</th>\r\n");
      out.write("                        <th>Author</th>\r\n");
      out.write("                        <th>Available</th>\r\n");
      out.write("                        <th>Actions</th>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                </thead>\r\n");
      out.write("                <tbody>\r\n");
      out.write("                    <tr>\r\n");
      out.write("                        <td>1</td>\r\n");
      out.write("                        <td>Book Name 1</td>\r\n");
      out.write("                        <td>Category 1</td>\r\n");
      out.write("                        <td>10</td>\r\n");
      out.write("                        <td>Author 1</td>\r\n");
      out.write("                        <td>Yes</td>\r\n");
      out.write("                        <td>\r\n");
      out.write("                            <button class=\"btn btn-outline-secondary btn-sm\">Edit</button>\r\n");
      out.write("                            <button class=\"btn btn-outline-danger btn-sm\">Delete</button>\r\n");
      out.write("                        </td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                  \r\n");
      out.write("                </tbody>\r\n");
      out.write("            </table>\r\n");
      out.write("        </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("  \r\n");
      out.write("\r\n");
      out.write("    <script src=\"https://code.jquery.com/jquery-3.5.1.slim.min.js\"></script>\r\n");
      out.write("    <script src=\"https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js\"></script>\r\n");
      out.write("    <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js\"></script>\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
      out.write("</html>\r\n");
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
