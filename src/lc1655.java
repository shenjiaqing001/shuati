import java.util.*;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/11/18
 */
public class lc1655 {
    public boolean canDistribute(int[] nums, int[] quantity) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        int[] count = new int[map.size()];
        int tmp = 0;
        for (Integer key : map.keySet()) {
            count[tmp++] = map.get(key);
        }
        Arrays.sort(count);
        Arrays.sort(quantity);
        return dfs(count, quantity, quantity.length - 1);
    }

    public boolean dfs(int[] count, int[] quantity, int index) {
        if (index == -1) return true;

        for (int i = 0; i < count.length; ++i) {
            if (count[i] >= quantity[index]) {
                count[i] -= quantity[index];
                if (dfs(count, quantity, index - 1))
                    return true;
                count[i] += quantity[index];
            }
        }
        return false;
    }
}
