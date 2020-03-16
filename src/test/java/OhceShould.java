import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OhceShould {

    private Ohce ohce;

    @BeforeEach
    void setUp() {
        ohce = new Ohce();
    }

    @Test
    void return_reversal_of_word() {
        assertEquals("ih", ohce.respond("hi"));
    }

    @Test
    void congratulate_you_when_a_palindrome_is_given() {
        assertEquals("racecar\n¡Bonita palabra!", ohce.respond("racecar"));
    }

    @Test
    void say_goodbye_if_stop_with_exclamation() {
        assertEquals("Adios Pedro", ohce.respond("Stop!"));
    }
}