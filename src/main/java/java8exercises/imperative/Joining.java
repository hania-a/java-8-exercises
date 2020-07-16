package java8exercises.imperative;

import java8exercises.Person;

import java.util.List;
import java.util.stream.Collectors;

public class Joining {

    private Joining() {
    }

    public static String namesToString(List<Person> people) {
        return people.stream()
                .map(person -> person.getName()) // convert person to names
                .collect(Collectors.joining(", ", "Names: ", "."));

    }


}
