package src.search;

import src.ApiClient;
import src.ApiResult;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchApiClient implements ApiClient {
    @Override
    public ApiResult execute() {
        List<SearchDocument> documentHashMap = new ArrayList<>();
        documentHashMap.add(
                new SearchDocument("documentA", new ArrayList<>(
                        Arrays.asList(new SearchDocument("subA", new ArrayList<>())))
                )
        );
        documentHashMap.add(
                new SearchDocument("documentB", new ArrayList<>(
                        Arrays.asList(new SearchDocument("subB", new ArrayList<>(
                                Arrays.asList(
                                        new SearchDocument("subBofA", new ArrayList<>()),
                                        new SearchDocument("subBofB", new ArrayList<>()),
                                        new SearchDocument("subBofC", new ArrayList<>()),
                                        new SearchDocument("subBofD", new ArrayList<>())
                                )
                        ))))
                )
        );
        documentHashMap.add(new SearchDocument("documentC", new ArrayList<>()));
        documentHashMap.add(new SearchDocument("documentD", new ArrayList<>()));
        documentHashMap.add(new SearchDocument("documentE", new ArrayList<>()));
        return new SearchApiResult(documentHashMap);
    }
}
