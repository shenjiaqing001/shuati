import java.util.LinkedList;
import java.util.List;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/14/20
 */
public class lc163 {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new LinkedList<>();
        long lo = Long.valueOf(lower);
        long hi = Long.valueOf(upper);
        for (int i = 0; i < nums.length; ++i) {
            if (lo < nums[i]) {
                res.add(makeString(nums, lo, nums[i] - 1));
            }
            lo = (long)nums[i] + 1;
            if (lo > hi) break;
        }
        if (lo <= hi) res.add(makeString(nums, lo, hi));
        return res;
    }

    public String makeString(int[] nums, long left, long right) {
        if (left == right) return String.valueOf(left);
        else return left + "->" + right;
    }

    public static void main(String[] args) {
        lc163 t = new lc163();
    }
}
