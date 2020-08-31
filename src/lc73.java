/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 7/21/20
 */
public class lc73 {
    public void setZeroes(int[][] matrix) {
        if (matrix.length == 0) return;
        int row = matrix.length;
        int column = matrix[0].length;


        boolean[] rows = new boolean[row];
        boolean[] columns = new boolean[column];

        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < column; ++j) {
                if (matrix[i][j] == 0) {
                    rows[i] = true;
                    columns[j] = true;
                }
            }
        }
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < column; ++j) {
                if (rows[i] == true || columns[j] == true)
                    matrix[i][j] = 0;
            }
        }
    }
}
