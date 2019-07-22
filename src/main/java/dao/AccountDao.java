package dao;

import dao.core.AbstractDao;
import dao.core.DaoException;
import domain.Account;
import domain.AccountType;

import java.sql.PreparedStatement;
import java.sql.ResultSet;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccountDao extends AbstractDao<Account, String> {

    @Override
    public String getInsertQuery() {
        return "INSERT INTO `ACCOUNTS`(`number`, `user_id`, `balance`, `title`, `type`) VALUES(?,?,?,?,?)";
    }

    @Override
    public String getSelectByIdQuery() {
        return "SELECT * FROM `accounts` WHERE `id` = ? ";
    }

    @Override
    public String getSelectByKeyQuery() {
        return "SELECT * FROM `accounts` WHERE `number` = ? ";
    }

    @Override
    public String getLastIdQuery() {
        return "SELECT * FROM `accounts` WHERE `id` = last_insert_id()";
    }

    @Override
    public String getDeleteQuery() {
        return "DELETE FROM `accounts`  WHERE `id` = ?";
    }

    @Override
    public String getUpdateQuery() {
        return "UPDATE `accounts` SET `number` = ?, `user_id`=?, `balance` = ? , `title` = ?,  `type` = ? WHERE `id` = ? ";
    }

    @Override
    public String getSelectAllQuery() {
        return "SELECT * FROM `accounts`";
    }

    @Override
    public void setFieldsForUpdate(PreparedStatement ps, Account object) throws DaoException {
        try {
            ps.setString(1, object.getNumber());
            ps.setInt(2, object.getUser_id());
            ps.setDouble(3, object.getBalance());
            ps.setString(4, object.getTitle());
            ps.setString(5, object.getType().toString());
            ps.setInt(6, object.getId());
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
    public void setFieldsForInsert(PreparedStatement ps, Account object) throws DaoException {
        try {
            ps.setString(1, object.getNumber());
            ps.setInt(2, object.getUser_id());
            ps.setDouble(3, object.getBalance());
            ps.setString(4, object.getTitle());
            ps.setString(5, object.getType().toString());
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public List<Account> parseResultSet(ResultSet rs) throws DaoException {
        List<Account> objects = new ArrayList<>();

        try {
            while (rs.next()) {
                Account acc = new Account();
                acc.setId(rs.getInt(1));
                acc.setNumber(rs.getString(2));
                acc.setUser_id(rs.getInt(3));
                acc.setBalance(rs.getDouble(4));
                acc.setTitle(rs.getString(5));
                acc.setType(AccountType.valueOf(rs.getString(6)));
                acc.setCreated(rs.getTimestamp(7).toLocalDateTime());

                objects.add(acc);
            }
        } catch (SQLException e) {
            throw new DaoException();
        }

        return objects;
    }
}

