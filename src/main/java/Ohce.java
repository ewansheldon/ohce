public class Ohce {
    private CurrentHour currentHour;
    private String name;

    public Ohce(CurrentHour currentHour) {
        this.currentHour = currentHour;
        name = "";
    }

    public String respond(String input) {
        if (input.contains("ohce")) {
            name = input.split(" ")[1];
            return greeting(currentHour.get());
        }
//        if (input.equals("ohce Pedro")) {
//            return greeting(currentHour.get());
//        }

        if (input.equals("Stop!")) {
            return "Adios Pedro";
        }

        String reverse = getReverse(input);
        if (reverse.equals(input)) {
            reverse += "\n¡Bonita palabra!";
        }
        return reverse;
    }

    private String greeting(int hour) {
        if (isBetween(hour, 6, 12)) {
            return "¡Buenos días " + name + "!";
        }
        if (isBetween(hour, 12, 20)) {
            return "¡Buenas tardes " + name + "!";
        }
        return "¡Buenas noches " + name + "!";

    }

    private boolean isBetween(int hour, int start, int end) {
        return hour >= start && hour < end;
    }

    private String getReverse(String input) {
        return new StringBuilder(input).reverse().toString();
    }
}
