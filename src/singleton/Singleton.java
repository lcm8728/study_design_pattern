class Singleton {
    private static volatile Singleton instance;

    int id = 0;

    private Singleton() {
        id++;
    }

    static Singleton getInstance() {
        if(instance == null) {
            synchronized (Singleton.class) {
                if(instance == null) {
                    instance = new Singleton();
                }
            }
        }

        return instance;
    }
}

class SingletonTest {
    public static void main(String[] arg) {
        // THIS IS NOT ALLOWED
        // Singleton notAllowed = new Singleton();

        // THIS IS ALLOWED
        Singleton allowed = Singleton.getInstance();
        Singleton allowed2 = Singleton.getInstance();
        Singleton allowed3 = Singleton.getInstance();
        Singleton allowed4 = Singleton.getInstance();

        // PRINT ALWAYS SAME ID
        System.out.println(allowed.id);
        System.out.println(allowed2.id);
        System.out.println(allowed3.id);
        System.out.println(allowed4.id);

    }
}
