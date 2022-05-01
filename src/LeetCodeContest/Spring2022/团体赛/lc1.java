package LeetCodeContest.Spring2022.团体赛;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 4/23/22
 */
public class lc1 {
    public int getMinimumTime(int[] time, int[][] fruits, int limit) {
        int res = 0;
        for (int[] fruit : fruits) {
            int type = fruit[0];
            int num = fruit[1];
            res += time[type] * ((num - 1) / limit + 1);
        }
        return res;
    }
}
