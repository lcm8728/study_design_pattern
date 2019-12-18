### Template Method
템플릿 메소드는 알고리즘의 캡슐화이다. 
비슷한 단계를 거치는 동작들에 대해서 미리 해당 단계들의 로직을 정해두고, 구체적인 구현은 하위의 구현체에게 위임한다.
템플릿 메서드 또한 다른 패턴들과 마찬가지로 중복을 제거할 수 있다.
 
 ### Example
 윈도우 프로그램은 보통 비슷한 포맷을 지닌다.
 상단 바가 있고, 툴바가 있고, 메인 화면이 있다.
 이렇게 비슷한 구성을 갖는 프로그램에 대해서는 템플릿 메서드를 활용할 수 있다.

1. 상단바를 그린다.
2. 툴바를 그린다.
3. 메인화면을 그린다.
4. 푸터를 그린다. <br>

위 단계를 template method 패턴으로 옮기면 다음과 같은 것이다.
```java
abstract class WindowProgram {

    abstract protected void drawMain();
    abstract protected String getTitle();

    void draw() {
        drawTitle(getTitle());
        drawToolbar();
        drawMain();
        drawFooter();
    }

    private void drawTitle(String title) {
        System.out.println("===============================================");
        System.out.println("ㅁ" + title);
        System.out.println("===============================================");
    }

    private void drawToolbar() {
        System.out.println("File | Edit | View | Navigate");
        System.out.println("===============================================");
    }

    private void drawFooter() {
        System.out.println("===============================================");
    }
}
```
윈도우 프로그램을 상속받는 프로그램들은 위와 같은 동일한 프로세스를 통해 화면에 그려진다.
각 프로그램들은 메인 화면이 어떻게 그려지는지, 프로그램의 이름이 무엇인지 등, 정해진 것만 그리면 된다.
만약 타이틀이나 툴바가 없는 프로그램을 만드려면, drawTitle, drawToolbar를 override 하여 해당 작업을 직접 구현할 수도 있다.
```java
public class Intellij extends WindowProgram {

    @Override
    protected void drawMain() {
        System.out.println("\n\n\nTHIS IS INTELLIJ PROGRAM\n\n\n");
    }

    @Override
    protected String getTitle() {
        return "Intellij";
    }
    
}
```
실제 구체적인 프로그램의 구현은 위와 같이 간단하다. 위 결과는 다음과 같다.
```bash

===============================================
ㅁIntellij
===============================================
File | Edit | View | Navigate
===============================================


THIS IS INTELLIJ PROGRAM


===============================================
```