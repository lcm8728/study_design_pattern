package observer;

import java.util.ArrayList;

class Company implements Subject<String> {
    private ArrayList<Observer<String>> observers = new ArrayList<>();

    @Override
    public void registerObserver(Observer<String> o) {
        observers.add(o);
    }

    @Override
    public void deleteObserver(Observer<String> o) {
        observers.remove(o);
    }

    @Override
    public void notifyObserver(String msg) {
        observers.forEach(observer -> observer.update(msg));
        System.out.println();
    }
}