package BiWeeklyContest62;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/10/2
 */
public class lc2025 {
    public static void main(String[] args) {
        lc2025 test = new lc2025();
        System.out.println(test.waysToPartition(new int[]{2, -1, 2}, 3));
    }

    public int waysToPartition(int[] nums, int k) {
        long sum = 0;
        Map<Long, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length - 1; ++i) {
            sum += nums[i];
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        sum += nums[nums.length - 1];
        int max = 0;
        if (sum % 2 == 0 && map.containsKey(sum / 2)) max = map.get(sum / 2);
        long tmp = 0;
        Map<Long, Integer> tmpMap = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            tmp += nums[i];
            long tmpSum = sum + (k - nums[i]);
            if (tmpSum % 2 == 0) {
                tmpSum /= 2;
                int tmpMax = 0;
                if (tmpMap.containsKey(tmpSum)) tmpMax += tmpMap.get(tmpSum);
                if (map.containsKey(tmpSum + nums[i] - k)) tmpMax += map.get(tmpSum + nums[i] - k);
                max = Math.max(max, tmpMax);
            }
            if (i != nums.length - 1) {
                map.put(tmp, map.get(tmp) - 1);
                if (map.get(tmp) == 0) map.remove(tmp);
            }

            tmpMap.put(tmp, tmpMap.getOrDefault(tmp, 0) + 1);
        }
        return max;
    }
}
