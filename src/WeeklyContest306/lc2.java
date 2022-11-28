package WeeklyContest306;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/13/22
 */
public class lc2 {
    public int edgeScore(int[] edges) {
        long max = 0;
        int index = 0;
        long[] sum = new long[100005];
        for (int i = 0; i < edges.length; ++i) {
            sum[edges[i]] += i;
        }
        for (int i = 0; i < 100005; ++i) {
            if (max < sum[i]) {
                max = sum[i];
                index = i;
            }
        }
        return index;
    }
}
