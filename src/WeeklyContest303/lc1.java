package WeeklyContest303;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 7/23/22
 */
public class lc1 {
    public char repeatedCharacter(String s) {
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (set.contains(c)) return c;
            else set.add(c);
        }
        return ' ';
    }
}
