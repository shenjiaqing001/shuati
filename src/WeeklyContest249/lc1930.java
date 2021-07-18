package WeeklyContest249;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/7/10
 */
public class lc1930 {
    public int countPalindromicSubsequence(String s) {
        char[] c = s.toCharArray();
        int n = s.length();
        int res = 0;
        for (char character = 'a'; character <= 'z'; ++character) {
            int left = 0;
            int right = c.length - 1;
            while (left < n && c[left] != character) left++;
            while (right >= 0 && c[right] != character) right--;
            if (left >= right) continue;

            Set<Character> set = new HashSet<>();

            for (int i = left + 1; i < right; ++i) {
                set.add(c[i]);
            }
            res += set.size();
        }
        return res;
    }
}
