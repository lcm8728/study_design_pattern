### Observer Pattern
상태의 변화를 감지하여 어떠한 동작을 하는 Observer와 상태의 변화를 일으키는 Subject로 구성된 패턴이다.
Subject는 변화가 생겼을 때, 등록되어있는 Observer의 특정 메서드를 호출하여 Observer들이 상태의 변화가 일어났다는 것을 알 수 있게 해준다.
### 장점
Interface로 Subject와 Observer를 분리하여, 재사용성이 가능하다. 둘 사이에는 데이터가 오고갈 뿐, 서로가 서로에 대해서 알아야 하는 부분은 존재하지 않는다.
### 주의할 점
Subject가 Observer에게 통지할 때, 또 다른 통지를 야기할 상태 변화를 가져오고, 그 상황이 반복된다면 무한히 통지만 하는 상황이 발생할 수 있다.
이와 같은  순환 실행이 발생하지 않도록 주의가 필요하다.
### 예제 설명
Company 클래스는 등록된 Employee에게 메세지를 준다. 메세지가 통지되면, 각 Employee들은 해당 message를 출력하는 간단한 예제이다.  
foo, bar, baz라는 employee가 하나씩 등록되고, 그 사이사이에 메세지가 통지되므로, 통지되어 출력되는 문자열이 하나씩 늘어난다.  
최종 결과는 다음과 같다.  
```
// foo 등록
foo received message : check your payment

// bar 등록
foo received message : today no work
bar received message : today no work

// baz 등록
foo received message : no pay for this month
bar received message : no pay for this month
baz received message : no pay for this month

// baz 제거
foo received message : we fired baz
bar received message : we fired baz
```