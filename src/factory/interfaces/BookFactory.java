package factory.interfaces;

import factory.common.Book;

interface BookFactory {
    Book createBook(String type);
}
