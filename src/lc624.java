import java.util.List;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/10/2
 */
public class lc624 {
    public int maxDistance(List<List<Integer>> arrays) {
        int max = arrays.get(0).get(arrays.get(0).size() - 1);
        int min = arrays.get(0).get(0);

        int res = 0;
        for (int i = 1; i < arrays.size(); ++i) {
            res = Math.max(res, Math.abs(max - arrays.get(i).get(0)));
            res = Math.max(res, Math.abs(min - arrays.get(i).get(arrays.get(i).size() - 1)));
            max = Math.max(max, arrays.get(i).get(arrays.get(i).size() - 1));
            min = Math.min(min, arrays.get(i).get(0));
        }
        return res;
    }
}
