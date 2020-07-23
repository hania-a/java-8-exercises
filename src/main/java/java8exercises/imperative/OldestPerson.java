package java8exercises.imperative;

import java.util.Comparator;
import java.util.List;
import java.util.function.Supplier;

import java8exercises.Person;

public class OldestPerson {

    public static Person getOldestPerson(List<Person> people) {
        return people.stream()
                .max(Comparator.comparingInt(person -> person.getAge()))
                .orElseGet(() -> null);
    }
}
