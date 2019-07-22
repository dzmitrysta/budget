package services;

import dao.AccountDao;
import dao.core.DaoException;
import domain.Account;
import domain.AccountType;

import java.util.List;
import java.util.stream.Collectors;

public class AccountService {
    private AccountDao acd = new AccountDao();

    public Account createAccount(int user_id, double balance, String title, AccountType type) throws DaoException {
        Account account = new Account();
        account.setUser_id(user_id);
        account.setBalance(balance);
        account.setTitle(title);
        account.setType(type);

        return acd.create(account);
    }

    public List<Account> getAccounts(int user_id) throws DaoException {
        List<Account> accounts = acd.getAll();
        return accounts.stream().filter(x -> x.getUser_id() == user_id).collect(Collectors.toList());
    }

    public Account getAccount(int id) throws DaoException {
        Account ac = acd.readById(id);
        return ac;
    }


    public void updateAccount(Account account) throws DaoException {
        acd.update(account);
    }
}
