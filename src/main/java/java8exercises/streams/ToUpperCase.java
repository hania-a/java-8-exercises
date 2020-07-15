package java8exercises.streams;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class ToUpperCase {

    private ToUpperCase() {
    }

    public static List<String> transform(List<String> collection) {
        return collection.stream() // Convert collection to Stream
                .map(String::toUpperCase) // Convert each element to upper case
                .collect(toList()); // Collect results to a new list
    }

}
