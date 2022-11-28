package WeeklyContest310;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 9/10/22
 */
public class lc2 {
    public int partitionString(String s) {
        Set<Character> set = new HashSet<>();
        int res = 0;
        for (char c : s.toCharArray()) {
            if (set.contains(c)) {
                res++;
                set.clear();
            }
            set.add(c);
        }
        res++;
        return res;
    }
}
