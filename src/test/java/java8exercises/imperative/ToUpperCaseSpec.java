package java8exercises.imperative;

import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static java8exercises.imperative.ToUpperCase.transform;
import static org.assertj.core.api.Assertions.assertThat;

public class ToUpperCaseSpec {

    @Test
    public void transformShouldConvertCollectionElementsToUpperCase() {
        List<String> collection = asList("My", "name", "is", "John", "Doe", "1", "Hi Hello WoRlD");
        List<String> expected = asList("MY", "NAME", "IS", "JOHN", "DOE", "1", "HI HELLO WORLD");
        assertThat(transform(collection)).hasSameElementsAs(expected);
    }

}
