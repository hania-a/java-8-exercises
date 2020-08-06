package java8exercises.imperative;

import java.util.List;
import java.util.stream.Collectors;

public class ToUpperCase {

    private ToUpperCase() {
    }

    public static List<String> transform(List<String> collection) {

        return collection.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
    }


}
