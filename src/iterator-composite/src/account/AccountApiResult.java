package src.account;

import src.ApiResult;

import java.util.ArrayList;
import java.util.Iterator;

public class AccountApiResult implements ApiResult {
    private ArrayList<Account> accounts;

    public AccountApiResult(ArrayList<Account> accounts) {
        this.accounts = accounts;
    }

    @Override
    public Iterator<Account> createIterator() {
        return accounts.iterator();
    }

}


