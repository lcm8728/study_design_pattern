package facade;

import java.util.ArrayList;
import java.util.List;

interface SuggestService {
    List<String> suggest(Photo photo);
}

class SuggestServiceImpl implements SuggestService {
    @Override
    public List<String> suggest(Photo photo) {
        List<String> suggests = new ArrayList<>();

        suggests.add(photo.getContent().toLowerCase());
        suggests.add(photo.getContent().toUpperCase());

        System.out.println("suggested tags --------------- " );
        suggests.forEach(tag -> System.out.println("TAG: " + tag));

        return suggests;
    }
}
