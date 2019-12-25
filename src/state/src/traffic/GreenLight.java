package src.traffic;

import src.State;

public class GreenLight implements State {
    @Override
    public State nextState() {
        return new RedLight();
    }

    @Override
    public void maintainState() throws InterruptedException {
        System.out.println("On Green Light");
        Thread.sleep(2000);
    }
}
