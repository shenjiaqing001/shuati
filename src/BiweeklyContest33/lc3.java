package BiweeklyContest33;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/22/20
 */
public class lc3 {
    public int minOperations(int[] nums) {
        int max = 0;
        int total = 0;
        for (int i = 0; i < nums.length; ++i) {
            int[] res = op(nums[i]);
            max = Math.max(max, res[1]);
            total += res[0];
        }
        return total + max;
    }

    public int[] op(int num) {
        int plustime = 0;
        int doubletime = 0;
        while (num > 0) {
            if (num % 2 == 1) {
                plustime++;
                num--;
                continue;
            } else {
                num /= 2;
                doubletime++;
                continue;
            }
        }
        return new int[]{plustime, doubletime};
    }
}
