package java8exercises.streams;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;
import java8exercises.Person;

public class Grouping {

    private Grouping() {
    }


    public static Map<String, List<Person>> groupByNationality(List<Person> people) {
        return people.stream() // Convert collection to Stream
                .collect(groupingBy(Person::getNationality)); // Group people by nationality
    }

}
