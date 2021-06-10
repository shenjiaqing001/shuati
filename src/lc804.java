import java.util.HashSet;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/11/23
 */
public class lc804 {
    public int uniqueMorseRepresentations(String[] words) {
        String[] morseCode = {
                ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..",
                ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.",
                "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < words.length; ++i) {
            StringBuilder sb = new StringBuilder();
            for (char c : words[i].toCharArray()) {
                sb.append(morseCode[c - 'a']);
            }
            set.add(sb.toString());
        }

        return set.size();
    }
}
