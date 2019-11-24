package factory.method;

import factory.common.Book;

abstract class AbstractBookStore {
    abstract Book createBook(String type);

    Book sellBook(String type) {
        Book book = createBook(type);
        Book packaged = packageBook(book);
        System.out.println("book sold");
        return packaged;
    }

    private Book packageBook(Book book) {
        System.out.println("packaging book..." );
        System.out.println("done!");
        return book;
    }
}
