package factory.interfaces;

public class FactoryInterfacePatternTest {
    public static void main(String[] args) {
        BookStore javaBookStore = new BookStore(new JavaBookFactory());
        BookStore cookBookStore = new BookStore(new CookBookFactory());

        javaBookStore.sellBook("hard");
        javaBookStore.sellBook("soft");
        cookBookStore.sellBook("hard");
        cookBookStore.sellBook("soft");

    }
}
