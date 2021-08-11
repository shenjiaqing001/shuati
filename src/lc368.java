import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/8/10
 */
public class lc368 {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        List<Integer>[] lists = new List[n];
        Arrays.sort(nums);

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                if (nums[i] % nums[j] == 0) {
                    if (lists[i] == null || lists[j].size() > lists[i].size()) {
                        lists[i] = new ArrayList<>(lists[j]);
                    }
                }
            }
            if (lists[i] == null) lists[i] = new ArrayList<>();
            lists[i].add(nums[i]);
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            if (lists[i].size() > res.size()) res = lists[i];
        }
        return res;
    }
}
