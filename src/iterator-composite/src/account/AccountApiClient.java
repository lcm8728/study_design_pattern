package src.account;

import src.ApiClient;
import src.ApiResult;

import java.util.ArrayList;

public class AccountApiClient implements ApiClient {

    @Override
    public ApiResult execute() {
        ArrayList<Account> accounts = new ArrayList<>();
        accounts.add(new Account("foo"));
        accounts.add(new Account("bar"));
        accounts.add(new Account("baz"));
        accounts.add(new Account("etc"));
        return new AccountApiResult(accounts);
    }
}
