import java.util.HashMap;
import java.util.Map;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/6/15
 */
public class lc974 {
    public int subarraysDivByK(int[] nums, int k) {
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; ++i) {
            sum += nums[i];
            sum %= k;
            sum = (sum + k) % k;
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        int res = 0;
        res += map.getOrDefault(0, 0);
        for (Integer value : map.values()) {
            System.out.println(value);
            if (value > 1) {
                res += value * (value - 1) / 2;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println((-10 % 5 + 5) % 5);
    }
}
