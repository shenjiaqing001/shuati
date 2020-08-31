import java.nio.charset.IllegalCharsetNameException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/5/20
 */
public class lc128 {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (map.containsKey(nums[i]))
                continue;

            int left = map.containsKey(nums[i] - 1) ? map.get(nums[i] - 1) : 0;
            int right = map.containsKey(nums[i] + 1) ? map.get(nums[i] + 1) : 0;

            map.put(nums[i], left + right + 1);
            max = Math.max(max, left + right + 1);

            if (left != 0) map.put(nums[i] - left, left + right + 1);
            if (right != 0) map.put(nums[i] + right, left + right + 1);
        }
        return max;
    }

    public static void main(String[] args) {
        lc128 t = new lc128();
        System.out
                .println(t.longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
    }
}
