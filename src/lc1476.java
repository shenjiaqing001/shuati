/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/2/3
 */
public class lc1476 {
    class SubrectangleQueries {
        int[][] rectangle = null;

        public SubrectangleQueries(int[][] rectangle) {
            this.rectangle = rectangle;
        }

        public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
            for (int i = row1; i <= row2; ++i) {
                for (int j = col1; j <= col2; ++j) {
                    rectangle[i][j] = newValue;
                }
            }
        }

        public int getValue(int row, int col) {
            return rectangle[row][col];
        }
    }
}
