package servlets.accounts;

import dao.core.DaoException;
import domain.Account;
import domain.Category;
import services.AccountService;
import services.CategoryService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "EditAccountServlet", urlPatterns = {"/edit-acc"})
public class EditAccountServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int id = Integer.valueOf(req.getParameter("id"));
            AccountService acs = new AccountService();
            req.setAttribute("current-account", acs.getAccount(id));
            req.getRequestDispatcher("account/account-edit.jsp").forward(req, resp);
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }
}
