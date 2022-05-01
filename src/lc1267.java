/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 1/20/22
 */
public class lc1267 {
    public int countServers(int[][] grid) {
        int[] col = new int[251];
        int[] row = new int[251];
        int count = 0;
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (grid[i][j] == 1) {
                    row[i]++;
                    col[j]++;
                    count++;
                }
            }
        }
        int not = 0;
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (grid[i][j] == 1 && row[i] == 1 && col[j] == 1) {
                    not++;
                }
            }
        }
        return count - not;
    }
}
