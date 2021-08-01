import java.util.HashSet;
import java.util.Set;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/7/30
 */
public class lc288 {
    class ValidWordAbbr {
        Set<String> set = new HashSet<>();

        Set<String> abbSet = new HashSet<>();
        Set<String> abbSet2 = new HashSet<>();

        public ValidWordAbbr(String[] dictionary) {
            for (String word : dictionary) {
                set.add(word);

                if (word.length() >= 2) {
                    String str = word.charAt(0) + String.valueOf(word.length() - 2) +
                            word.charAt(word.length() - 1);
                    if (abbSet.contains(str)) abbSet2.add(str);
                    abbSet.add(str);
                } else {
                    abbSet.add(word);
                }
            }
        }

        public boolean isUnique(String word) {
            String str = word.charAt(0) + String.valueOf(word.length() - 2) +
                    word.charAt(word.length() - 1);
            if (set.contains(word) && !abbSet2.contains(str)) return true;
            if (!abbSet.contains(str)) return true;
            return false;
        }
    }
}
