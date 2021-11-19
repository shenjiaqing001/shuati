import java.util.ArrayList;
import java.util.List;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/10/31
 */
public class lc448 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for (int i = 0; i < nums.length; ++i) nums[i] -= 1;
        int left = 0;
        while (left < nums.length) {
            if (left == nums[left]) {
                left++;
            } else {
                int num = nums[left];
                if (num == nums[num]) {
                    left++;
                } else {
                    int tmp = nums[num];
                    nums[num] = num;
                    nums[left] = tmp;
                }
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] != i) res.add(i + 1);
        }
        return res;
    }

    public List<Integer> findDisappearedNumbers2(int[] nums) {
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] == i + 1) continue;
            while (true) {
                if (nums[i] == i + 1) break;
                if (nums[nums[i] - 1] == nums[i]) break;
                int tmp = nums[i];
                nums[i] = nums[nums[i] - 1];
                nums[tmp - 1] = tmp;
            }
        }
        List<Integer> res = new ArrayList();
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] != i + 1) res.add(i + 1);
        }
        return res;
    }
}
