import java.util.HashMap;

public class Emojifier {
    public static String emojify(String input, HashMap<Character, String> dictionary) {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            output.append(dictionary.get(input.charAt(i))).append(" ");
        }
        return output.toString();
    }
}
