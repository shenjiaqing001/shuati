package LeetCodeContest.Spring2022;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 4/16/22
 */
public class lc4 {
    public int defendSpaceCity(int[] time, int[] position) {
        int[][] map = new int[5][100];
        for (int i = 0; i < time.length; ++i) {
            map[time[i]][position[i]] = 1;
        }
        int[][] dp = new int[5][2];
        for (int i = 0; i < 100; ++i) {


        }
        return dp[4][2];
    }
}
