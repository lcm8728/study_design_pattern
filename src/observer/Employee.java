package observer;

class Employee implements Observer<String> {

    private String name;

    Employee(String name) {
        this.name = name;
    }

    @Override
    public void update(String msg) {
        System.out.println(name + " received message : " + msg);
    }
}

