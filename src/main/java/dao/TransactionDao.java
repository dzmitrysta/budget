package dao;

import dao.core.AbstractDao;
import dao.core.DaoException;
import domain.Transaction;
import domain.TransactionType;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TransactionDao extends AbstractDao<Transaction, String> {
    @Override
    public String getInsertQuery() {
        return "INSERT INTO `transactions`(`user_id`, `account_id`, `category_id`, `amount`, `description`, `type`) VALUES(?,?,?,?,?,?)";
    }

    @Override
    public String getSelectByIdQuery() {
        return "SELECT * FROM `transactions` WHERE `id` = ? ";
    }

    @Override
    public String getSelectByKeyQuery() {
        return "SELECT * FROM `transactions` WHERE `type` = ? ";
    }

    @Override
    public String getLastIdQuery() {
        return "SELECT * FROM `transactions` WHERE `id` = last_insert_id()";
    }

    @Override
    public String getDeleteQuery() {
        return "DELETE FROM `transactions`  WHERE `id` = ?";
    }

    @Override
    public String getUpdateQuery() {
        return "UPDATE `transactions` SET `account_id` = ?, `category_id`=?, `amount` = ? , `description` = ?,  `type` = ? WHERE `id` = ? ";
    }

    @Override
    public String getSelectAllQuery() {
        return "SELECT * FROM `transactions`";
    }

    @Override
    public void setFieldsForUpdate(PreparedStatement ps, Transaction object) throws DaoException {
        try {
            ps.setInt(1, object.getAccountId());
            ps.setInt(2, object.getCategoryId());
            ps.setDouble(3, object.getAmount());
            ps.setString(4, object.getDescription());
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
    public void setFieldsForInsert(PreparedStatement ps, Transaction object) throws DaoException {
        try {
            ps.setInt(1, object.getUserId());
            ps.setInt(2, object.getAccountId());
            ps.setInt(3, object.getCategoryId());
            ps.setDouble(4, object.getAmount());
            ps.setString(5, object.getDescription());
            ps.setString(6, object.getType().toString());
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public List<Transaction> parseResultSet(ResultSet rs) throws DaoException {
        List<Transaction> objects = new ArrayList<>();

        try {
            while (rs.next()) {
                Transaction transaction = new Transaction();
                transaction.setId(rs.getInt(1));
                transaction.setAccountId(rs.getInt(2));
                transaction.setCategoryId(rs.getInt(3));
                transaction.setUserId(rs.getInt(4));
                transaction.setAmount(rs.getDouble(5));
                transaction.setDescription(rs.getString(6));
                transaction.setType(TransactionType.valueOf(rs.getString(7)));
                transaction.setDate(rs.getTimestamp(8).toLocalDateTime());
                objects.add(transaction);
            }
        } catch (SQLException e) {
            throw new DaoException();
        }

        return objects;
    }


}
