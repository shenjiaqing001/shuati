import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/1/25
 */
public class lc254 {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> res = new LinkedList<>();

        getFactor(res, new LinkedList<>(), n, 2);

        return res;
    }

    public void getFactor(List<List<Integer>> res, List<Integer> now, int n, int k) {
        if (n != 1 && now.size() > 0) {
            List<Integer> tmp = new ArrayList<>(now);
            tmp.add(n);
            res.add(tmp);
        }
        for (int i = k; i <= Math.sqrt(n); ++i) {
            if (n % i == 0) {
                now.add(i);
                getFactor(res, now, n / i, i);
                now.remove(now.size() - 1);
            }
        }
    }
}
