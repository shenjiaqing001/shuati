import java.util.LinkedList;
import java.util.List;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/26/20
 */
public class lc412 {
    public List<String> fizzBuzz(int n) {
        List<String> res = new LinkedList<>();
        for (int i = 1; i <= n; ++i) {
            StringBuilder sb = new StringBuilder();
            if (i % 3 == 0) {
                sb.append("Fizz");
            }
            if (i % 5 == 0) {
                sb.append("Buzz");
            }
            if (sb.length() == 0) {
                sb.append(i);
            }
            res.add(sb.toString());
        }
        return res;
    }
}
