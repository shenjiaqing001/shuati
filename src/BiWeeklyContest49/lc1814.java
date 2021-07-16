package BiWeeklyContest49;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/4/3
 */
public class lc1814 {
    public int countNicePairs(int[] nums) {
        Map<Long, Long> map = new HashMap<>();
        long res = 0;
        for (int i = 0; i < nums.length; ++i) {
            int reverse = reverseNumber(nums[i]);
            map.put((long) (reverse - nums[i]),
                    map.getOrDefault((long) reverse - nums[i], 0L) + 1);
        }
        for (Long value : map.values()) {
            if (value > 1) {
                long plus = value * (value - 1) / 2;
                res += plus;
            }
        }
        return (int) (res % 1000000007);
    }

    public int reverseNumber(int num) {
        int reverse = 0;
        while (num > 0) {
            reverse = reverse * 10 + num % 10;
            num /= 10;
        }
        return reverse;
    }

    public static void main(String[] args) {
        lc1814 test = new lc1814();
        long a = 10;
        System.out.println(a * (a - 1) / 2);
        System.out.println(test.reverseNumber(200000));
    }

}
