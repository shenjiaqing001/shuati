package WeeklyContest316;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 10/22/22
 */
public class lc2 {
    public int gcd(int a, int b) {
        int tmp = 1;
        while (b > 0) {
            tmp = a;
            a = b;
            b = tmp % b;
        }
        return a;
    }


    public int subarrayGCD(int[] nums, int k) {
        int res = 0;
        for (int i = 0; i < nums.length; ++i) {
            int gcd = nums[i];
            for (int j = i; j < nums.length; ++j) {
                gcd = gcd(gcd, nums[j]);
                if (gcd == k) res++;
            }
        }
        return res;
    }
}
