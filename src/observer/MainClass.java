package observer;

public class MainClass {
    public static void main(String[] arg) {
        Company kakao = new Company();
        Employee foo = new Employee("foo");
        Employee bar = new Employee("bar");
        Employee baz = new Employee("baz");

        kakao.registerObserver(foo);
        kakao.notifyObserver("check your payment");

        kakao.registerObserver(bar);
        kakao.notifyObserver("today no work");

        kakao.registerObserver(baz);
        kakao.notifyObserver("no pay for this month");

        kakao.deleteObserver(baz);
        kakao.notifyObserver("we fired baz");
    }
}