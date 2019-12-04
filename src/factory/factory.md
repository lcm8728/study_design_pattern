## Factory Pattern
팩토리 패턴은 구체 클래스의 생성에 대한 패턴이다.
구체 클래스들의 생성 로직을 클라이언트로부터 분리시키면, 클라이언트는 로직의 변화에 영향을 받지 않게 된다.
### Simple Factory Pattern
클라이언트에서 생성 로직만을 분리시킨 형태의 패턴이다. 
가장 간단한 형태이다. 패턴이 아닌 관용적인 표현으로 생각하는 경우도 있다. 
### Factory Method Pattern
어떤 구체 클래스를 생성할 것인지를 abstract class의 subclass가 정하게 하는 방식이다. 
상위 abstract class에서는 abstract method를 선언하고, subclass는 해당 method를 구현한다.
### Abstract Factory Pattern
인터페이스를 지정하여 구체 클래스를 지정하지 않고 생성 가능하도록 한다.
즉, 구체 클래스를 생성하여 제공하는 인터페이스를 두고, 그 인터페이스를 구현한 구현체의 메서드를 사용하면 직접 구체 클래스를 생성하지 않아도 된다.
