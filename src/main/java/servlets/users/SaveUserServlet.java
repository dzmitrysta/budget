package servlets.users;

import dao.core.DaoException;
import domain.User;
import services.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SaveUserServlet", urlPatterns = {"/save-user"})
public class SaveUserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String id = req.getParameter("id");
            String email = req.getParameter("email");
            String login = req.getParameter("login");
            String password = req.getParameter("password");
            String type = req.getParameter("type");

            User user = new User(Integer.valueOf(id), login, password, email,type);

            UserService ups = new UserService();

            ups.updateUser(user);

            resp.sendRedirect("administration/admin-panel.jsp");

        } catch (DaoException e) {
            e.printStackTrace();
        }
    }
}
