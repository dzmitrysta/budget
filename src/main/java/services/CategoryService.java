package services;

import dao.CategoryDao;
import dao.core.DaoException;
import dao.core.GenericDao;
import domain.Category;

import java.util.List;


public class CategoryService {
    private GenericDao<Category,String> cd = new CategoryDao();

    public Category createCategory(String categoryName)throws DaoException {
        Category ctg = new Category();
        ctg.setTitle(categoryName);
        return cd.create(ctg);
    }

    public List<Category> getCategoryList() throws DaoException{
        return cd.getAll();
    }

    public Category getCategory(int id) throws DaoException {
        return cd.readById(id);
    }
    public void deleteCategory (int id) throws DaoException{
        cd.delete(cd.readById(id));
    }

    public void updateCategory(Category ctg) throws DaoException{
        cd.update(ctg);
    }
}
