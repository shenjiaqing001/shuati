import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/4/16
 */
public class lc217 {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (Integer num : nums) set.add(num);
        return !(set.size() == nums.length);
    }
}
