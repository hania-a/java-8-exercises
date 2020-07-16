package java8exercises.imperative;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FlatCollection {

    private FlatCollection() {
    }

    public static List<String> transform(List<List<String>> collection) {
        return collection.stream()
               .flatMap(item -> item.stream())
               .collect(Collectors.toList());
    }


}
