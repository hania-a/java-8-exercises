package java8exercises.streams;

import java8exercises.Person;

import java.util.IntSummaryStatistics;
import java.util.List;

public class PeopleStats {

    private PeopleStats() {
    }

    public static IntSummaryStatistics getStats(List<Person> people) {
        return people.stream()
                .mapToInt(Person::getAge)
                .summaryStatistics();
    }

}
