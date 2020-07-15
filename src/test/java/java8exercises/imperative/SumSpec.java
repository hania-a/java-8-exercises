package java8exercises.imperative;

import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static java8exercises.imperative.Sum.calculate;
import static org.assertj.core.api.Assertions.assertThat;

/*
Sum all elements of a collection
 */
public class SumSpec {

    @Test
    public void calculateShouldReturnSumOfAllIntegersInCollection() {
        List<Integer> numbers = asList(1, 2, 3, 4, 5);
        assertThat(calculate(numbers)).isEqualTo(1 + 2 + 3 + 4 + 5);
    }

}
