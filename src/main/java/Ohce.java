public class Ohce {
    public String respond(String input) {
        if (input.equals("Stop!")) {
            return "Adios Pedro";
        }

        String reverse = getReverse(input);
        if (reverse.equals(input)) {
            reverse += "\n¡Bonita palabra!";
        }
        return reverse;
    }

    private String getReverse(String input) {
        return new StringBuilder(input).reverse().toString();
    }
}
