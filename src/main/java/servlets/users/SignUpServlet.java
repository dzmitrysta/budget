package servlets.users;

import dao.core.DaoException;
import domain.User;
import services.UserService;
import domain.utils.UserDataValidator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "signUpServlet", urlPatterns = {"/signup"})
public class SignUpServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        String email = req.getParameter("email");
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String conf_password = req.getParameter("conf_password");


        UserDataValidator udv = new UserDataValidator();
        String validationResult = udv.validate(login, email, password, conf_password);

        if (validationResult.equals("OK")) {
            try {
                UserService ups = new UserService();
                User user = ups.signUp(login, password, conf_password, email, "GUEST");
                if (user != null) {
                    HttpSession session = req.getSession(true);
                    session.setMaxInactiveInterval(60 * 60 * 24 * 3);
                    session.setAttribute("user", user);
                    req.getRequestDispatcher("user/homepage.jsp").forward(req, resp);
                }
            } catch (DaoException e) {
                e.printStackTrace();
            }
        } else {
            out.println("<div class=\"alert alert-danger alert-dismissible fade show\" role=\"alert\">\n" +
                    "    <strong>" + validationResult + "</strong> \n" +
                    "    <button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\">\n" +
                    "        <span aria-hidden=\"true\">&times;</span>\n" +
                    "    </button>\n" +
                    "</div>");
            req.getRequestDispatcher("user/signup.jsp").include(req, resp);
        }


    }
}
