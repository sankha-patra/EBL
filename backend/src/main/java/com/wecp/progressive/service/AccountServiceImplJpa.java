package com.wecp.progressive.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wecp.progressive.entity.Accounts;
import com.wecp.progressive.repository.AccountRepository;

import net.bytebuddy.dynamic.loading.ClassInjector.UsingUnsafe.Factory.AccessResolver;

@Service
public class AccountServiceImplJpa implements AccountService {

    @Autowired
    AccountRepository accountRepository;
    

    public AccountServiceImplJpa(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    private static List<Accounts> acc = new ArrayList<>();

    @Override
    public List<Accounts> getAllAccounts() throws SQLException {
        return accountRepository.findAll();
    }

    @Override
    public List<Accounts> getAccountsByUser(int userId) throws SQLException {
        return accountRepository.findByCustomerId(userId);
    }

    @Override
    public Accounts getAccountById(int accountId) throws SQLException {
        return accountRepository.findById(accountId).get();
    }

    @Override
    public int addAccount(Accounts accounts) throws SQLException {
        return accountRepository.save(accounts).getAccountId();
    }

    @Override
    public void updateAccount(Accounts accounts) throws SQLException {
        accountRepository.findById(accounts.getAccountId()).map(account -> {
            account.setCustomerId(accounts.getCustomerId());
            account.setBalance(accounts.getBalance());
            return accountRepository.save(account);
        });
    }

    @Override
    public void deleteAccount(int accountId) throws SQLException {
        accountRepository.deleteById(accountId);
    }

    @Override
    public List<Accounts> getAllAccountsSortedByBalance() throws SQLException {
        return accountRepository.findByOrderByBalance();
    }

    @Override
    public List<Accounts> getAllAccountsFromArrayList() {
        return acc;
    }

    @Override
    public List<Accounts> addAccountToArrayList(Accounts accounts) {
        acc.add(accounts);
        return acc;
    }

    @Override
    public List<Accounts> getAllAccountsSortedByBalanceFromArrayList() {
        List<Accounts> sortedAccounts = acc;
        Collections.sort(sortedAccounts);
        return sortedAccounts;
    }

    @Override
    public void emptyArrayList() {
        acc = new ArrayList<>();
    }

}