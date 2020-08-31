/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/17/20
 */
public class lc171 {
    public int titleToNumber(String s) {
        int res = 0;
        char[] c = s.toCharArray();
        for (int i = 0; i < c.length; ++i) {
            int now = c[i] - 'A' + 1;
            res = res * 26 + now;
        }
        return res;
    }
}