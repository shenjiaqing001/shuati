/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/2/8
 */
public class lc821 {
    public int[] shortestToChar(String s, char c) {
        int n = s.length();
        char[] chars = s.toCharArray();
        int[] res = new int[n];
        int last = -n;
        for (int i = 0; i < n; ++i) {
            if (chars[i] == c) last = i;
            res[i] = i - last;
        }
        last = 2 * n;
        for (int i = n - 1; i >= 0; --i) {
            if (chars[i] == c) last = i;
            res[i] = Math.min(res[i], last - i);
        }
        return res;
    }
}
