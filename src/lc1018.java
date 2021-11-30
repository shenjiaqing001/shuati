import java.util.ArrayList;
import java.util.List;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 11/30/21
 */
public class lc1018 {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean> list = new ArrayList<>();
        int left = 0;
        for (int i = 0; i < nums.length; ++i) {
            left = left * 2 + nums[i];
            left %= 5;
            if (left == 0) list.add(true);
            else list.add(false);
        }
        return list;
    }
}
