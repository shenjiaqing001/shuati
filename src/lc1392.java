/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/7/22
 */
public class lc1392 {
    public String longestPrefix(String s) {
        long prefix = 0;
        long suffix = 0;
        long base = 0;
        long pow_base = 1;
        char[] c = s.toCharArray();
        String res = "";
        for (int i = 0; i < c.length - 1; ++i) {
            int last = c.length - i - 1;
            prefix = base * prefix + c[i] - 'a';
            suffix = suffix + pow_base * (c[last] - 'a');
            pow_base *= base;
            if (prefix == suffix) res = s.substring(0, i + 1);
        }
        return res;
    }
}
