public class Ohce {
    private CurrentHour currentHour;
    private String name;

    public Ohce(CurrentHour currentHour) {
        this.currentHour = currentHour;
        name = "Pedro";
    }

    public String respond(String input) {
        if (input.contains("ohce")) {
            name = input.split(" ")[1];
            return String.format(greeting(currentHour.get()), name);
        }

        if (input.equals("Stop!")) {
            return String.format("Adios %s", name);
        }

        String reverse = getReverse(input);
        if (reverse.equals(input)) {
            reverse += "\n¡Bonita palabra!";
        }
        return reverse;
    }

    private String greeting(int hour) {
        if (isBetween(hour, 6, 12)) {
            return "¡Buenos días %s!";
        }
        if (isBetween(hour, 12, 20)) {
            return "¡Buenas tardes %s!";
        }
        return "¡Buenas noches %s!";

    }

    private boolean isBetween(int hour, int start, int end) {
        return hour >= start && hour < end;
    }

    private String getReverse(String input) {
        return new StringBuilder(input).reverse().toString();
    }
}
