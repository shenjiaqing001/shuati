/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/8/30
 */
public class lc598 {
    public int maxCount(int m, int n, int[][] ops) {
        int x = m;
        int y = n;
        for (int[] op : ops) {
            x = Math.min(x, op[0]);
            y = Math.min(y, op[1]);
        }
        return x * y;
    }
}
