
import com.team2.utill.DBConnection;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author kavin
 */
@WebServlet(name = "TestDb", urlPatterns = {"/TestDb"})
public class TestDB extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            Connection connection = DBConnection.getConnection();
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head><title>Database Connection Test</title></head>");
            out.println("<body>");
            out.println("<h1>Database Connection Test</h1>");
            out.println("<p>Connection successful!</p>");
            out.println("</body>");
            out.println("</html>");
        } catch (SQLException e) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head><title>Database Connection Error</title></head>");
            out.println("<body>");
            out.println("<h1>Database Connection Error</h1>");
            out.println("<p>Error: " + e.getMessage() + "</p>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}
