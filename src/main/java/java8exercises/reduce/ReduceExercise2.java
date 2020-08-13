package java8exercises.reduce;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
/**
 * URL for the exercise
 * http://www.java-programming.info/tutorial/pdf/java/exercises/exercises-streams-2.pdf
*/

public class ReduceExercise2 {
    public static void main(String[] args) {
        method1();

        method2();

        method3();

        method4();

        method5();
    }

    /**
     * Produce a single String that is the result of concatenating the uppercase versions of all of the
     * Strings. E.g., the result should be "HIHELLO...". Use a single reduce operation, without using map.
     * */
    private static void method1() {
        List<String> words = Arrays.asList("hi", "hello", "asad", "kaustubh", "danish", "B2", "ms");
        Optional<String> outputVal;

        outputVal = words.stream()
                .reduce((a, b) -> a.concat(b).toUpperCase());
        System.out.println(outputVal.get());
    }

    /**
     * Produce the same String as above, but this time via a map operation that turns the words into upper
     * case, followed by a reduce operation that concatenates them.
     */
    private static void method2() {
        List<String> words = Arrays.asList("hi", "hello", "asad", "kaustubh", "danish", "B2", "ms");

        Optional<String> reduce = words.stream()
                .map(String::toUpperCase)
                .reduce(String::concat);

        System.out.println("Method2: " + reduce.get());
    }

    /**
     * Produce a String that is all the words concatenated together, but with commas in between. E.g., the
     * result should be "hi,hello,...". Note that there is no comma at the beginning, before "hi", and also no
     * comma at the end, after the last word. Major hint: there are two versions of reduce discussed in the
     * notes.
     */
    private static void method3() {
        List<String> words = Arrays.asList("hi", "hello", "asad", "kaustubh", "danish", "B2", "ms");

        String reduce = words.stream()
                .reduce((intermediate, word) -> String.join(",", intermediate, word)).get();

        System.out.println(reduce);
    }

    /**
     * Find the total number of characters (i.e., sum of the lengths) of the strings in the List.
     */
    private static void method4() {
        List<String> words = Arrays.asList("hi", "hello", "");

        Optional<Integer> totalCharCount = words.stream()
                .map(String::length)
                .reduce((charCount, wordLength) -> charCount += wordLength);

        System.out.println("Total number of characters: " + totalCharCount.get());
    }

    /**
     * Find the number of words that contain an 'h' .
     */
    public static void method5() {
        List<String> words = Arrays.asList("hi", "hello", "Hasad", "kaustubh", "danish", "B2", "ms");
        long number = words.stream()
                .filter(word -> word.contains("h"))
                .count();
        System.out.println("Total number of words that contain 'h': " + number);
    }

    /**
     * Find the number of words that contain an 'h' using reduce().
     */

}
