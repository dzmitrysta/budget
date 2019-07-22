package servlets.accounts;

import dao.core.DaoException;
import domain.Account;
import domain.AccountType;
import domain.User;
import services.AccountService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "CreateAccountServlet", urlPatterns = {"/open-acc"})
public class CreateAccountServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            HttpSession session = req.getSession();
            User user = (User) session.getAttribute("user");

            String type = req.getParameter("type");
            String title = req.getParameter("title");
            double balance = Double.parseDouble(req.getParameter("balance"));

            AccountService service = new AccountService();
            service.createAccount(user.getId(), balance, title, AccountType.valueOf(type));

            resp.sendRedirect("../user/user-panel.jsp");
        } catch (DaoException e) {
            System.out.println(e.getMessage());
        }
    }
}
