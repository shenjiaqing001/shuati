package WeeklyContest319;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 11/12/22
 */
public class lc2 {
    public int gcd(int a, int b) {
        int tmp;
        while (b > 0) {
            tmp = a;
            a = b;
            b = tmp % b;
        }
        return a;
    }

    public int subarrayLCM(int[] nums, int k) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (k % nums[i] != 0) continue;
            int lcm = nums[i];
            for (int j = i; j < nums.length; j++) {
                if (k % nums[j] != 0) break;
                lcm = lcm * nums[j] / gcd(lcm, nums[j]);
                if(lcm == k) res ++;
            }
        }
        return res;
    }
}
