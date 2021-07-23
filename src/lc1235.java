import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/7/17
 */
public class lc1235 {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = profit.length;
        int[][] intervals = new int[n][3];
        for (int i = 0; i < n; ++i) {
            intervals[i][0] = startTime[i];
            intervals[i][1] = endTime[i];
            intervals[i][2] = profit[i];
        }
        Arrays.sort(intervals, (o1, o2) -> (o1[0] - o2[0]));
        // profit endtime
        int proMax = 0;
        // profit endtime
        PriorityQueue<int[]> timepq = new PriorityQueue<>((o1, o2) -> (o1[1] - o2[1]));
        int max = 0;
        for (int[] interval : intervals) {
            while (!timepq.isEmpty() && timepq.peek()[1] <= interval[0]) {
                proMax = Math.max(proMax, timepq.poll()[0]);
            }
            if (proMax == 0) {
                max = Math.max(interval[2], max);
                timepq.add(new int[]{interval[2], interval[1]});
            } else {
                max = Math.max(max, proMax + interval[2]);
                timepq.add(new int[]{proMax + interval[2], interval[1]});
            }
        }
        return max;
    }

    public static void main(String[] args) {
        lc1235 test = new lc1235();
        test.jobScheduling(new int[]{1, 2, 3, 3}, new int[]{3, 4, 5, 6}, new int[]{50, 10, 40, 70});

    }
}
