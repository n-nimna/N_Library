package org.apache.jsp.views.Admin.barrowed_005fbooks;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.team2.controller.utill.assetsUrl;
import com.team2.models.User;
import java.util.List;
import com.team2.controller.utill.assetsUrl;

public final class barrowed_005fbook_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(2);
    _jspx_dependants.add("/views/Admin/admincommon/sidebar.jspf");
    _jspx_dependants.add("/views/Admin/admincommon/header.jsp");
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

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n");
      out.write("        <title>New Book Borrowing</title>\n");
      out.write("        <!-- Bootstrap CSS -->\n");
      out.write("        <link href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css\" integrity=\"sha512-iecdLmaskl7CVkqk1wZxL+h7yzfrPLIXD\" crossorigin=\"anonymous\" referrerpolicy=\"no-referrer\" />\n");
      out.write("        <link rel=\"stylesheet\" href=\"");
      out.print(assetsUrl.giveUrl(request, "styles/admin.css"));
      out.write("\"/>\n");
      out.write("\n");
      out.write("\n");
      out.write("        <style>\n");
      out.write("            .right {\n");
      out.write("                margin-left: 250px;\n");
      out.write("\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    <body>\n");
      out.write("        ");
      out.write("<div class=\"sidebar\">\n");
      out.write("        <a>\n");
      out.write("            <i class=\"fas fa-book-open\" style=\"margin: 0;\"></i>\n");
      out.write("            <span>N Library</span>\n");
      out.write("        </a>\n");
      out.write("        <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/admin/home\">\n");
      out.write("            <i class=\"fas fa-home\"></i>\n");
      out.write("            <span>Home</span>\n");
      out.write("        </a>\n");
      out.write("        <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/admin/barrowbooks/\">\n");
      out.write("            <i class=\"fas fa-arrow-down\"></i>\n");
      out.write("            <span>Borrow Books</span>\n");
      out.write("        </a>\n");
      out.write("        \n");
      out.write("        <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/admin/students/\">\n");
      out.write("            <i class=\"fas fa-users\"></i>\n");
      out.write("            <span>Students</span>\n");
      out.write("        </a>\n");
      out.write("        <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/admin/books/\">\n");
      out.write("            <i class=\"fas fa-book\"></i>\n");
      out.write("            <span>Books</span>\n");
      out.write("        </a>\n");
      out.write("        <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/admin/bookcategories/\">\n");
      out.write("            <i class=\"fas fa-tags\"></i>\n");
      out.write("            <span>Book Categories</span>\n");
      out.write("        </a>\n");
      out.write("        <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/admin/manage-admin/\">\n");
      out.write("            <i class=\"fas fa-user-shield\"></i>\n");
      out.write("            <span>Admins</span>\n");
      out.write("        </a>\n");
      out.write("        <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/logout\">\n");
      out.write("            <i class=\"fas fa-sign-out-alt\"></i>\n");
      out.write("            <span>Log Out</span>\n");
      out.write("        </a>\n");
      out.write("    </div>");
      out.write("\n");
      out.write("\n");
      out.write("        <div class=\"content\">\n");
      out.write("            ");
      out.write('\n');

    // Check if the user is logged in
    if (session == null || session.getAttribute("loggedInUser") == null) {
        response.sendRedirect(request.getContextPath() + "/login");
        return;
    } else {
        // Get user attributes if logged in
        String userName = (String) session.getAttribute("username");
        String userImage = (String) session.getAttribute("userImage");
        int userId = (int) session.getAttribute("userId");


      out.write("\n");
      out.write("<div class=\"adminName\">\n");
      out.write("    <input type=\"hidden\" name=\"userId\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${userId}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\n");
      out.write("    <h2>");
      out.print(userName);
      out.write("</h2>\n");
      out.write("    <img \n");
      out.write("        src=\"");
      out.print( assetsUrl.giveUrl(request, "DBImages/") + userImage );
      out.write("\" alt=\"User Image\" class=\"img-fluid rounded-circle\" width=\"50\">\n");
      out.write("</div>\n");
    }

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("            <div class=\"container form-container mt-5 p-3\">\n");
      out.write("                <div class=\"row mb-3\">\n");
      out.write("                    <div class=\"col-6\">\n");
      out.write("                        <h2 class=\"\">New Book Borrowing</h2>\n");
      out.write("                    </div>                  \n");
      out.write("                    <div class=\"col-6\">\n");
      out.write("\n");
      out.write("                        <div class=\"col-6\"style=\"display: flex;justify-content: flex-end\">\n");
      out.write("                            <a class=\"btn btn-dark\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/admin/students/\"style=\"margin: 2% 0\">All Students</a>\n");
      out.write("\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("                <div class=\"row\">\n");
      out.write("                    <div class=\"col-md-6\">\n");
      out.write("                        <h3>User Details</h3>\n");
      out.write("                        <form action=\"barrowedBook\" method=\"post\">\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label for=\"userId\">User Id</label>\n");
      out.write("                                <input type=\"text\" class=\"form-control\" id=\"userId\">\n");
      out.write("                                <button type=\"button\" class=\"btn btn-dark mt-2\">Find User</button>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label for=\"userName\">User Name</label><input type=\"text\" class=\"form-control\" id=\"userName\" disabled>\n");
      out.write("\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label for=\"contactNumber\">Contact Number</label>\n");
      out.write("                                <input type=\"text\" class=\"form-control\" id=\"contactNumber\" disabled>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label for=\"address\">Address</label>\n");
      out.write("                                <input type=\"text\" class=\"form-control\" id=\"address\" disabled>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label for=\"email\">Email</label>\n");
      out.write("                                <input type=\"email\" class=\"form-control\" id=\"email\" disabled>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label for=\"booksToReturn\">Books to Return</label>\n");
      out.write("                                <input type=\"text\" class=\"form-control\" id=\"booksToReturn\" disabled>\n");
      out.write("                            </div>\n");
      out.write("                        </form>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                    <div class=\"col-md-6\">\n");
      out.write("                        <h3>Book Details</h3>\n");
      out.write("                        <form action=\"\" method=\"get\">\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label for=\"bookId\">Book Id</label>\n");
      out.write("                                <input type=\"text\" class=\"form-control\" id=\"bookId\">\n");
      out.write("                                <button type=\"button\" class=\"btn btn-dark mt-2\">Find Book</button>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label for=\"bookAvailability\">Book Availability</label>\n");
      out.write("                                <input type=\"text\" class=\"form-control\" id=\"bookAvailability\" value=\"true\" disabled>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <img src=\"book_image_url\" alt=\"Book Image\" class=\"img-thumbnail\">\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label for=\"bookName\">Book Name</label>\n");
      out.write("                                <input type=\"text\" class=\"form-control\" id=\"bookName\" disabled>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label for=\"category\">Category</label>\n");
      out.write("                                <input type=\"text\" class=\"form-control\" id=\"category\" disabled>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label for=\"author\">Author</label>\n");
      out.write("                                <input type=\"text\" class=\"form-control\" id=\"author\" disabled>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label for=\"edition\">Edition</label>\n");
      out.write("                                <input type=\"text\" class=\"form-control\" id=\"edition\" disabled>\n");
      out.write("                            </div>\n");
      out.write("                        </form>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <div class=\"row mt-4\">\n");
      out.write("                    <div class=\"col-md-12\">\n");
      out.write("                        <h3>Borrow Details</h3>\n");
      out.write("                        <form action=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/admin/barrowbooks/new\" method=\"post\">\n");
      out.write("                            <div class=\"form-row\">\n");
      out.write("                                <div class=\"form-group col-md-4\">\n");
      out.write("                                    <label for=\"borrowBookId\">Book Id</label>\n");
      out.write("                                    <input type=\"text\" class=\"form-control\" id=\"borrowBookId\" name=\"bookId\">\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"form-group col-md-4\">\n");
      out.write("                                    <label for=\"borrowUserId\">User Id</label>\n");
      out.write("                                    <input type=\"text\" class=\"form-control\" id=\"borrowUserId\" name=\"userId\">\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"form-group col-md-4\">\n");
      out.write("                                    <label for=\"borrowDate\">Borrow Date</label>\n");
      out.write("                                    <input type=\"date\" class=\"form-control\" id=\"borrowDate\" name=\"barrowDate\">\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"form-group col-md-4\">\n");
      out.write("                                    <label for=\"returnDate\">Return Date</label>\n");
      out.write("                                    <input type=\"date\" class=\"form-control\" id=\"returnDate\" name=\"returnDate\">\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                            <button type=\"submit\" class=\"btn btn-success\">Borrow Book</button>\n");
      out.write("                        </form>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("            <script src=\"https://code.jquery.com/jquery-3.5.1.slim.min.js\"></script>\n");
      out.write("            <script src=\"https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js\"></script>\n");
      out.write("            <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js\"></script>\n");
      out.write("            <script src=\"https://cdn.jsdelivr.net/npm/sweetalert2@11\"></script>\n");
      out.write("\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("\n");
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
