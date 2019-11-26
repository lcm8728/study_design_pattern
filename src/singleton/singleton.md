### Singleton
개발을 하다보면 객체가 한 개만 있어도 되는 경우, 더 나아가 오로지 한 개만 있어야 하는 경우가 있다.
이럴 때 사용하는 패턴이 Singleton 패턴이다. 이름에서 알 수 있듯, Singleton 패턴은 단 하나의 객체만 생성할 수 있으며,
또 다른 객체의 생성을 막는다. 코틀린, 스칼라 등 higher level 언어는 자체적으로 싱글턴 클래스를 만들 수 있도록 지원한다.
```kotlin
// 코틀린에서는 object로 선언된 클래스는 단 하나의 객체를 갖는다.
object Singleton { 
    fun thisIsSingleton() {
        println("This is singleton")
    }
}
```

### Singleton in Java
자바에서는 언어 자체적으로 싱글턴을 지원하지 않기에 개발자가 직접 구현해야 한다.
가장 고전적인 방법으로는
```java
public class Singleton {
    private static Singleton uniqueInstance;
    
    private Singleton() {}
    
    public static Singleton getInstance() {
        if(uniqueInstance == null) {
            uniqueInstacne = new Singleton();
        }
        
        return uniqueInstance;
    }
}
```
와 같이 생성자를 private으로 설정하여, 외부에서 해당 클래스의 객체를 만들지 못하게 하는 방법이 있다.
하지만 위와 같은 방법은 multi-threaded 시스템에서 문제가 될 여지가 있다.
uniqueInstance가 새로 생성되기 전, 두 개 이상의 thread가 getInstance 메서드를 동시에 호출한다고 가정해보자.
이럴 때, uniqueInstance를 보는 두 개 이상의 thread는 모두 uniqueInstance가 null인 것으로 보일 것이므로 두 개 이상의 객체가 생성되는 셈이다.<br>
해결책은 1. getInstance 메서드를 synchronize로 선언하거나 2. 인스턴스를 처음부터 만들거나 3. double-checking locking을 통해 하는 방법 등이 있다.