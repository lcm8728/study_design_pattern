package factory.interfaces;

import factory.common.Book;

class BookStore {
    private BookFactory factory;

    BookStore(BookFactory factory) {
        this.factory = factory;
    }

    public Book sellBook(String type) {
        Book book = factory.createBook(type);
        return packageBook(book);
    }

    private Book packageBook(Book book) {
        System.out.println("packaging book..." );
        System.out.println("done!");
        return book;
    }
}
