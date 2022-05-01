import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 3/11/22
 */
public class lc2193_Biweekly73 {
    public int minMovesToMakePalindrome(String s) {
        int n = s.length();
        char[] c = s.toCharArray();
        int res = 0;
        for (int i = 0; i < n / 2; ++i) {
            char left = c[i];
            char right = c[n - 1 - i];
            int j = i, k = n - 1 - i;
            for (; j <= n - 1 - i && c[j] != right; ++j) ;
            for (; k >= i && c[k] != left; --k) ;
            if (j - i <= n - 1 - i - k) {
                for (int m = j; m > i; --m) {
                    c[m] = c[m - 1];
                }
                res += j - i;
            } else {
                for (int m = k; m < n - 1 - i; ++m) {
                    c[m] = c[m + 1];
                }
                res += n - 1 - i - k;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        lc2193_Biweekly73 test = new lc2193_Biweekly73();
        test.minMovesToMakePalindrome("aabb");
    }
}
