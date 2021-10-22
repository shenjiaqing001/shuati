import java.util.*;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/10/22
 */
public class lc996 {

    public int numSquarefulPerms(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            map.put(i, new ArrayList<>());
            for (int j = 0; j < n; ++j) {
                if (i == j) continue;
                int sum = nums[i] + nums[j];
                int sqrt = (int) Math.sqrt(sum);
                if (sum == sqrt * sqrt) {
                    map.get(i).add(j);
                }
            }
        }
        return dfs(map, nums, 0, -1);
    }

    public int dfs(Map<Integer, List<Integer>> map, int[] nums, int state, int lastNumber) {
        int has = Integer.bitCount(state);
        if (has == nums.length) return 1;
        int count = 0;
        if (has == 0) {
            int last = -1;
            for (int i = 0; i < nums.length; ++i) {
                if (last == -1 || nums[i] != nums[last]) {
                    count += dfs(map, nums, state | (1 << i), i);
                    last = i;
                }
            }
        } else {
            int last = -1;
            for (Integer next : map.get(lastNumber)) {
                if ((state & (1 << next)) == 0) {
                    if (last == -1 || nums[next] != nums[last]) {
                        count += dfs(map, nums, state | (1 << next), next);
                        last = next;
                    }
                }
            }
        }
        return count;
    }
}
