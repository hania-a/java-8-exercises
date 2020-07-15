package java8exercises.imperative;

import java8exercises.Person;
import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static java8exercises.imperative.Joining.namesToString;
import static org.assertj.core.api.Assertions.assertThat;

public class JoiningSpec {

    @Test
    public void toStringShouldReturnPeopleNamesSeparatedByComma() {
        Person sara = new Person("Sara", 4);
        Person viktor = new Person("Viktor", 40);
        Person eva = new Person("Eva", 42);
        List<Person> collection = asList(sara, viktor, eva);
        assertThat(namesToString(collection))
                .isEqualTo("Names: Sara, Viktor, Eva.");
    }

}
