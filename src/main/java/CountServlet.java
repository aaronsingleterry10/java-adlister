import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CountServlet", urlPatterns = "/count")
public class CountServlet extends HttpServlet {
    public int counter = 0;
    @Override

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String reset = request.getParameter("reset");

        if (reset.equals("true")) {
            counter = 0;
        } else {
            counter += 1;
        }
        out.println("<h1>Page visit count: " + (counter) + "</h1>");

    }
}
