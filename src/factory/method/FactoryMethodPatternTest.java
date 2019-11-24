package factory.method;

public class FactoryMethodPatternTest {
    public static void main(String[] args) {
        AbstractBookStore javaStore = new JavaBookStore();
        AbstractBookStore cookStore = new CookBookStore();

        javaStore.sellBook("hard");
        javaStore.sellBook("soft");
        cookStore.sellBook("hard");
        cookStore.sellBook("soft");
    }
}
