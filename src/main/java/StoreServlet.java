import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "StoreServlet", urlPatterns = "/store")
public class StoreServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            req.setAttribute("items", DaoFactory.getItemsDao().listAll());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        req.getRequestDispatcher("/WEB-INF/store/store.jsp").forward(req, resp);
    }
}
