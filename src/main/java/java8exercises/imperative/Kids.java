package java8exercises.imperative;

import java8exercises.Person;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Kids {

    public static Set<String> getKidNames(List<Person> people) {
        return people.stream()
                .filter(person -> person.getAge() < 18)
                .map(Person::getName)
                .collect(Collectors.toSet());
    }

}
