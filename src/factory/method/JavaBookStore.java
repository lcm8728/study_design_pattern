package factory.method;

import factory.common.Book;
import factory.common.HardCoverJavaBook;
import factory.common.SoftCoverJavaBook;

class JavaBookStore extends AbstractBookStore {
    @Override
    Book createBook(String type) {
        Book book;

        if(type.equals("hard")) {
            book = new HardCoverJavaBook();
        } else {
            book = new SoftCoverJavaBook();
        }

        return book;
    }
}
