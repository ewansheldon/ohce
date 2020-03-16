public class Ohce {
    public String reverseWord(String input) {
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
