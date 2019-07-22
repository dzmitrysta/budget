package dao.core;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractDao<P extends Identefire, K> implements GenericDao<P, K> {
    private DaoUtils utils = new DaoUtils();

    public abstract String getInsertQuery();

    public abstract String getSelectByIdQuery();

    public abstract String getSelectByKeyQuery();

    public abstract String getLastIdQuery();

    public abstract String getDeleteQuery();

    public abstract String getUpdateQuery();

    public abstract String getSelectAllQuery();

    public abstract void setFieldsForUpdate(PreparedStatement ps, P object) throws DaoException;

    public abstract void setFieldsForByKeySelect(PreparedStatement ps, K key) throws DaoException;

    public abstract void setFieldsForInsert(PreparedStatement ps, P someObject) throws DaoException;

    public abstract List<P> parseResultSet(ResultSet rs) throws DaoException;

    @Override
    public P create(P someObject) throws DaoException {
        String query = getInsertQuery();
        String idQuery = getLastIdQuery();

        Connection conn = utils.getConnection();

        try (PreparedStatement ps = conn.prepareStatement(query)) {

            setFieldsForInsert(ps, someObject);
            ps.executeUpdate();

            try (PreparedStatement psn = conn.prepareStatement(idQuery)) {
                ResultSet rs = psn.executeQuery();
                List<P> list = parseResultSet(rs);
                if (list == null || list.size() != 1) {
                    throw new DaoException();
                } else {
                    someObject = list.get(0);
                }
            } catch (SQLException e) {
                throw new DaoException(e);
            }

        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return someObject;
    }

    @Override
    public P readById(int id) throws DaoException {
        P someObject;
        String idQuery = getSelectByIdQuery();
        Connection conn = utils.getConnection();

        try (PreparedStatement ps = conn.prepareStatement(idQuery)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            List<P> list = parseResultSet(rs);
            if (list == null || list.size() != 1) {
                throw new DaoException();
            } else {
                someObject = list.get(0);
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return someObject;
    }

    @Override
    public P readByKey(K key) throws DaoException {
        P someObject;
        String keyQuery = getSelectByKeyQuery();
        Connection conn = utils.getConnection();

        try (PreparedStatement ps = conn.prepareStatement(keyQuery)) {
            setFieldsForByKeySelect(ps, key);
            ResultSet rs = ps.executeQuery();
            List<P> list = parseResultSet(rs);
            if (list == null || list.size() != 1) {
                someObject = null;
            } else {
                someObject = list.get(0);
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return someObject;
    }

    @Override
    public void update(P object) throws DaoException {
        String query = getUpdateQuery();
        Connection conn = utils.getConnection();
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            setFieldsForUpdate(ps, object);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void delete(P object) throws DaoException {

        String query = getDeleteQuery();

        Connection conn = utils.getConnection();
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, object.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<P> getAll() throws DaoException {
        List<P> someList = new ArrayList<>();
        String query = getSelectAllQuery();
        try (PreparedStatement statement = utils.getConnection().prepareStatement(query)) {
            ResultSet rs = statement.executeQuery();
            someList = parseResultSet(rs);

        } catch (Exception e) {
            throw new DaoException();
        }

        return someList;
    }
}
