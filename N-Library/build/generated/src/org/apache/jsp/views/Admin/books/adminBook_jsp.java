package org.apache.jsp.views.Admin.books;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.team2.controller.utill.assetsUrl;

public final class adminBook_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/views/Admin/admincommon/sidebar.jspf");
  }

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_forEach_var_items;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_forEach_var_items = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_forEach_var_items.release();
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
      out.write("     <style>\r\n");
      out.write("        .shift-left {\r\n");
      out.write("            margin-left: 0;\r\n");
      out.write("            padding-left: 0;\r\n");
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
      out.write("          \r\n");
      out.write("        </div>\r\n");
      out.write("         <div class=\"content container-fluid shift-left\">\r\n");
      out.write("            <a href=\"adminAddBook\" class=\"btn btn-success my-3\">Add New Book</a>\r\n");
      out.write("            <table class=\"table table-hover\">\r\n");
      out.write("                <thead class=\"thead-light\">\r\n");
      out.write("                    <tr>\r\n");
      out.write("                        <th>Image</th>\r\n");
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
      out.write("                    ");
      if (_jspx_meth_c_forEach_0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("                </tbody>\r\n");
      out.write("            </table>\r\n");
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

  private boolean _jspx_meth_c_forEach_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_0.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_0.setParent(null);
    _jspx_th_c_forEach_0.setVar("book");
    _jspx_th_c_forEach_0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${book}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int[] _jspx_push_body_count_c_forEach_0 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_0 = _jspx_th_c_forEach_0.doStartTag();
      if (_jspx_eval_c_forEach_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("                    <tr>\r\n");
          out.write("                        <td><img src=\"book image/");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${book.bookId}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\" width=\"16px\" height=\"16px\"></td>\r\n");
          out.write("                        <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${book.bookId}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\r\n");
          out.write("                        <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${book.title}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\r\n");
          out.write("                        <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${book.categoryId}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\r\n");
          out.write("                        <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${book.quantity}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\r\n");
          out.write("                        <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${book.author}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\r\n");
          out.write("                        <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${book.available}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\r\n");
          out.write("                        <td>\r\n");
          out.write("                            <a href=\"adminEditBook.jsp?bookId=");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${book.bookId}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\" class=\"btn btn-outline-secondary btn-sm\">Edit</a>\r\n");
          out.write("                            <a href=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("/admin/books/delete?bookId=");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${book.bookId}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\" class=\"btn btn-outline-danger btn-sm\">Delete</a>\r\n");
          out.write("                        </td>\r\n");
          out.write("                    </tr>\r\n");
          out.write("                    ");
          int evalDoAfterBody = _jspx_th_c_forEach_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_0.doFinally();
      _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_0);
    }
    return false;
  }
}
