package java8exercises.imperative;

import java.util.List;

public class Sum {

    private Sum() {
    }

    public static int calculate(List<Integer> numbers) {
        int total = 0;
        for (int number : numbers) {
            total += number;
        }
        return total;
    }


}
