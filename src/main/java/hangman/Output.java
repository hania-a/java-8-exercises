package hangman;

import static java.util.stream.Collectors.joining;

import java.util.Collections;
import java.util.List;
import java.util.Set;

class Output {

    public final String secret;
    public final String discovered;
    public final Set<String> successfulGuesses;
    public final Set<String> misses;
    public final List<Part> parts;
    public final Status status;

    Output(
        final String secret,
        final String discovered,
        final Set<String> successfulGuesses,
        final Set<String> misses,
        final List<Part> parts,
        final Status status) {
        this.secret = secret;
        this.discovered = discovered;
        this.successfulGuesses = Set.copyOf(successfulGuesses);
        this.misses = Set.copyOf(misses);
        this.parts = List.copyOf(parts);
        this.status = status;
    }

    static Output empty() {
        return new Output(
            null,
            null,
            Collections.emptySet(),
            Collections.emptySet(),
            Collections.emptyList(),
            null);
    }

}
