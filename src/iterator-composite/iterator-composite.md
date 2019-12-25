### Iterator Pattern
Iterator 패턴은 컬렉션의 구현 방법에 대해 노출시키지 않고 해당 컬렉션의 항목에 접근할 수 있도록 하는 패턴이다.
컬렉션의 사용자는 그 컬렉션이 어떻게 구현되어 있는지를 알 필요가 없다.
그저 그 컬렉션 안에 항목들이 존재하고, 그 항목들을 사용할 수만 있으면 된다.<br>
예를 들어, 클라이언트에서 다양한 종류의 API를 사용해여 데이터를 가져와야 한다고 가정하자.
만약 클라이언트가 모든 API의 리턴 방식에 대해 모두 알고 있어야 한다면,
사용하는 API가 늘어날수록, 클라이언트의 코드는 선형적으로 증가할 것이다.<br>
이를 방지하고자 모든 API의 리턴 타입을 추상화하고, API의 결과를 사용할 수 있는 방식만을 제공하는 것이 Iterator 패턴이 될 것이다.
```java
public class Client {
    ApiResult accountResult;
    ApiResult searchResult;

    public Client(ApiClient accountClient, ApiClient searchClient) {
        this.accountResult = accountClient.execute();
        this. searchResult = searchClient.execute();
    }

    void printResult(ApiResult apiResult) {
        Iterator iterator = apiResult.createIterator();

        while(iterator.hasNext()) {
            ApiItem item = (ApiItem) iterator.next();
            System.out.println("API ITEM: " + item.name());
        }
        System.out.println("END OF ITEM");
    }

}
```
클라이언트에서는  api 결과들이 어떻게 저장되어있고, 어떻게 꺼내어 써야하는지 알 필요가 없다.
그저 iterator를 받아서 해당 iterator를 통해서 항목들을 가져오고, 그 항목들을 출력하기만 한다.
이렇게 iterator라는 interface를 사용하여 값들을 꺼내올 수 있다면, Client 입장에서는 호출하는 API가 증가한다고 해도 코드 상의 큰 변화는 없을 것이다.
```java
import java.util.Iterator;

public interface ApiResult {
    Iterator createIterator();
}
```
또한 ApiResult 인터페이스도 상당히 간단하다. 어떤 API의 결과를 받는데는 아무런 제약이 없다.
단순히 그 값을 어떻게 꺼내어 사용할 수만 있는지를 나타내는 Iterator만 반환해주면 된다.
이렇게 되었을 때, Client와 ApiResult 사이의 의존 관계는 상당히 낮아지게 되고, 코드의 유연성을 증가시킨다.

### Composite Pattern
Composite 패턴은 흔히 자료구조를 공부하면서 보았던 트리 구조를 말한다.
그 의미를 보자면 꼭 트리 구조는 아닐 수도 있지만, 트리 구조가 가장 잘 어울릴 듯 하다.
Composite이라는 의미에서 알 수 있듯, 단순한 객체가 아닌 복합 객체를 의미한다.
예를 들어, 검색의 결과로 반환되는 문서에서는 다른 문서를 참조하고 있을 수도 있다.
A라는 문서가 a라는 또 다른 문서를  sub-document로 가질 수 있다는 의미이다.
이러한 것을 표현하기 위해서는 흔히 알고 있는 트리 구조로 표현하는 것이 가장 이상적이며, 
위 Iterator Pattern과 더불어 해당 복합 객체를 탐색할 수도 있게 한다.
```java
package src.search;

import src.ApiItem;

import java.util.List;

public class SearchDocument extends ApiItem {
    private String documentId;
    private List<SearchDocument> subDocuments;

    SearchDocument(String docId, List<SearchDocument> subDocuments) {
        documentId = docId;
        this.subDocuments = subDocuments;
    }

    public List<SearchDocument> getSubDocuments() {
        return subDocuments;
    }

    @Override
    protected String name() {
        return documentId;
    }
}
```
가장 간단하게 트리 구조를 만들 수 있는 방법은 노드 아래에 다른 노드들을 직접 들고 있는 것이다.
위에 보이는 SearchDocument 객체는 그 하위 객체라고 할 수 있는 subDocuments를 갖는다.
이렇게 여러 개의 객체로 구성된 하나의 SearchApiResult는 복합 객체라고 부를 수 있다.
```java
package src.search;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SearchApiIterator implements Iterator {
    private List<SearchDocument> documents;
    private Iterator documentIterator;

    SearchApiIterator(List<SearchDocument> documentList) {
        List<SearchDocument> documents = new ArrayList<>();
        addToList(documents, documentList);
        this.documents = documents;
        documentIterator = this.documents.iterator();
    }

    private void addToList(List<SearchDocument> list, List<SearchDocument> documents) {
        Iterator iterator = documents.iterator();
        while (iterator.hasNext()) {
            SearchDocument item = (SearchDocument) iterator.next();
            list.add(item);
            System.out.println(item.name());
            addToList(list, item.getSubDocuments());
        }
    }

    @Override
    public boolean hasNext() {
        return documentIterator.hasNext();
    }

    @Override
    public Object next() {
        return documentIterator.next();
    }
}
```
이제 SearchApiResult라는 복합 객체를 어떻게 탐색할 것인가 하는 문제에 봉착했다.
위 예제에서는 가장 간단한 방법으로 이를 처리했다. 
가장 상위에 있는 노드과 그 하위의 노드들을 재귀적인 방식으로 하나의 리스트로 묶은 다음, 해당 리스트의 iterator를 반환하는 방법을 사용했다.
이러한 방식으로 복합 객체인 SearchApiResult를 탐색할 수 있게 되었다.
```java
public class ClientTest {
    public static void main(String[] args) {
        Client client = new Client(new AccountApiClient(), new SearchApiClient());
        client.printResult(client.accountResult);
        client.printResult(client.searchResult);
    }
}
```
테스트 코드는 다음과 같이 간단하다. 클라이언트는 각 API 클라이언트로부터 결과를 얻고,
해당 결과를 프린트한다. 결과는 다음과 같다.
```bash
API ITEM: foo
API ITEM: bar
API ITEM: baz
API ITEM: etc
END OF ITEM
documentA
subA
documentB
subB
subBofA
subBofB
subBofC
subBofD
documentC
documentD
documentE
API ITEM: documentA
API ITEM: subA
API ITEM: documentB
API ITEM: subB
API ITEM: subBofA
API ITEM: subBofB
API ITEM: subBofC
API ITEM: subBofD
API ITEM: documentC
API ITEM: documentD
API ITEM: documentE
END OF ITEM
```
앞서 구현한 SearchApiIterator에서 본 것처럼 문서의 하위 문서 또한 잘 탐색되는 것을 알 수 있다.