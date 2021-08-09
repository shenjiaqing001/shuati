package WeeklyContest212;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/10/25
 */
public class lc1630 {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> res = new ArrayList<>();
        int m = l.length;
        int n = nums.length;
        for (int i = 0; i < m; ++i) {
            int left = l[i];
            int right = r[i];
            res.add(check(nums, left, right));
        }
        return res;
    }

    public boolean check(int[] nums, int left, int right) {
        int[] newArray = new int[right - left + 1];
        for (int i = 0; i < newArray.length; ++i) {
            newArray[i] = nums[i + left];
        }
        Arrays.sort(newArray);

        int diff = newArray[1] - newArray[0];
        for (int i = 1; i < newArray.length; ++i) {
            if (newArray[i] - newArray[i - 1] != diff) return false;
        }

        return true;
    }

}
