package java8exercises.imperative;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import java8exercises.Person;
import java8exercises.Stats;

public class PeopleStats {

    private PeopleStats() {
    }

    public static Stats getStats(List<Person> people) {

        // count
        long count = people.stream().count();
        long count2 = people.stream().collect(Collectors.counting());

        // sum age
        Integer sum = people.stream()
                .collect(Collectors.summingInt(person -> person.getAge()));


        // max age
        Integer max = people.stream()
                .map(person -> person.getAge())
                .max(Comparator.comparing(Function.identity()))
                .get();

        // min age
        Integer min = people.stream()
                .map(person -> person.getAge())
                .min(Comparator.comparing(Function.identity()))
                .get();

        return new Stats(count2, sum, min, max);
    }

}
