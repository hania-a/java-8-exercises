package java8exercises.imperative;

import java.util.List;
import java8exercises.Person;

public class OldestPerson {

    public static Person getOldestPerson(List<Person> people) {
        Person oldestPerson = new Person("", 0);
        for (Person person : people) {
            if (person.getAge() > oldestPerson.getAge()) {
                oldestPerson = person;
            }
        }
        return oldestPerson;
    }


}
