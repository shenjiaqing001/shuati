import java.util.*;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/9/22
 */
public class lc296 {
    public int minTotalDistance(int[][] grid) {
        List<Integer> listx = new ArrayList<>();
        List<Integer> listy = new ArrayList<>();
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (grid[i][j] == 1) {
                    listx.add(i);
                    listy.add(j);
                }
            }
        }

        listx.sort((o1, o2) -> o1 - o2);
        listy.sort((o1, o2) -> o1 - o2);

        int x = listx.get((listx.size() + 1) / 2-1);
        int y = listy.get((listy.size() + 1) / 2-1);
        // System.out.println(x + " " + y);

        int res = 0;
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (grid[i][j] == 1) {
                    res += Math.abs(x - i);
                    res += Math.abs(y - j);
                }
            }
        }
        return res;
    }
}
