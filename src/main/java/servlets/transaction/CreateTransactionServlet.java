package servlets.transaction;

import dao.core.DaoException;
import domain.AccountType;
import domain.User;
import services.AccountService;
import services.TransactionService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "CreateTransactionServlet", urlPatterns = {"/create-trans"})
public class CreateTransactionServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            HttpSession session = req.getSession();
            User user = (User) session.getAttribute("user");

            String type = req.getParameter("type");
            int acc_id = Integer.parseInt(req.getParameter("account"));
            int cat_id = Integer.parseInt(req.getParameter("category"));
            String desc = req.getParameter("desc");
            double amount = Double.parseDouble(req.getParameter("amount"));

            TransactionService service = new TransactionService();
            service.createTransaction(user.getId(), type, acc_id, cat_id, desc, amount);

            resp.sendRedirect("../user/user-panel.jsp");
        } catch (DaoException e) {
            System.out.println(e.getMessage());
        }
    }
}
