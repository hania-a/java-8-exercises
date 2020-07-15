package java8exercises.streams;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class FilterCollection {

    private FilterCollection() {
    }


    public static List<String> transform(List<String> collection) {
        return collection.stream() // Convert collection to Stream
                .filter(value -> value.length() < 4) // Filter elements with length smaller than 4 characters
                .collect(toList()); // Collect results to a new list
    }

}
