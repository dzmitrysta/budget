package dao.core;

import java.util.List;

public interface GenericDao<P, K> {
    P create(P someObject) throws DaoException;

    P readById(int id) throws DaoException;

    P readByKey(K key) throws DaoException;

    void update(P object) throws DaoException;

    void delete(P object) throws DaoException;

    List<P> getAll() throws DaoException;


}
