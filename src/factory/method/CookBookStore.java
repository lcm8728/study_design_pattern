package factory.method;

import factory.common.Book;
import factory.common.HardCoverCookBook;
import factory.common.SoftCoverCookBook;

class CookBookStore extends AbstractBookStore {
    @Override
    Book createBook(String type) {
        Book book;

        if(type.equals("hard")) {
            book = new HardCoverCookBook();
        } else {
            book = new SoftCoverCookBook();
        }

        return book;
    }
}
