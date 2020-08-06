package java8exercises.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ReduceExercise1 {

    /**
     * Produce a single String that is the result of concatenating the uppercase versions of all of the
     * Strings. E.g., the result should be "HIHELLO...". Use a single reduce operation, without using map.
     * */

    public static void main(String[] args) {
        List<String> words = Arrays.asList("hi", "hello", "asad", "kaustubh", "danish", "B2", "ms");
        Optional<String> outputVal;

        outputVal = words.stream()
                .reduce((a, b) -> a.concat(b).toUpperCase());
        System.out.println(outputVal);
    }
}
