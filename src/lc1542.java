/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/7/1
 */
public class lc1542 {
    public int longestAwesome(String s) {
        char[] c = s.toCharArray();
        int[] pos = new int[1024];
        int state = 0;
        for (int i = 0; i < 1024; ++i) pos[i] = -1;
        int max = 1;
        for (int i = 0; i < c.length; i++) {
            state ^= 1 << (c[i] - '0');
            if (pos[state] == -1 && state != 0) {
                pos[state] = i;
            }
            max = Math.max(max, i - pos[state]);

            for (int j = 0; j < 10; ++j) {
                int tmp = state ^ (1 << j);
                if (tmp == 0) max = Math.max(max, i + 1);
                else if (pos[tmp] != -1) max = Math.max(max, i - pos[tmp]);
            }
        }
        return max;
    }
}
