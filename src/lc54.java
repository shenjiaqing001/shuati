import java.util.LinkedList;
import java.util.List;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/9/16
 */
public class lc54 {

    public List<Integer> spiralOrder(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dir = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int dirIndex = 0;
        int x = 0, y = 0;
        List<Integer> res = new LinkedList<>();
        while (true) {
            res.add(matrix[x][y]);
            matrix[x][y] = 0;
            if (res.size() == n * m) break;
            if (x + dir[dirIndex][0] < 0 || x + dir[dirIndex][0] >= n ||
                    y + dir[dirIndex][1] < 0 || y + dir[dirIndex][1] >= m ||
                    matrix[x + dir[dirIndex][0]][y + dir[dirIndex][1]] == 0) {
                dirIndex++;
                if (dirIndex == 4) dirIndex = 0;
            }
            x += dir[dirIndex][0];
            y += dir[dirIndex][1];
        }
        return res;
    }
}
