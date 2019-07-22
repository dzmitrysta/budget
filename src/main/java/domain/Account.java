package domain;

import dao.core.Identefire;

import java.time.LocalDateTime;
import java.util.Random;

public class Account implements Identefire {
    private int id;
    private String number;
    private int user_id;
    private double balance;
    private LocalDateTime created;
    private String title;
    private AccountType type;


    public Account() {
        number = generateNumber();
        created = LocalDateTime.now();
    }

    private String generateNumber() {
        StringBuilder number = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 16; i++) {
            char symbol = (char) (random.nextInt(10) + 48);
            number.append(symbol);

        }
        return number.toString();
    }

    public Account(int id, int uid, String number, double balance, AccountType type, String title) {
        this.id = id;
        this.user_id = uid;
        this.number = number;
        this.balance = balance;
        this.type = type;
        this.title = title;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public AccountType getType() {
        return type;
    }

    public void setType(AccountType type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", user_id=" + user_id +
                ", balance=" + balance +
                ", created=" + created +
                ", title='" + title + '\'' +
                ", type=" + type +
                '}';
    }
}
