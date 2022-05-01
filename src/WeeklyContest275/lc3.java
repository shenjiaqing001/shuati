package WeeklyContest275;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 1/8/22
 */
public class lc3 {
    public int wordCount(String[] startWords, String[] targetWords) {
        Set<Integer> set = new HashSet<>();
        for (String s : startWords) {
            int hash = 0;
            for (char c : s.toCharArray()) {
                hash |= 1 << (c - 'a');
            }
            set.add(hash);
        }
        int count = 0;
        for (String s : targetWords) {
            int hash = 0;
            for (char c : s.toCharArray()) {
                hash |= 1 << (c - 'a');
            }
            for (int i = 0; i < 26; ++i) {
                if ((hash & (1 << i)) > 0) {
                    if (set.contains(hash ^ (1 << i))) {
                        count++;
                        break;
                    }
                }
            }
        }
        return count;
    }
}
