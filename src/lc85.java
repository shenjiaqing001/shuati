/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 7/23/20
 */
public class lc85 {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return 0;
        int row = matrix.length;
        int column = matrix[0].length;

        int[][] top = new int[row][column];
        int[][] left = new int[row][column];
        int max = 0;
        if (matrix[0][0] == '1') {
            top[0][0] = 1;
            left[0][0] = 1;
            max = 1;
        }
        for (int i = 1; i < row; ++i) {
            if (matrix[i][0] == '1') {
                top[i][0] = top[i - 1][0] + 1;
                left[i][0] = 1;
                max = Math.max(max, top[i][0]);
            }
        }

        for (int i = 1; i < column; ++i) {
            if (matrix[0][i] == '1') {
                left[0][i] = left[0][i - 1] + 1;
                top[0][i] = 1;
                max = Math.max(max, left[0][i]);
            }
        }

        for (int i = 1; i < row; ++i) {
            for (int j = 1; j < column; ++j) {
                if (matrix[i][j] == '1') {
                    left[i][j] = left[i][j - 1] + 1;
                    top[i][j] = top[i - 1][j] + 1;
                    int tmpMax = Math.max(left[i][j], top[i][j]);
                    max = Math.max(max, tmpMax);
                    if (left[i][j] > 1 && top[i][j] > 1) {
                        int tmp = top[i][j];
                        int minLeft = left[i][j];
                        for (int k = i - 1; k >= i - tmp + 1; --k) {
                            minLeft = Math.min(minLeft, left[k][j]);
                            tmpMax = Math.max(tmpMax, minLeft * (i - k + 1));
                        }
                        max = Math.max(max, tmpMax);
                    }
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        lc85 t = new lc85();
        char[][] matrix = new char[][]{
                {'1', '0', '1', '1', '1'},
                {'0', '1', '0', '1', '0'},
                {'1', '1', '0', '1', '1'},
                {'1', '1', '0', '1', '1'},
                {'0', '1', '1', '1', '1'}};

        System.out.println(t.maximalRectangle(matrix));
    }
}
