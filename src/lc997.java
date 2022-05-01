/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 1/2/22
 */
public class lc997 {
    public int findJudge(int n, int[][] trust) {
        int[] count = new int[n + 1];
        boolean[] flag = new boolean[n + 1];
        for (int[] t : trust) {
            count[t[1]]++;
            flag[t[0]] = true;
        }
        for (int i = 1; i <= n; ++i) {
            if (count[i] == n - 1 && !flag[i]) return i;
        }
        return -1;
    }
}
