package services;

import dao.UserDao;
import dao.core.DaoException;
import domain.User;
import domain.UserType;

import java.util.List;

public class UserService {
    private UserDao upd = new UserDao();

    public User signUp(String login, String password, String confirmPassword, String email, String type) throws DaoException {
        User user = new User();

        user.setLogin(login);
        user.setPassword(password);
        user.setEmail(email);
        user.setType(UserType.valueOf(type));
        user = upd.create(user);

        if (user != null && user.getId() != 0) {
            if (user.getLogin().equals(login)) {
                return user;
            }
        }

        return null;
    }

    public User signIn(String login, String password) throws DaoException {
        User user = upd.readByKey(login);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        } else return null;
    }

    public User getUserById(int id) throws DaoException {
        return upd.readById(id);
    }

    public User getUserByLogin(String login) throws DaoException {
        return upd.readByKey(login);
    }

    public List<User> getAllUsers() throws DaoException {
        return upd.getAll();
    }

    public void updateUser(User user) throws DaoException {
        upd.update(user);
    }
}
