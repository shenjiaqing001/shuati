import java.util.Arrays;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/9/6
 */
public class lc899 {
    public String orderlyQueue(String s, int k) {
        if (k > 1) {
            char[] c = s.toCharArray();
            Arrays.sort(c);
            return new String(c);
        } else {
            String res = s;
            for (int i = 1; i < s.length(); i++) {
                String tmp = s.substring(i) + s.substring(0, i);
                if (res.compareTo(tmp) > 0) res = tmp;
            }
            return res;
        }
    }
}
