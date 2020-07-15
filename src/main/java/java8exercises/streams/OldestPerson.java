package java8exercises.streams;

import java.util.Comparator;
import java.util.List;
import java8exercises.Person;

public class OldestPerson {


    public static Person getOldestPerson(List<Person> people) {
        return people.stream() // Convert collection to Stream
                .max(Comparator.comparing(Person::getAge)) // Compares people ages
                .get(); // Gets stream result
    }

}
