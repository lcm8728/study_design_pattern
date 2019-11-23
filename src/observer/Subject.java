package observer;

interface Subject<T> {
    void registerObserver(Observer<T> o);
    void deleteObserver(Observer<T> o);
    void notifyObserver(T msg);
}