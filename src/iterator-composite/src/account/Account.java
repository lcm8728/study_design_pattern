package src.account;

import src.ApiItem;

public class Account extends ApiItem {
    private String name;

    public Account(String name) {
        this.name = name;
    }

    @Override
    protected String name() {
        return name;
    }
}
