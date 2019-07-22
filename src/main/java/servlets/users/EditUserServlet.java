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
import java.io.IOException;

@WebServlet(name = "EditUserServlet", urlPatterns = {"/editu"})
public class EditUserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            int id = Integer.valueOf(req.getParameter("uid"));
            UserService us = new UserService();
            User someUser = us.getUserById(id);

            req.setAttribute("current-user", someUser);
            RequestDispatcher rd = req.getRequestDispatcher("administration/user-edit.jsp");
            rd.forward(req, resp);
        } catch (DaoException e) {
            System.out.println(e.getMessage());
        }

    }
}
