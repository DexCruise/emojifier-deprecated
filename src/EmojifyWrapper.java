import java.util.HashMap;

public class EmojifyWrapper {
    public static String emojify(String text) {
        HashMap<Character, String> dictionary = new HashMap<>(); // HashMap for replacement of text

        String alphabet = "cdefghijklmnpqrstuvwxyz";
        char c;
        for (int i = 0; i < 23; i++) {
            c = alphabet.charAt(i);
            dictionary.put(c, ":regional_indicator_"+c+":");
        }

        char[] keys = {
                'a',
                'b',
                'o',
                '!',
                '?',
                '#',
                ' ',
                '0',
                '1',
                '2',
                '3',
                '4',
                '5',
                '6',
                '7',
                '8',
                '9'
        };
        String[] values = {
                ":a:",
                ":b:",
                ":o2:",
                ":exclamation:",
                ":question:",
                ":hash:",
                ":blue_square:",
                ":zero:",
                ":one:",
                ":two:",
                ":three:",
                ":four:",
                ":five:",
                ":six:",
                ":seven:",
                ":eight:",
                ":nine:",

        };

        for (int i = 0; i < keys.length; i++) { // add all contents of $keys and $values to $dictionary
            dictionary.put(keys[i], values[i]);
        }

        return Emojifier.emojify(text, dictionary);
    }
}
