public class Ohce {
    private CurrentHour currentHour;

    public Ohce(CurrentHour currentHour) {
        this.currentHour = currentHour;
    }

    public String respond(String input) {
        if (input.equals("ohce Pedro")) {
            return greeting();
        }

        if (input.equals("Stop!")) {
            return "Adios Pedro";
        }

        String reverse = getReverse(input);
        if (reverse.equals(input)) {
            reverse += "\n¡Bonita palabra!";
        }
        return reverse;
    }

    private String greeting() {
        int hour = currentHour.get();
        if (hour >= 6 && hour < 12) {
            return "¡Buenos días Pedro!";
        } else if (hour >=12 && hour < 20){
            return "¡Buenas tardes Pedro!";
        } else {
            return "¡Buenas noches Pedro!";
        }
    }

    private String getReverse(String input) {
        return new StringBuilder(input).reverse().toString();
    }
}
