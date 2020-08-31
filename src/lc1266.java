/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/29/20
 */
public class lc1266 {
    public int minTimeToVisitAllPoints(int[][] points) {
        int res = 0;
        for (int i = 1; i < points.length; ++i) {
            res += Math.max(Math.abs(points[i][0] - points[i - 1][0]),
                    Math.abs(points[i][1] - points[i - 1][1]));
        }
        return res;
    }
}
