package servlets.category;

import dao.core.DaoException;
import domain.Category;
import services.CategoryService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SaveCategoryServlet", urlPatterns = {"/save-category"})
public class SaveCategoryServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(req.getParameter("id"));
            String title = req.getParameter("title");
            CategoryService cs = new CategoryService();
            cs.updateCategory(new Category(id, title));
            resp.sendRedirect("user/user-panel.jsp");

        } catch (DaoException e) {
            e.printStackTrace();
        }
    }
}
