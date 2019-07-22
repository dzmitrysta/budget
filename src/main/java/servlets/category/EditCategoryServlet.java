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

@WebServlet(name = "EditCategoryServlet", urlPatterns = {"/edit-category"})
public class EditCategoryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int id = Integer.valueOf(req.getParameter("id"));
            CategoryService cs = new CategoryService();
            Category ctg = cs.getCategory(id);

            req.setAttribute("current-category", ctg);
            req.getRequestDispatcher("category/category-edit.jsp").forward(req, resp);
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }
}
