import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class OhceShould {

    TestableClock clock;
    private Ohce ohce;

    @BeforeEach
    void setUp() {
        clock = new TestableClock();
        ohce = new Ohce(clock);
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
            "22,¡Buenas noches Pedro!"
    })
    void return_proper_greeting_depending_on_time(int hour, String response) {
        clock.setHour(hour);
        assertEquals(response, ohce.respond("ohce Pedro"));
    }

    @Test
    void print_out_name_provided_at_start() {
        clock.setHour(8);
        assertEquals("¡Buenos días Ewan!", ohce.respond("ohce Ewan"));
    }

    @Test
    void print_out_stop_with_provided_name() {
        clock.setHour(8);
        ohce.respond("ohce Ewan");
        assertEquals("Adios Ewan", ohce.respond("Stop!"));

    }

    class TestableClock extends Clock {
        private int hour;

        public void setHour(int hour) {
            this.hour = hour;
        }

        @Override
        protected int getHour() {
            return hour;
        }
    }
}