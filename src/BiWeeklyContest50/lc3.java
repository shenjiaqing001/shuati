package BiWeeklyContest50;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/4/17
 */
public class lc3 {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int max = (1 << maximumBit) - 1;
        int n = nums.length;
        int[] res = new int[n];

        int tmp = nums[0];
        res[n - 1] = (max ^ tmp);
        for (int i = 1; i < n; ++i) {
            tmp = tmp ^ nums[i];
            res[n - i - 1] = (max ^ tmp);
        }

        return res;
    }

    public static void main(String[] args) {
        int max = 7;
        System.out.println(7 ^ 2);
    }
}
