public class Ohce {
    private Clock clock;
    private String name;

    public Ohce(Clock clock) {
        this.clock = clock;
        name = "Pedro";
    }

    public String respond(String input) {
        if (input.contains("ohce")) {
            name = input.split(" ")[1];
            return String.format(clock.greeting(), name);
        }

        if (input.equals("Stop!")) {
            return String.format("Adios %s", name);
        }

        return getReverse(input);
    }

    private String getReverse(String input) {
        StringBuilder reversed = new StringBuilder(input).reverse();
        if (reversed.toString().equals(input)) {
            reversed.append("\n¡Bonita palabra!");
        }

        return reversed.toString();
    }
}
