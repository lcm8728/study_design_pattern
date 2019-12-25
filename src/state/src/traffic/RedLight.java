package src.traffic;

import src.State;

public class RedLight implements State {
    @Override
    public State nextState() {
        return new YellowLight();
    }

    @Override
    public void maintainState() throws InterruptedException {
        System.out.println("On Red Light");
        Thread.sleep(2000);
    }
}
