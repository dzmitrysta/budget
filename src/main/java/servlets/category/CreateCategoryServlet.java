package servlets.category;

import dao.core.DaoException;
import services.CategoryService;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CreateCategoryServlet", urlPatterns = {"/create-category"})
public class CreateCategoryServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String name = req.getParameter("title");

            CategoryService cs = new CategoryService();
            cs.createCategory(name);

                resp.sendRedirect("user/user-panel.jsp");

        } catch (DaoException e) {
            e.printStackTrace();
        }
    }
}