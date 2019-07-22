package dao;


import dao.core.AbstractDao;
import dao.core.DaoException;
import dao.core.GenericDao;
import domain.Category;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDao extends AbstractDao<Category, String> {
    @Override
    public String getInsertQuery() {
        return "INSERT INTO `CATEGORIES`(`title`) VALUES(?)";
    }

    @Override
    public String getSelectByIdQuery() {
        return "SELECT * FROM `categories` WHERE `id` = ? ";
    }

    @Override
    public String getSelectByKeyQuery() {
        return "SELECT * FROM `categories` WHERE `title` = ? ";
    }

    @Override
    public String getLastIdQuery() {
        return "SELECT * FROM `categories` WHERE `id` = last_insert_id()";
    }

    @Override
    public String getDeleteQuery() {
        return "DELETE FROM `categories`  WHERE `id` = ?";
    }

    @Override
    public String getUpdateQuery() {
        return "UPDATE `categories` SET `title` = ? WHERE `id` = ? ";
    }

    @Override
    public String getSelectAllQuery() {
        return "SELECT * FROM `categories`";
    }

    @Override
    public void setFieldsForUpdate(PreparedStatement ps, Category object) throws DaoException {
        try {
            ps.setString(1, object.getTitle());
            ps.setInt(2, object.getId());
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public void setFieldsForByKeySelect(PreparedStatement ps, String key) throws DaoException {
        try {
            ps.setString(1, key);
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public void setFieldsForInsert(PreparedStatement ps, Category object) throws DaoException {
        try {
            ps.setString(1, object.getTitle());
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public List<Category> parseResultSet(ResultSet rs) throws DaoException {
        List<Category> objects = new ArrayList<>();

        try {
            while (rs.next()) {
                Category ctg = new Category();
                ctg.setId(rs.getInt(1));
                ctg.setTitle(rs.getString(2));
                ctg.setCreated(rs.getTimestamp(3).toLocalDateTime());

                objects.add(ctg);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new DaoException();
        }

        return objects;
    }
}
