package parallelstreams;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

/**
 * URL for the exercise
 * http://www.java-programming.info/tutorial/pdf/java/exercises/exercises-streams-3.pdf
 */
public class ParallelStreamExercises {

    static double[] veryLargeArray = new Random().doubles(10000000).toArray();

    public static void main(String[] args) {

       // method1();

        //method3();

        method6();
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
        List<Double> doubles = new ArrayList<>();
        for (double d:veryLargeArray) {
            doubles.add(d);
        }

        double sumOfSquareRoots = doubles.stream()
                .parallel()
                .reduce(0.0, (sumOfSquares, number) -> sumOfSquares += Math.sqrt(number), Double::sum);

        System.out.println(sumOfSquareRoots);
    }

    public static void method6()
    {
        Stream<Double> doubleList = Stream.generate(() -> new Random().nextDouble() * 10);

        doubleList.limit(5)
                .forEach(System.out::println);

    }
}
