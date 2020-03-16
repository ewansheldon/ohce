import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OhceShould {
    @Test
    void return_reversal_of_word() {
        Ohce ohce = new Ohce();
        assertEquals("ih", ohce.reverseWord("hi"));
    }

    @Test
    void congratulate_you_when_a_palindrome_is_given() {
        Ohce ohce = new Ohce();
        assertEquals("racecar\n¡Bonita palabra!", ohce.reverseWord("racecar"));
    }
}