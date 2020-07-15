package java8exercises.imperative;

import java8exercises.Person;
import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static java8exercises.imperative.Kids.getKidNames;
import static org.assertj.core.api.Assertions.assertThat;

public class KidsSpec {

    @Test
    public void getKidNameShouldReturnNamesOfYoungerThan18() {
        Person sara = new Person("Sara", 4);
        Person viktor = new Person("Viktor", 40);
        Person eva = new Person("Eva", 42);
        Person anna = new Person("Anna", 5);
        List<Person> collection = asList(sara, eva, viktor, anna);
        assertThat(getKidNames(collection))
                .contains("Sara", "Anna")
                .doesNotContain("Viktor", "Eva");
    }

}
