package WeeklyContest310;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 9/10/22
 */
public class lc3 {
    public int minGroups(int[][] intervals) {
        int[] diff = new int[1000000 + 5];
        for (int[] interval : intervals) {
            diff[interval[0]]++;
            diff[interval[1] + 1]--;
        }
        int max = 0;
        int sum = 0;
        for (int i = 1; i <= 1000000; ++i) {
            sum += diff[i];
            max = Math.max(max, sum);
        }
        return max;
    }
}
