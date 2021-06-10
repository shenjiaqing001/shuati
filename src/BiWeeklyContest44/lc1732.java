package BiWeeklyContest44;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/1/23
 */
public class lc1732 {
    public int largestAltitude(int[] gain) {
        int max = 0;
        int sum = 0;
        for (int i = 0; i < gain.length; ++i) {
            sum += gain[i];
            max = Math.max(max, sum);
        }
        return max;
    }
}
