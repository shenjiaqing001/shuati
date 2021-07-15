import java.util.HashSet;
import java.util.Set;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/7/5
 */
public class lc1044 {
    String res = "";

    public String longestDupSubstring(String S) {
        int lo = 0;
        int hi = S.length() - 1;

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (check(S, mid + 1)) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return res;
    }

    public boolean check(String s, int length) {
        long base = 31;

        long pow_base = 1;
        long hash = 0;
        for (int i = 0; i < length; ++i) pow_base = pow_base * base;
        Set<Long> set = new HashSet<>();

        char[] c = s.toCharArray();
        for (int i = 0; i < c.length; ++i) {
            hash = (hash * base + c[i] - 'a');
            if (i >= length) {
                hash = (hash - pow_base * (c[i - length] - 'a'));
            }

            if (i >= length - 1) {
                if (set.contains(hash)) {
                    res = s.substring(i - length + 1, i + 1);
                    return true;
                }
                set.add(hash);
            }
        }
        return false;
    }
}
