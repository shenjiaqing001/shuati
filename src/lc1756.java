import java.util.ArrayList;
import java.util.List;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 1/17/22
 */
public class lc1756 {
    class MRUQueue {

        List<Integer> list = new ArrayList<>();

        public MRUQueue(int n) {
            for (int i = 1; i <= n; ++i) {
                list.add(i);
            }
        }

        public int fetch(int k) {
            int num = list.remove(k - 1);
            list.add(num);
            return num;
        }
    }
}
