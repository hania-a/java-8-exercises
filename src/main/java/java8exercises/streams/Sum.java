package java8exercises.streams;

import java.util.List;

public class Sum {

    private Sum() {
    }

    public static int calculate(List<Integer> people) {
        return people.stream() // Convert collection to Stream
                .reduce(0, (total, number) -> total + number); // Sum elements with 0 as starting value
    }

}
