package WeeklyContest216;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/11/26
 */
public class lc1663 {
    public String getSmallestString(int n, int k) {
        k -= n;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; ++i) sb.append('a');
        int pos = n - 1;
        while (k > 0) {
            if (k >= 25) {
                sb.setCharAt(pos, 'z');
                pos--;
                k -= 25;
            } else {
                sb.setCharAt(pos, (char) (sb.charAt(pos) + k));
                k = 0;
            }
        }
        return sb.toString();
    }
}
