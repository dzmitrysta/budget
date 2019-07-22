package services;

import dao.core.DaoException;
import domain.Category;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class CategoryServiceTest {

    @Test
    public void getCategoryList() {
        try {
            CategoryService cs = new CategoryService();
            List<Category> listC = cs.getCategoryList();
            System.out.println(listC);
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }
}