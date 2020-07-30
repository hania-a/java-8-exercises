package java8exercises.imperative;

import java.util.List;

public class Sum {

    private Sum() {
    }

    public static int calculate(List<Integer> numbers) {
       return numbers.stream().mapToInt(num -> num).sum();
    }
}
