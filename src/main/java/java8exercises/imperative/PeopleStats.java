package java8exercises.imperative;

import java.util.List;
import java8exercises.Person;
import java8exercises.Stats;

public class PeopleStats {

    private PeopleStats() {
    }

    public static Stats getStats(List<Person> people) {
        long sum = 0;
        int min = people.get(0).getAge();
        int max = 0;
        for (Person person : people) {
            int age = person.getAge();
            sum += age;
            min = Math.min(min, age);
            max = Math.max(max, age);
        }
        return new Stats(people.size(), sum, min, max);
    }

}
