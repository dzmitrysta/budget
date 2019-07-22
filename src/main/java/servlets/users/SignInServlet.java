package servlets.users;

import dao.core.DaoException;
import domain.User;
import services.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "signInServlet", urlPatterns = {"/signin"})
public class SignInServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            String login = req.getParameter("login");
            String password = req.getParameter("password");


            UserService ups = new UserService();
            User user = ups.signIn(login, password);

            if (user != null) {
                HttpSession session = req.getSession(true);
                session.setMaxInactiveInterval(60 * 60 * 24 * 3);
                session.setAttribute("user", user);
                req.getRequestDispatcher("user/homepage.jsp").forward(req, resp);

            } else {
                PrintWriter out = resp.getWriter();
                resp.setContentType("text/html");
                out.println("<div class=\"alert alert-danger alert-dismissible fade show\" role=\"alert\">\n" +
                        "    <strong>Wrong login or password!</strong> \n" +
                        "    <button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\">\n" +
                        "        <span aria-hidden=\"true\">&times;</span>\n" +
                        "    </button>\n" +
                        "</div>");
                req.getRequestDispatcher("user/signin.jsp").include(req, resp);
            }
        } catch (DaoException e) {
            System.out.println(e.getMessage());
        }

    }
}
