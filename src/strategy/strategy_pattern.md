### Strategy Pattern
변경될 수 있는 부분은 분리하여 위임한다.  
예제에서는 StringPrinter가 출력한 포맷에 대한 내용을 StringFormatter에게 위임하고 있다.
```java
class StringPrinter {
    private StringFormatter formatter; // 포맷에 관한 내용은 모두 formatter가 처리

    StringPrinter(StringFormatter formatter) {
        this.formatter = formatter;
    }

    void print(String str) {
        System.out.println(formatter.format(str));
    }
}
```  
StringPrinter는 어떤 포맷을 사용하여 프린트를 하는지 직접 관여하지 않는다.  
StringPrint는 가지고 있는 formatter에 의해 포맷된 문자열을 출력해줄 뿐이다.  
따라서 출력되는 포맷을 변경하고 싶을 땐 다른 Formatter를 주입하여 새로운 프린터를 생성하거나 setter를 두어 formatter를 바꾸면 된다.  
Printer는 출력을 하는 역할만 하고, Formatter는 포맷을 하는 역할만 한다.  
 
