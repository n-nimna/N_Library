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

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta charset=\"UTF-8\">\r\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\r\n");
      out.write("        <title>New Book Borrowing</title>\r\n");
      out.write("        <!-- Bootstrap CSS -->\r\n");
      out.write("        <link href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\" rel=\"stylesheet\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css\" integrity=\"sha512-iecdLmaskl7CVkqk1wZxL+h7yzfrPLIXD\" crossorigin=\"anonymous\" referrerpolicy=\"no-referrer\" />\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"");
      out.print(assetsUrl.giveUrl(request, "styles/admin.css"));
      out.write("\"/>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <style>\r\n");
      out.write("            .right {\r\n");
      out.write("                margin-left: 250px;\r\n");
      out.write("\r\n");
      out.write("            }\r\n");
      out.write("        </style>\r\n");
      out.write("    </head>\r\n");
      out.write("\r\n");
      out.write("    <body>\r\n");
      out.write("        ");
      out.write("<div class=\"sidebar\">\r\n");
      out.write("        <a>\r\n");
      out.write("            <i class=\"fas fa-book-open\" style=\"margin: 0;\"></i>\r\n");
      out.write("            <span>N Library</span>\r\n");
      out.write("        </a>\r\n");
      out.write("        <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/admin/home\">\r\n");
      out.write("            <i class=\"fas fa-home\"></i>\r\n");
      out.write("            <span>Home</span>\r\n");
      out.write("        </a>\r\n");
      out.write("        <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/admin/barrowbooks/\">\r\n");
      out.write("            <i class=\"fas fa-arrow-down\"></i>\r\n");
      out.write("            <span>Borrow Books</span>\r\n");
      out.write("        </a>\r\n");
      out.write("        \r\n");
      out.write("        <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/admin/students/\">\r\n");
      out.write("            <i class=\"fas fa-users\"></i>\r\n");
      out.write("            <span>Students</span>\r\n");
      out.write("        </a>\r\n");
      out.write("        <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/admin/books/\">\r\n");
      out.write("            <i class=\"fas fa-book\"></i>\r\n");
      out.write("            <span>Books</span>\r\n");
      out.write("        </a>\r\n");
      out.write("        <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/admin/bookcategories/\">\r\n");
      out.write("            <i class=\"fas fa-tags\"></i>\r\n");
      out.write("            <span>Book Categories</span>\r\n");
      out.write("        </a>\r\n");
      out.write("        <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/admin/manage-admin/\">\r\n");
      out.write("            <i class=\"fas fa-user-shield\"></i>\r\n");
      out.write("            <span>Admins</span>\r\n");
      out.write("        </a>\r\n");
      out.write("        <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/logout\">\r\n");
      out.write("            <i class=\"fas fa-sign-out-alt\"></i>\r\n");
      out.write("            <span>Log Out</span>\r\n");
      out.write("        </a>\r\n");
      out.write("    </div>");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"content\">\r\n");
      out.write("            ");
      out.write('\r');
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


      out.write("\r\n");
      out.write("<div class=\"adminName\">\r\n");
      out.write("    <input type=\"hidden\" name=\"userId\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${userId}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("    <h2>");
      out.print(userName);
      out.write("</h2>\r\n");
      out.write("    <img \r\n");
      out.write("        src=\"");
      out.print( assetsUrl.giveUrl(request, "DBImages/") + userImage );
      out.write("\" alt=\"User Image\" class=\"img-fluid rounded-circle\" width=\"50\">\r\n");
      out.write("</div>\r\n");
    }

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("            <div class=\"container form-container mt-5 p-3\">\r\n");
      out.write("                <div class=\"row mb-3\">\r\n");
      out.write("                    <div class=\"col-6\">\r\n");
      out.write("                        <h2 class=\"\">New Book Borrowing</h2>\r\n");
      out.write("                    </div>                  \r\n");
      out.write("                    <div class=\"col-6\">\r\n");
      out.write("\r\n");
      out.write("                        <div class=\"col-6\" style=\"display: flex;justify-content: flex-end\">\r\n");
      out.write("                            <a class=\"btn btn-dark\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/admin/students/\" style=\"margin: 2% 0\">All Students</a>\r\n");
      out.write("\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"row\">\r\n");
      out.write("                    <div class=\"col-md-6\">\r\n");
      out.write("                        <h3>User Details</h3>\r\n");
      out.write("                        <form action=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/admin/students/findByNic\" method=\"get\">\r\n");
      out.write("                            <div class=\"form-group\">\r\n");
      out.write("                                <label for=\"userId\">User Id</label>\r\n");
      out.write("                                <input type=\"text\" class=\"form-control\" id=\"userId\" name=\"id\">\r\n");
      out.write("                                <button type=\"submit\" class=\"btn btn-dark mt-2\">Find User</button>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"form-group\">\r\n");
      out.write("                                <label for=\"userName\">User Name</label><input type=\"text\" class=\"form-control\" id=\"userName\" disabled value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${student.firstName}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(' ');
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${student.lastName}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"form-group\">\r\n");
      out.write("                                <label for=\"contactNumber\">Contact Number</label>\r\n");
      out.write("                                <input type=\"text\" class=\"form-control\" id=\"contactNumber\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${student.phoneNumber}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"form-group\">\r\n");
      out.write("                                <label for=\"address\">Address</label>\r\n");
      out.write("                                <input type=\"text\" class=\"form-control\" id=\"address\" disabled value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${student.address}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"form-group\">\r\n");
      out.write("                                <label for=\"email\">Email</label>\r\n");
      out.write("                                <input type=\"email\" class=\"form-control\" id=\"email\" disabled value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${student.email}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("                            </div>\r\n");
      out.write("                             <div class=\"form-group\">\r\n");
      out.write("                                <label for=\"email\">Active State</label>\r\n");
      out.write("                                <input type=\"email\" class=\"form-control\" id=\"email\" disabled value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${student.active}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"form-group\">\r\n");
      out.write("                                <label for=\"booksToReturn\">Books to Return</label>\r\n");
      out.write("                                <input type=\"text\" class=\"form-control\" id=\"booksToReturn\" disabled>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </form>\r\n");
      out.write("                    </div>\r\n");
      out.write("\r\n");
      out.write("                    <div class=\"col-md-6\">\r\n");
      out.write("                        <h3>Book Details</h3>\r\n");
      out.write("                        <form action=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/admin/books/findById\" method=\"get\">\r\n");
      out.write("                            <div class=\"form-group\">\r\n");
      out.write("                                <label for=\"bookId\">Book Id</label>\r\n");
      out.write("                                <input type=\"text\" class=\"form-control\" id=\"bookId\" name=\"id\">\r\n");
      out.write("                                <button type=\"submit\" class=\"btn btn-dark mt-2\">Find Book</button>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"form-group\">\r\n");
      out.write("                                <label for=\"bookAvailability\">Book Availability</label>\r\n");
      out.write("                                <input type=\"text\" class=\"form-control\" id=\"bookAvailability\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${book.available}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" disabled>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"form-group\">\r\n");
      out.write("                                <img src=\"DBImages/");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${book.image}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" alt=\"Book Image\" class=\"img-thumbnail\" >\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"form-group\">\r\n");
      out.write("                                <label for=\"bookName\">Book Name</label>\r\n");
      out.write("                                <input type=\"text\" class=\"form-control\" id=\"bookName\" disabled value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${book.title}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"form-group\">\r\n");
      out.write("                                <label for=\"category\">Category</label>\r\n");
      out.write("                                <input type=\"text\" class=\"form-control\" id=\"category\" disabled value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${book.categoryId}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"form-group\">\r\n");
      out.write("                                <label for=\"author\">Author</label>\r\n");
      out.write("                                <input type=\"text\" class=\"form-control\" id=\"author\" disabled value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${book.author}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("                            </div>\r\n");
      out.write("<!--                            <div class=\"form-group\">\r\n");
      out.write("                                <label for=\"edition\">Edition</label>\r\n");
      out.write("                                <input type=\"text\" class=\"form-control\" id=\"edition\" disabled>\r\n");
      out.write("                            </div>-->\r\n");
      out.write("                        </form>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("                <div class=\"row mt-4\">\r\n");
      out.write("                    <div class=\"col-md-12\">\r\n");
      out.write("                        <h3>Borrow Details</h3>\r\n");
      out.write("                        <form action=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/admin/barrowbooks/new\" method=\"post\">\r\n");
      out.write("                            <div class=\"form-row\">\r\n");
      out.write("                                <div class=\"form-group col-md-4\">\r\n");
      out.write("                                    <label for=\"borrowBookId\">Book Id</label>\r\n");
      out.write("                                    <input type=\"text\" class=\"form-control\" id=\"borrowBookId\" name=\"bookId\">\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <div class=\"form-group col-md-4\">\r\n");
      out.write("                                    <label for=\"borrowUserId\">User Id</label>\r\n");
      out.write("                                    <input type=\"text\" class=\"form-control\" id=\"borrowUserId\" name=\"userId\">\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <div class=\"form-group col-md-4\">\r\n");
      out.write("                                    <label for=\"borrowDate\">Borrow Date</label>\r\n");
      out.write("                                    <input type=\"date\" class=\"form-control\" id=\"borrowDate\" name=\"barrowDate\">\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <div class=\"form-group col-md-4\">\r\n");
      out.write("                                    <label for=\"returnDate\">Return Date</label>\r\n");
      out.write("                                    <input type=\"date\" class=\"form-control\" id=\"returnDate\" name=\"returnDate\">\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <button type=\"submit\" class=\"btn btn-success\">Borrow Book</button>\r\n");
      out.write("                        </form>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("            <script src=\"https://code.jquery.com/jquery-3.5.1.slim.min.js\"></script>\r\n");
      out.write("            <script src=\"https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js\"></script>\r\n");
      out.write("            <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js\"></script>\r\n");
      out.write("            <script src=\"https://cdn.jsdelivr.net/npm/sweetalert2@11\"></script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    </body>\r\n");
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
