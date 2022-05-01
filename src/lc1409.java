import java.util.ArrayList;
import java.util.List;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 1/17/22
 */
public class lc1409 {
    public int[] processQueries(int[] queries, int m) {
        int[] res = new int[queries.length];
        int index = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= m; ++i) {
            list.add(i);
        }
        for (int q : queries) {
            int tmp = list.indexOf(q);
            list.remove(tmp);
            list.add(0, q);
            res[index++] = tmp;
        }
        return res;
    }
}
