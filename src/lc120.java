import java.util.List;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 7/29/20
 */
public class lc120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        for (int i = triangle.size() - 2; i >= 0; --i) {
            for (int j = 0; j < triangle.get(i).size(); ++j) {
                triangle.get(i).set(j, triangle.get(i).get(j) +
                        Math.min(triangle.get(i + 1).get(j),
                                triangle.get(i + 1).get(j + 1)));

            }
        }
        return triangle.get(0).get(0);
    }
}
