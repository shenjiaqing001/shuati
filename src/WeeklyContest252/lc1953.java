package WeeklyContest252;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/7/31
 */
public class lc1953 {
    public long numberOfWeeks(int[] milestones) {
        long sum = 0;
        long max = 0;
        for (int milestone : milestones) {
            sum += milestone;
            max = Math.max(milestone, max);
        }
        if (max <= sum / 2) return sum;
        else return 2 * (sum - max) + 1;
    }
}
