package src;

import java.util.Iterator;

public class Client {
    ApiResult accountResult;
    ApiResult searchResult;

    public Client(ApiClient accountClient, ApiClient searchClient) {
        this.accountResult = accountClient.execute();
        this. searchResult = searchClient.execute();
    }

    void printResult(ApiResult apiResult) {
        Iterator iterator = apiResult.createIterator();

        while(iterator.hasNext()) {
            ApiItem item = (ApiItem) iterator.next();
            System.out.println("API ITEM: " + item.name());
        }
        System.out.println("END OF ITEM");
    }

}
