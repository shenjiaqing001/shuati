/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 7/21/20
 */
public class lc70 {
    public int climbStairs(int n) {

        int[] res = new int[50];
        res[0] = 1;
        res[1] = 1;

        for (int i = 2; i <= n; ++i) {
            res[i] = res[i - 1] + res[i - 2];
        }
        return res[n];

    }
}
