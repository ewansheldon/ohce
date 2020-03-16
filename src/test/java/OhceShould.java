import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
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

    @Test
    void say_buenos_dias_when_started_between_6_and_12() {
        when(currentHour.get()).thenReturn(10);
        assertEquals("¡Buenos días Pedro!", ohce.respond("ohce Pedro"));
    }

    @Test
    void say_buenos_tardes_when_started_between_12_and_8() {
        when(currentHour.get()).thenReturn(14);
        assertEquals("¡Buenas tardes Pedro!", ohce.respond("ohce Pedro"));
    }
}