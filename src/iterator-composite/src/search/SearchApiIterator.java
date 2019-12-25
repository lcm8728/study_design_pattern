package src.search;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SearchApiIterator implements Iterator {
    private List<SearchDocument> documents;
    private Iterator documentIterator;

    SearchApiIterator(List<SearchDocument> documentList) {
        List<SearchDocument> documents = new ArrayList<>();
        addToList(documents, documentList);
        this.documents = documents;
        documentIterator = this.documents.iterator();
    }

    private void addToList(List<SearchDocument> list, List<SearchDocument> documents) {
        Iterator iterator = documents.iterator();
        while (iterator.hasNext()) {
            SearchDocument item = (SearchDocument) iterator.next();
            list.add(item);
            System.out.println(item.name());
            addToList(list, item.getSubDocuments());
        }
    }

    @Override
    public boolean hasNext() {
        return documentIterator.hasNext();
    }

    @Override
    public Object next() {
        return documentIterator.next();
    }
}
