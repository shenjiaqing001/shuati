package WeeklyContest236;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/4/13
 */
public class lc1822 {
    public int arraySign(int[] nums) {
        int res = 1;
        for (int num : nums) {
            if (num == 0) res = 0;
            else if (num > 0) res *= 1;
            else res *= -1;
        }
        return res;
    }
}
