package src.search;

import src.ApiItem;

import java.util.List;

public class SearchDocument extends ApiItem {
    private String documentId;
    private List<SearchDocument> subDocuments;

    SearchDocument(String docId, List<SearchDocument> subDocuments) {
        documentId = docId;
        this.subDocuments = subDocuments;
    }

    public List<SearchDocument> getSubDocuments() {
        return subDocuments;
    }

    @Override
    protected String name() {
        return documentId;
    }
}
