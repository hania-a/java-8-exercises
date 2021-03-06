package hangman;

/*

Since this exercise has a difficulty of > 4 it doesn't come
with any starter implementation.
This is so that you get to practice creating classes and methods
which is an important part of programming in Java.

Please remove this comment when submitting your solution.

*/

import io.reactivex.Observable;

import java.util.*;

public class Hangman {

    public Observable<Output> play(Observable<String> secretWord, Observable<String> guesses) {

        List<Output> outputs = new ArrayList<>();

        secretWord.subscribe((word) -> {

            char[] discovered = "_".repeat(word.length()).toCharArray();

            Set<String> misses = new HashSet<>();
            List<Part> parts = new ArrayList<>();
            Set<String> successfulGuesses = new HashSet<>();
            Status status = Status.PLAYING;

            guesses.subscribe((guessChar) -> {
                // update discovered
                int i = 0;
                for (char ch : word.toCharArray()) {
                    if ((ch == guessChar.charAt(0))) {
                        discovered[i] = ch;
                    }
                    i++;
                }

                // check whether discovered found the char
                if (String.valueOf(discovered).contains(guessChar))
                    successfulGuesses.add(guessChar);
                else {
                    misses.add(guessChar);
                    parts.add(Part.values()[parts.size()]);
                }
            });

            if (!String.valueOf(discovered).contains("_"))
                status = Status.WIN;
            if (parts.size() >= 6)
                status = Status.LOSS;

            outputs.add(new Output(
                    secretWord.blockingFirst(),
                    String.valueOf(discovered),
                    successfulGuesses,
                    misses,
                    parts,
                    status
            ));
        });

        return Observable.fromIterable(outputs);
    }
}
