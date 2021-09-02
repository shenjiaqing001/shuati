package WeeklyContest256;

import java.util.Arrays;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/8/28
 */
public class lc1985 {
    public String kthLargestNumber(String[] nums, int k) {
        Arrays.sort(nums, (o1, o2) -> {
            if (o1.length() == o2.length()) return o1.compareTo(o2);
            else return o1.length() - o2.length();
        });
        return nums[nums.length - k];
    }
}
