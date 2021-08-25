package BiweeklyContest33;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/22/20
 */
public class lc1558 {
    public int minOperations(int[] nums) {
        int max = 0;
        int total = 0;
        for (int num : nums) {
            int[] res = op(num);
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
            } else {
                num /= 2;
                doubletime++;
            }
        }
        return new int[]{plustime, doubletime};
    }
}
