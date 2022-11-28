package WeeklyContest317;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 10/29/22
 */
public class lc1 {
    public int averageValue(int[] nums) {
        int sum = 0;
        int count = 0;
        for (int num : nums) {
            if (num % 6 == 0) {
                sum += num;
                count++;
            }
        }
        if (count == 0) return 0;
        return sum / count;
    }
}
