package java8exercises.imperative;

import java8exercises.Person;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Kids {

    public static Set<String> getKidNames(List<Person> people) {
        Set<String> kids = new HashSet<>();
        for (Person person : people) {
            if (person.getAge() < 18) {
                kids.add(person.getName());
            }
        }
        return kids;
    }



}
