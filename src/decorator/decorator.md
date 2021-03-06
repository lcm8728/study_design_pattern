### Decorator Pattern
데코레이터 패턴에서 중요한 점은 다른 패턴들과 마찬가지로 공통된 부분(decorator)을 재사용 가능하게 한다는 점인 것 같다. 
베이스 컴포넌트가 있고, 그 컴포넌트를 꾸미는 요소들을 재사용하여 더 다양한 형태의 객체를 만들 수 있다.
### 마음에 안드는 점?
사용하는 형태가 생각보다 가독성이 없는 것 같다.  
작성한 예시 코드는 게임 아이템(베이스 컴포넌트)을 다양하게 강화(데코레이터)하는 것을 간단하게 표현한 것이다.  
```java
Weapon myAxe = new Axe();
myAxe = new FireEnchant(myAxe); // (1)
myAxe = new IceEnchant(myAxe);
```
(1)에 해당하는 부분이 어색한 느낌이다. 위 예에서 도끼를 강화한다고 하면,
```java
myAxe.fireEnchant(); // (2)
혹은
Enchanter.fireEnchant(myAxe);
```
와 같은 형태가 더 어울리지 않을까싶다. 구현을 하기 나름이겠지만, 
교재의 구현방법을 따르지만 위와 같이 된다.  
또한 (2)번 형태로 굳이 Enchant 클래스를 나누지 않고 최상위 interface에서 함수의 형태로 decorator(라고 생각되는)를 구현한다고 하더라도 크게 문제가 생길 것 같지는 않다.
정답은 없겠지만, 이 패턴은 불필요한 클래스를 생산하는 느낌이 강한 것 같다. 