package parallelstreams;

import java.util.ArrayList;
import java.util.OptionalDouble;
import java.util.Random;
import java.util.stream.DoubleStream;

public class ParallelStreamExercises {

    public static void main(String[] args) {

        method1();
    }

    private static void method1() {
        double[] veryLargeArray = new Random().doubles(100000000).toArray();
 //       double[] veryLargeArray = new double[] {4.0, 16.0, 25.0};

        double sumOfSquareRoots = DoubleStream.of(veryLargeArray).reduce(0.0, (sumOfSquares, number) -> sumOfSquares += Math.sqrt(number));

        System.out.println(sumOfSquareRoots);
    }
}
