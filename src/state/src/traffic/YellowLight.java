package src.traffic;

import src.State;

public class YellowLight implements State {
    @Override
    public State nextState() {
        return new GreenLight();
    }

    @Override
    public void maintainState() throws InterruptedException {
        System.out.println("On Yellow Light");
        Thread.sleep(300);
    }
}
