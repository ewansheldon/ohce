import java.util.Date;

public class CurrentHour {
    public CurrentHour() {
    }

    int get() {
        return new Date().getHours();
    }
}