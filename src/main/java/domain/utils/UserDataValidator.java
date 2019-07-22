package domain.utils;

import dao.core.DaoException;
import domain.User;
import services.UserService;

import java.io.Serializable;

public class UserDataValidator implements Serializable {

    public String validate(String login, String email, String password, String confpassword) {
        String result = "OK";
        if (!loginValidate(login)) {
            return "Login : " + login + " is already used!!!";
        } else if (!emailValidate(email)) {
            return "Wrong email address!!";
        } else if (!password.equals(confpassword)) {
            return "password doesnt match!!!";
        }
        return result;
    }

    private boolean loginValidate(String login) {
        try {
            UserService us = new UserService();
            User u = us.getUserByLogin(login);
            if (u == null) {
                return true;
            }
        } catch (DaoException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    private boolean emailValidate(String email) {
        return email.matches("(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])");
    }

}


