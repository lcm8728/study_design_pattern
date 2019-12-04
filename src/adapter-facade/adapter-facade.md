### Adapter Pattern
어댑터 패턴은 한 인터페이스의 사용을 돕는 또 다른 인터페이스를 두는 패턴을 말한다.
A라는 인터페이스를 이용하는 객체가 B라는 인터페이스를 이용할 수 있게 하는 것이다.
```java
class SwordAdapter implements Gun {
    private Sword sword;

    SwordAdapter(Sword sword) {
        this.sword = sword;
    }

    @Override
    public void shoot() {
        sword.cut();
    }
}


public class GunnerTest {
    public static void main(String[] args) {
        Sword sword = new LongSword();
        Gunner gunner = new Gunner(new SwordAdapter(sword));

        gunner.shoot();
    }
}
```
위와 같이 Gun을 상속받는 Adapter가 있다면, Gun만을 사용할 수 있는 Gunner도 Sword를 사용할 수 있다.<br>
이 패턴의 장점은 새로 개발을 시작할 경우가 아닌, 기존의 사용중인 코드를 재사용할 수 있도록 한다는 점에 있는 것 같다.
기존의 많은 코드에서 어떤 인터페이스를 사용하고 있고, 그것을 걷어내기에 무리가 있다면, Adapter를 만들어 새로운 인터페이스로 사용할 수 있다.
이와 같은 작업은 기존 서비스 되고 있는 부분에 대한 안정성을 보장할 뿐더러, 새로운 코드를 만들 때의 확장성 까지 보장해준다.

### Facade Pattern
파사드 패턴은 여러 인터페이스를 통합하는 또 다른 인터페이스를 두는 것을 의미한다.
이러한 통합된 인터페이스가 있는 것은 사용자로 하여금 좀 더 편리하게 이용할 수 있도록 돕는다.
```java
public class InstagramApplication {
    private CameraService cameraService;
    private SuggestService suggestService;
    private TransferService transferService;

    public InstagramApplication(CameraService cameraService, SuggestService suggestService, TransferService transferService) {
        this.cameraService = cameraService;
        this.suggestService = suggestService;
        this.transferService = transferService;
    }

    public void post(String type) {
        Photo photo = cameraService.takePicture(type);
        suggestService.suggest(photo);
        transferService.transfer(photo);
        System.out.println();
    }
}
```
파사드 패턴은 우리가 흔히 보는 어플리케이션에서의 구조와 비슷한 것 같다.
많은 서비스들이 존재하고, 어플리케이션 레벨에서는 해당 서비스들을 조합하여 기능을 구현한다.
이러한 구현들은 사실 우리가 패턴으로 인식하고 있지 못하더라도 많은 부분에서 사용중인 것 같다.<br>

이렇게 여러 서비스들을 통합하여 구현하는 것이 좋은 이유도 어댑터 패턴에서와 마찬가지 이유라고 생각이 된다.
서비스들은 각자의 기능만을 한다. 그것을 조합하여 새로운 기능을 만들어 낼 수 있다.
따라서 서비스들의 조합으로 전혀 다른 새로운 기능이 생길 수도 있다. 이는 마찬가지로 코드의 재사용성을 높이는 일이며,
개발자가 개발을 할 때 좀 더 쉽게 새로운 구현을 가능하도록 돕는다.