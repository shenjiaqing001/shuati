import java.util.ArrayList;
import java.util.List;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/3/8
 */
public class lc1441 {
    public List<String> buildArray(int[] target, int n) {
        List<String> res = new ArrayList<>();
        int index = 0;
        for (int i = 1; i <= n; ++i) {
            if (index == target.length) break;
            res.add("Push");
            if (target[index] != i) {
                res.add("Pop");
            } else {
                index++;
            }
        }
        return res;
    }
}
