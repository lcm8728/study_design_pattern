package src;

import src.traffic.RedLight;

class TrafficLight {
    private State state;
    private Integer count;

    TrafficLight() {
        state = new RedLight();
        count = 0;
    }

    void doWork() throws InterruptedException {
        while(!stopSign()) {
            state.maintainState();
            state = state.nextState();
            count++;
        }
    }

    private boolean stopSign() {
        return count > 10;
    }
}
