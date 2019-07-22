package services;

import dao.TransactionDao;
import dao.core.DaoException;
import dao.core.GenericDao;
import domain.Transaction;
import domain.TransactionType;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class TransactionService {
    private GenericDao<Transaction, String> trdao = new TransactionDao();

    public List<Transaction> getTransactions(int user_id) throws DaoException {
        List<Transaction> transactions = trdao.getAll();
        transactions = transactions.stream().filter(x -> x.getUserId() == user_id).collect(Collectors.toList());
        return transactions;
    }

    public void createTransaction(int id, String type, int acc_id, int cat_id, String desc, double amount) throws DaoException{
        Transaction tr = new Transaction();
        tr.setUserId(id);
        tr.setType(TransactionType.valueOf(type));
        tr.setAccountId(acc_id);
        tr.setCategoryId(cat_id);
        tr.setDescription(desc);
        tr.setAmount(amount);
        tr.setDate(LocalDateTime.now());

        trdao.create(tr);
    }
}
