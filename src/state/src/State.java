package src;

public interface State {
    State nextState();
    void maintainState() throws InterruptedException;
}
