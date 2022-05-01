import java.util.ArrayList;
import java.util.List;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 4/11/22
 */
public class lc1260 {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                list.add(grid[i][j]);
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        k %= grid.length * grid[0].length;
        for (int i = list.size() - k; i < list.size(); ++i) {
            tmp.add(list.get(i));
            if (tmp.size() == grid[0].length) {
                res.add(tmp);
                tmp = new ArrayList<>();
            }
        }
        for (int i = 0; i < list.size() - k; ++i) {
            tmp.add(list.get(i));
            if (tmp.size() == grid[0].length) {
                res.add(tmp);
                tmp = new ArrayList<>();
            }
        }
        return res;
    }
}
