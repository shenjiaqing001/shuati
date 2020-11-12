import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/11/13
 */
public class lc47 {


    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        get(res, nums, 0);
        return res;
    }

    private void get(List<List<Integer>> res, int[] nums, int start) {
        if (start == nums.length - 1) {
            res.add(toList(nums));
            return;
        }
        Set<Integer> set = new HashSet<>();
        for (int i = start; i < nums.length; i++) {
            if (set.add(nums[i])) {
                int tmp = nums[start];
                nums[start] = nums[i];
                nums[i] = tmp;
                get(res, nums, start + 1);
                nums[i] = nums[start];
                nums[start] = tmp;
            }
        }
    }

    private List<Integer> toList(int[] nums) {
        List<Integer> list = new LinkedList<>();
        for (int i : nums) list.add(i);
        return list;
    }
}
