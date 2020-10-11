import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/10/11
 */
public class lc452 {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, new Comparator<>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] < o2[1] ? -1 : 1;
            }
        });

        int res = 0;
        long end = Long.MIN_VALUE;
        for (int i = 0; i < points.length; ++i) {
            if (end < points[i][0]) {
                end = points[i][1];
                res++;
            }
        }
        return res;
    }
}
