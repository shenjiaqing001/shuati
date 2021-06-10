package BiWeeklyContest50;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/4/17
 */
public class lc2 {
    public int[] countPoints(int[][] points, int[][] queries) {
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; ++i) {
            for (int j = 0; j < points.length; ++j) {
                int x = queries[i][0] - points[j][0];
                int y = queries[i][1] - points[j][1];
                if (x * x + y * y <= queries[i][2] * queries[i][2]) {
                    res[i]++;
                }
            }
        }
        return res;
    }
}
