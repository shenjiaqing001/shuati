import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/10/15
 */
public class lc252 {
    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        for (int i = 1; i < intervals.length; ++i) {
            if (intervals[i][0] < intervals[i - 1][1]) return false;
        }
        return true;
    }
}
