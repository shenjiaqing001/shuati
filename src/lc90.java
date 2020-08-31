import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 7/24/20
 */
public class lc90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        dfs(res, new ArrayList<Integer>(), nums, 0);
        return res;
    }

    public void dfs(List<List<Integer>> res, ArrayList<Integer> now, int[] nums,
                    int start) {
        res.add(new ArrayList<>(now));
        for (int i = start; i < nums.length; ++i) {
            if (i > start && nums[i] == nums[i - 1])
                continue;
            now.add(nums[i]);
            dfs(res, now, nums, i + 1);
            now.remove(now.size() - 1);
        }
    }
}
