/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/11/4
 */
public class lc1446 {
    public int maxPower(String s) {
        int last = 0;
        int max = 0;
        char[] c = s.toCharArray();
        for (int i = 0; i < c.length; ++i) {
            if (c[i] == c[last]) {
                max = Math.max(max, i - last + 1);
            } else last = i;
        }
        return max;
    }
}
