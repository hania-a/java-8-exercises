package parallelstreams;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

/**
 * URL for the exercise
 * http://www.java-programming.info/tutorial/pdf/java/exercises/exercises-streams-3.pdf
 */
public class ParallelStreamExercises {

    static double[] veryLargeArray = new Random().doubles(100000000).toArray();

    public static void main(String[] args) {

        method1();

        method3();

        method6();

        method6b();

        method6c();
    }

    /**
     * Compute the sum of the square roots of the numbers in the array.
     * Find a shorter and simpler way than making a loop to tally the sum. Hint: review the notes on number-specialized
     * streams, espe-cially the fact that you make a DoubleStream from a double[] with DoubleStream.of, not Stream.of.
     */
    private static void method1() {

        long start = System.currentTimeMillis();

        double sumOfSquareRoots = DoubleStream.of(veryLargeArray)
                .reduce(0.0, (sumOfSquares, number) -> sumOfSquares += Math.sqrt(number));

        System.out.println(sumOfSquareRoots);

        System.out.println("Time taken: " + (System.currentTimeMillis() - start)/1000);
    }

    /**
     * Repeat the process in parallel. Once you have #2 working, this should be very simple.
     */
    static void method3(){

        long start = System.currentTimeMillis();

        double sumOfSquareRoots = Arrays.stream(veryLargeArray)
                .parallel()
                .boxed()
                .reduce(0.0, (sumOfSquares, number) -> sumOfSquares += Math.sqrt(number), Double::sum);

        System.out.println(sumOfSquareRoots);

        System.out.println("Time taken: " + (System.currentTimeMillis() - start)/1000);
    }

    public static void method6()
    {
        Stream<Double> doubleList = Stream.generate(() -> new Random().nextDouble() * 10);

        doubleList.limit(5)
                .forEach(System.out::println);

    }

    public static void method6b()
    {
        Stream<Double> doubleList = Stream.generate(() -> new BigDecimal(new Random().nextDouble() * 10)
                                                                            .setScale(2, RoundingMode.HALF_EVEN)
                                                                            .doubleValue());
        List<Double> doublesList = doubleList.limit(10)
                .collect(Collectors.toList());
        System.out.println(doublesList);

    }

    /**
     * Make an "infinite" stream that generates random doubles between 0 and 10. Use it to
     * Make an array of 20 random doubles
     */
    static void method6c() {
        Double[] array = Stream.generate(() -> new Random().nextDouble() * 10)
                .limit(20)
                .collect(Collectors.toList())
                .toArray(new Double[20]);

        for (Double d : array)
            System.out.println(d);

    }
}
