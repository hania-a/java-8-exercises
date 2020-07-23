package java8exercises.imperative;

import java8exercises.Person;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;
import static java8exercises.imperative.OldestPerson.getOldestPerson;
import static org.assertj.core.api.Assertions.assertThat;

public class OldestPersonSpec {

    @Test
    public void getOldestPersonShouldReturnOldestPerson() {
        Person sara = new Person("Sara", 4);
        Person viktor = new Person("Viktor", 40);
        Person eva = new Person("Eva", 42);
        List<Person> collection = asList(sara, eva, viktor);
        assertThat(OldestPerson.getOldestPerson(collection)).isEqualToComparingFieldByField(eva);
    }

    @Test
    public void getOldestPersonShouldReturnNull() {
        List<Person> collection = new ArrayList<>();
        Person oldestPerson = getOldestPerson(collection);
        assert oldestPerson == null;
    }
}
