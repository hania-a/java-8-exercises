package java8exercises.streams;

import java.util.List;

import static java.util.stream.Collectors.joining;
import java8exercises.Person;

public class Joining {

    private Joining() {
    }



    public static String namesToString(List<Person> people) {
        return people.stream() // Convert collection to Stream
                .map(Person::getName) // Map Person to name
                .collect(joining(", ", "Names: ", ".")); // Join names
    }

}
