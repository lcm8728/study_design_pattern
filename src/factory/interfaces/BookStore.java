package factory.interfaces;

import factory.common.Book;

class BookStore {
    private BookFactory factory;

    BookStore(BookFactory factory) {
        this.factory = factory;
    }

    public Book sellBook(String type) {
        Book book = factory.createBook(type);
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
