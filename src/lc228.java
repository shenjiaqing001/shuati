import java.util.ArrayList;
import java.util.List;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/10/28
 */
public class lc228 {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if (nums.length == 0) return res;
        int start = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] - 1 != nums[i - 1]) {
                if (start == nums[i - 1]) res.add(String.valueOf(nums[i - 1]));
                else res.add(start + "->" + nums[i - 1]);
                start = nums[i];
            }
        }
        if (start == nums[nums.length - 1]) res.add(String.valueOf(start));
        else res.add(start + "->" + nums[nums.length - 1]);
        return res;
    }
}
