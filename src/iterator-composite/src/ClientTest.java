package src;

import src.account.AccountApiClient;
import src.search.SearchApiClient;

public class ClientTest {
    public static void main(String[] args) {
        Client client = new Client(new AccountApiClient(), new SearchApiClient());
        client.printResult(client.accountResult);
        client.printResult(client.searchResult);
    }
}
