/*

Since this exercise has a difficulty of > 4 it doesn't come
with any starter implementation.
This is so that you get to practice creating classes and methods
which is an important part of programming in Java.

Please remove this comment when submitting your solution.

*/

import io.reactivex.Observable;
import io.reactivex.Observer;

import java.util.List;
import java.util.Set;

public class Hangman {

    public Observable<Output> play(Observable<String> secret, Observable<String> e) {
        Output myOutput = new Output(
                secret.blockingFirst(),
                "",
                Set.of(""),
                Set.of(""),
                List.of(Part.BODY),
                Status.LOSS
        );
        return Observable.fromArray(myOutput);
    }
}
