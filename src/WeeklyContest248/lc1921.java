package WeeklyContest248;

import java.util.Arrays;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/7/3
 */
public class lc1921 {
    public int eliminateMaximum(int[] dist, int[] speed) {
        int n = dist.length;
        double[] minutes = new double[n];
        for (int i = 0; i < n; ++i) {
            minutes[i] = (double)dist[i] / (double)speed[i];
        }
        Arrays.sort(minutes);

        for (double d : minutes) System.out.println(d);


        for (int i = 1; i < n; ++i) {
            if (minutes[i] <= i) return i;
        }
        return n;
    }
}
