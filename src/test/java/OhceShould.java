import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class OhceShould {

    @Mock
    CurrentHour currentHour;
    private Ohce ohce;

    @BeforeEach
    void setUp() {
        ohce = new Ohce(currentHour);
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

    @ParameterizedTest
    @CsvSource({
            "10,¡Buenos días Pedro!",
            "14,¡Buenas tardes Pedro!",
            "21,¡Buenas noches Pedro!",
    })
    void return_proper_greeting_depending_on_time(int hour, String response) {
        when(currentHour.get()).thenReturn(hour);
        assertEquals(response, ohce.respond("ohce Pedro"));
    }

    @Test
    void print_out_name_provided_at_start() {
        when(currentHour.get()).thenReturn(10);
        assertEquals("¡Buenos días Ewan!", ohce.respond("ohce Ewan"));
    }

    @Test
    void print_out_stop_with_provided_name() {
        when(currentHour.get()).thenReturn(10);
        ohce.respond("ohce Ewan");
        assertEquals("Adios Ewan", ohce.respond("Stop!"));

    }
}