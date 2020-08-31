import java.util.*;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 7/22/20
 */
public class lc78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, new ArrayList<Integer>(), nums, 0);
        return res;
    }

    public void dfs(List<List<Integer>> res, ArrayList<Integer> now, int[] nums,
                    int start) {
        if (start == nums.length) {
            res.add(new ArrayList<>(now));
        } else {
            dfs(res, now, nums, start + 1);
            now.add(nums[start]);
            dfs(res, now, nums, start + 1);
            now.remove(now.size() - 1);
        }
    }
}
