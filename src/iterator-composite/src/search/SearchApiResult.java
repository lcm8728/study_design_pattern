package src.search;

import src.ApiResult;

import java.util.Iterator;
import java.util.List;

public class SearchApiResult implements ApiResult {
    private List<SearchDocument> documents;

    public SearchApiResult(List<SearchDocument> documents) {
        this.documents = documents;
    }

    @Override
    public Iterator createIterator() {
        return new SearchApiIterator(documents);
    }
}
