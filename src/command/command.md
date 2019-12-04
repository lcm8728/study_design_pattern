### commands.Command Pattern
커맨드 패턴은 메소드(동작)의 캡슐레이션이다.
클라이언트에서는 동작의 상세에 대해서는 알지 못한다.
그저 commands.Command interface를 구현한 구현체들에 대해서만 알고 있을 뿐이다.
이렇게 메서드를 캡슐화 함으로써 클라이언트가 상세한 동작에 대해 의존성을 갖지 않을 수 있다.

### 예시
```java
public class Client {
    private List<AbstractCommand> commands;

    public Client(List<AbstractCommand> commands) {
        this.commands = commands;
    }

    void doCommand(String[] types) {
        commands.stream()
                .filter(command ->
                        Arrays.stream(types).anyMatch(type -> command.getType().equals(type)))
                .forEach(Command::execute);
    }
}
``` 
컨텐츠를 카톡, 라인, sms로 공유하는 기능을 가진 client 객체이다. 이 클라이언트가 하는 일은 커맨드를 주입받고, 주입받은 커맨드의 타입이 명령으로 주어졌을 시, 해당 작업을 수행하는 일이 전부이다.
위와 같이 캡슐화를 하여 따로 관리하면, 의존성이 줄어들어 관리 및 개발이 용이해진다.<br>

```java
public abstract class AbstractCommand implements Command {
    private String type;

    AbstractCommand(String type) {
        this.type = type;
    }

    abstract void process();

    public String getType() {
        return type;
    }

    public void execute() {
        before();
        process();
        after();
    }

    private void before() {
        System.out.println("Preparing to share to " + type);
    }

    private void after() {
        System.out.println("Done with " + type);
    }
}
```
또한 위와 같이 공통된 선작업/후작업은 동일하게 처리하여 관리의 효율을 높일 수 있다.