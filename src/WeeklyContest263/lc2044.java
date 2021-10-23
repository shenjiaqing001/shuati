package WeeklyContest263;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/10/16
 */
public class lc2044 {
    Map<Integer, Integer> map = new HashMap<>();
    int max = 0;

    public static void main(String[] args) {
        lc2044 test = new lc2044();
        test.countMaxOrSubsets(new int[]{3, 1});
    }

    public int countMaxOrSubsets(int[] nums) {
        dfs(nums, 0, 0);
        return map.get(max);
    }

    public void dfs(int[] nums, int index, int res) {
        if (index == nums.length) {
            max = Math.max(max, res);
            map.put(res, map.getOrDefault(res, 0) + 1);
            return;
        }
        dfs(nums, index + 1, res);
        dfs(nums, index + 1, res | nums[index]);
    }

    public int countMaxOrSubsets2(int[] nums) {
        int n = nums.length;
        int res = 0;
        int max = 0;
        for (int i = 1; i < (1 << n); ++i) {
            int or = 0;
            for (int j = 0; j < n; ++j) {
                if ((i & (1 << j)) != 0) {
                    or |= nums[j];
                }
            }
            if (max == or) res++;
            else if (max > or) {
                max = or;
                res = 1;
            }
        }
        return res;
    }


}
