package dao;

import dao.core.AbstractDao;
import dao.core.DaoException;
import domain.User;
import domain.UserType;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class UserDao extends AbstractDao<User, String> {

    @Override
    public String getInsertQuery() {
        return "INSERT INTO `USERS`(`LOGIN`, `PASSWORD`, `EMAIL`, `TYPE`) VALUES(?,?,?,?)";
    }

    @Override
    public String getSelectByIdQuery() {
        return "SELECT * FROM `USERS` WHERE `id` = ? ";
    }

    @Override
    public String getSelectByKeyQuery() {
        return "SELECT * FROM `USERS` WHERE `login` = ? ";
    }

    @Override
    public String getLastIdQuery() {
        return "SELECT * FROM `users` WHERE `id` = last_insert_id()";
    }

    @Override
    public String getDeleteQuery() {
        return "DELETE FROM `USERS`  WHERE `id` = ?";
    }

    @Override
    public String getUpdateQuery() {
        return "UPDATE `USERS` SET `login` = ?, `password`=?, `type` = ?, `email` = ? WHERE `id` = ?";
    }

    @Override
    public String getSelectAllQuery() {
        return "SELECT * FROM `users`";
    }

    @Override
    public void setFieldsForUpdate(PreparedStatement ps, User object) throws DaoException {
        try {
            ps.setString(1, object.getLogin());
            ps.setString(2, object.getPassword());
            ps.setString(3, object.getType().toString());
            ps.setString(4, object.getEmail());
            ps.setInt(5, object.getId());
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
    public void setFieldsForInsert(PreparedStatement ps, User object) throws DaoException {
        try {
            ps.setString(1, object.getLogin());
            ps.setString(2, object.getPassword());
            ps.setString(3, object.getEmail());
            ps.setString(4, object.getType().toString());
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public List<User> parseResultSet(ResultSet rs) throws DaoException {
        List<User> objects = new ArrayList<>();

        try {
            while (rs.next()) {
                User u = new User();
                u.setId(rs.getInt(1));
                u.setLogin(rs.getString(2));
                u.setPassword(rs.getString(3));
                u.setType(UserType.valueOf(rs.getString(4)));
                u.setEmail(rs.getString(5));
                u.setCreated(rs.getTimestamp(6).toLocalDateTime().toLocalDate());

                objects.add(u);
            }
        } catch (SQLException e) {
            throw new DaoException();
        }

        return objects;
    }
}
