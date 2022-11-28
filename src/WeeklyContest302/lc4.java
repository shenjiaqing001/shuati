package WeeklyContest302;

import java.util.Arrays;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 7/16/22
 */
public class lc4 {
    public int gcd(int a, int b) {
        int tmp = 1;
        while (b > 0) {
            tmp = a;
            a = b;
            b = tmp % b;
        }
        return a;
    }

    public int minOperations(int[] nums, int[] numsDivide) {
        int gcd = numsDivide[0];
        for (int i = 1; i < numsDivide.length; ++i) {
            gcd = gcd(gcd, numsDivide[i]);
        }
        Arrays.sort(nums);
        int start = 0;
        while (start < nums.length) {
            if (gcd % nums[start] == 0) return start;
            start++;
        }
        return -1;
    }
}
