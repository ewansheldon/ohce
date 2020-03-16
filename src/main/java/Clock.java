import java.util.Calendar;

public class Clock {
    public Clock() {
    }

    public String greeting() {
        if (isBetween(6, 12)) {
            return "¡Buenos días %s!";
        }
        if (isBetween(12, 20)) {
            return "¡Buenas tardes %s!";
        }

        return "¡Buenas noches %s!";
    }

    private boolean isBetween(int start, int end) {
        int hour = getHour();
        return hour >= start && hour < end;
    }

    protected int getHour() {
        Calendar now = Calendar.getInstance();
        return now.get(Calendar.HOUR_OF_DAY);
    }
}