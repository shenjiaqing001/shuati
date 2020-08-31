import java.util.ArrayList;
import java.util.List;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/6/20
 */
public class lc442 {
    public List<Integer> findDuplicates(int[] nums) {
        int pos = 0;
        List<Integer> res = new ArrayList<>();

        while (pos < nums.length) {
            if (nums[pos] != pos + 1 && nums[pos] != 0) {
                int tmp = nums[nums[pos] - 1];
                if (tmp == nums[pos]) {
                    res.add(tmp);
                    nums[pos] = 0;
                    pos++;
                    continue;
                }
                nums[nums[pos] - 1] = nums[pos];
                nums[pos] = tmp;
            } else {
                pos++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        lc442 t = new lc442();
        System.out.println(t.findDuplicates(new int[]{4, 3, 2, 7, 8, 2, 3, 1}));
    }
}
