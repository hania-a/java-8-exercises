package java8exercises.imperative;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import java8exercises.Person;

public class Partitioning {

    private Partitioning() {
    }

    public static Map<Boolean, List<Person>> partitionAdults(List<Person> people) {
        Map<Boolean, List<Person>> adultsVsKids = people.stream()
                .collect(Collectors.groupingBy(person -> person.getAge() >= 18));
        return adultsVsKids;
    }

    public static Map<String, List<Person>> partitionNames(List<Person> people) {
        Map<String, List<Person>> names = people.stream()
                .collect(Collectors.groupingBy(person -> person.getName()));
        return names;
    }

}
