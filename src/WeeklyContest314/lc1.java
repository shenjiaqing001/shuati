package WeeklyContest314;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 10/8/22
 */
public class lc1 {
    public int hardestWorker(int n, int[][] logs) {
        int last = 0;
        int max = 0;
        int res = 0;
        for (int[] log : logs) {
            int time = log[1] - last;
            if (time > max) {
                res = log[0];
                max = time;
            } else if (time == max) {
                res = Math.min(res, log[0]);
            }
            last = log[1];
        }
        return res;
    }
}
