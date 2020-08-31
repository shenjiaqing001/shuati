/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/21/20
 */
public class lc240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) return false;
        int x = 0;
        int y = matrix[0].length - 1;
        while (true) {
            if (matrix[x][y] == target) return true;
            if (matrix[x][y] > target) {
                y--;
                if (y < 0) return false;
            } else {
                x++;
                if (x >= matrix.length) return false;
            }
        }
    }
}
