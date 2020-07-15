package java8exercises.streams;

import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.toSet;
import java8exercises.Person;

public class Kids {



    public static Set<String> getKidNames(List<Person> people) {
        return people.stream()
                .filter(person -> person.getAge() < 18) // Filter kids (under age of 18)
                .map(Person::getName) // Map Person elements to names
                .collect(toSet()); // Collect values to a Set
    }

}
