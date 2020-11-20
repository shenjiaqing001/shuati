import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/11/20
 */
public class lc519 {
    class Solution {
        Map<Integer, Integer> map = new HashMap<>();
        int rows = 0;
        int cols = 0;
        int total = 0;
        Random r = new Random();

        public Solution(int n_rows, int n_cols) {
            rows = n_rows;
            cols = n_cols;
            total = rows * cols;
        }

        public int[] flip() {
            int tmp = r.nextInt(total);
            total--;
            int num = map.getOrDefault(tmp, tmp);
            map.put(tmp, map.getOrDefault(total, total));
            return new int[]{num / cols, num % cols};
        }

        public void reset() {
            map.clear();
            total = rows * cols;
        }
    }

}
