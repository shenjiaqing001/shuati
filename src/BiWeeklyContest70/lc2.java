package BiWeeklyContest70;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 1/22/22
 */
public class lc2 {
    public int numberOfArrays(int[] differences, int lower, int upper) {
        long max = 0;
        long min = 0;
        long sum = 0;
        for (int diff : differences) {
            sum += diff;
            max = Math.max(max, sum);
            min = Math.min(min, sum);
        }
        if (max - min > upper - lower) return 0;
        return (int) ((upper - lower) - (max - min) + 1);
    }
}
