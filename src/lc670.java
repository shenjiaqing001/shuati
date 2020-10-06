/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/10/7
 */
public class lc670 {
    public int maximumSwap(int num) {
        String n = Integer.toString(num);
        int max = num;

        for (int i = 0; i < n.length(); ++i) {
            for (int j = 0; j < n.length(); ++j) {
                char[] c = n.toCharArray();
                char tmp = c[i];
                c[i] = c[j];
                c[j] = tmp;
                int now = Integer.valueOf(new String(c));
                max = Math.max(now, max);
            }
        }
        return max;
    }
}
