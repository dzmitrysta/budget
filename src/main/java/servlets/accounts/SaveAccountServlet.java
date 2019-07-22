package servlets.accounts;

import dao.core.DaoException;
import domain.Account;
import domain.AccountType;
import domain.Category;
import services.AccountService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SaveAccountServlet", urlPatterns = {"/save-account"})
public class SaveAccountServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(req.getParameter("id"));
            String number = req.getParameter("number");
            int uid = Integer.parseInt(req.getParameter("uid"));
            double balance = Double.parseDouble(req.getParameter("balance"));
            String title = req.getParameter("title");
            AccountType type = AccountType.valueOf(req.getParameter("type"));

            AccountService acs = new AccountService();
            acs.updateAccount(new Account(id, uid, number, balance, type, title));
            resp.sendRedirect("user/user-panel.jsp");

        } catch (DaoException e) {
            e.printStackTrace();
        }
    }
}
