package domain;

import dao.core.Identefire;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class User implements Identefire {
    private int id;
    private String login;
    private String password;
    private String email;
    private LocalDate created;
    private UserType type;

    public User() {
    }

    public User(String login, String password, String email, UserType type) {
        this.id = -1;
        this.login = login;
        this.password = password;
        this.email = email;
        this.created = LocalDate.now();
        this.type = type;
    }

    public User(int id, String login, String password, String email, String type) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.email = email;
        this.type = UserType.valueOf(type);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getCreated() {
        return created;
    }

    public void setCreated(LocalDate created) {
        this.created = created;
    }


    public UserType getType() {
        return type;
    }

    public void setType(UserType type) {
        this.type = type;
    }

}
