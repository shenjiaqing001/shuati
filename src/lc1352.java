import java.util.ArrayList;
import java.util.List;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/11/4
 */
public class lc1352 {
    class ProductOfNumbers {
        List<Integer> prefix = new ArrayList<>();

        public ProductOfNumbers() {

        }

        public void add(int num) {
            if (num == 0) prefix = new ArrayList<>();
            else {
                if (prefix.size() == 0) prefix.add(num);
                else prefix.add(num * prefix.get(prefix.size() - 1));
            }
        }

        public int getProduct(int k) {
            if (k > prefix.size()) return 0;
            if (k == prefix.size()) return prefix.get(prefix.size() - 1);
            else return (prefix.get(prefix.size() - 1) / prefix.get(prefix.size() - 1 - k));
        }
    }
}
