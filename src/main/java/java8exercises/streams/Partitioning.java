package java8exercises.streams;

import java.util.List;
import java.util.Map;
import java8exercises.Person;

import static java.util.stream.Collectors.partitioningBy;

public class Partitioning {

    private Partitioning() {
    }


    public static Map<Boolean, List<Person>> partitionAdults(List<Person> people) {
        return people.stream() // Convert collection to Stream
                .collect(partitioningBy(p -> p.getAge() >= 18)); // Partition stream of people into adults (age => 18) and kids
    }

}
