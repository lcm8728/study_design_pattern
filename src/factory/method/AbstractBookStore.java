package factory.method;

import factory.common.Book;

abstract class AbstractBookStore {
    abstract Book createBook(String type);

    private Book packageBook(Book book) {
        System.out.println("packaging book..." );
        System.out.println("done!");
        return book;
    }
}
