### State Pattern
스테이트 패턴은 어떤 객체에 대해 상태를 부여하고, 해당되는 상태에 해당되는 동작을 수행할 수 있도록 구성된 디자인을 의미한다.
각 상태들은 State라는 인터페이스를 공유하고, 상태를 보유하는 객체는 State 인터페이스에 선언되어있는 동작을 수행한다.
동일한 동작에 대하여 다른 객체를 사용하던 Strategy 패턴과 유사한 면이 있다.
```java
class TrafficLight {
    private State state;
    private Integer count;

    TrafficLight() {
        state = new RedLight();
        count = 0;
    }

    void doWork() {
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
```
신호등의 로직을 구현한 클래스이다.
신호등 자체는 빨간불, 노란불, 초록불에 대한 상세를 알지 못한다.
빨간불 다음에 노란불이 들어오고, 노란불 다음에 초록불이, 초록불 다음에는 다시 빨간불이 들어와야 로직은
클래스 상에 드러나있지 않다. 그저 하나의 State가 수행되고, 그 State가 nextState를 뱉으면, 해당 State를 유지하는 로직 뿐이다.
```java
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
```
각 신호들은 자신 다음에 어떤 신호가 와야하는지, 얼마나 신호를 지속할 것인지에 대한 내용만을 담고 있다.
<br>
위와 같이 상태를 나누지 않고 TrafficLight가 모든 로직을 들고 있다면, (그럴리는 없지만) 다른 신호가 추가 되었을 때,
혹은 상태를 유지하는 것 말고도 다른 동작을 해야할 때, 코드의 수정 및 가독성이 상당히 떨어질 것이다.