import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 5/24/22
 */
public class lc995 {
    public int minKBitFlips(int[] nums, int k) {
        int n = nums.length;
        Queue<Integer> q = new ArrayDeque<>();
        int res = 0;
        for (int i = 0; i < n; ++i) {
            if ((nums[i] == 0 && q.size() % 2 == 0) || (nums[i] == 1 && q.size() % 2 == 1)) {
                res++;
                if (i + k > n) return -1;
                q.add(i + k - 1);
            }
            if (q.size() > 0 && q.peek() == i) {
                q.remove();
            }
        }
        return res;
    }
}
