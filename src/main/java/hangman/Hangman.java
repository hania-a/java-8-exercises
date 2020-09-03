package hangman;/*

Since this exercise has a difficulty of > 4 it doesn't come
with any starter implementation.
This is so that you get to practice creating classes and methods
which is an important part of programming in Java.

Please remove this comment when submitting your solution.

*/

import io.reactivex.Observable;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Hangman {

    public Observable<Output> play(Observable<String> secretWord, Observable<String> guesses) {

        char[] discovered = "_".repeat(secretWord.blockingFirst().length()).toCharArray();

        Output myOutput = new Output(
                secretWord.blockingFirst(),
                String.valueOf(discovered),
                Collections.emptySet(),
                Collections.emptySet(),
                Collections.emptyList(),
                Status.PLAYING
        );

        if (guesses.isEmpty().blockingGet()) {
            return Observable.fromArray(myOutput);
        }

        // update discovered
        int i = 0;
        String guessChar = guesses.blockingFirst();
        for (char ch : "secret".toCharArray()) {
            if ((ch + "").equals(guessChar)) {
                discovered[i] = ch;
            }
            i++;
        }

        // update guesses
        Set<String> set = new HashSet<>(){{add(guessChar);}};

        return Observable.fromArray(new Output(
                secretWord.blockingFirst(),
                String.valueOf(discovered),
//                Collections.singleton(guessChar),
                set,
                Collections.emptySet(),
                Collections.emptyList(),
                Status.PLAYING
        ));
    }
}
