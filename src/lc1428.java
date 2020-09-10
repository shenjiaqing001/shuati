import java.util.List;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 9/11/20
 */
public class lc1428 {
    interface BinaryMatrix {
        public int get(int row, int col);

        public List<Integer> dimensions();
    }


    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        List<Integer> dimen = binaryMatrix.dimensions();
        int rows = dimen.get(0);
        int columns = dimen.get(1);
        int x = 0;
        int y = columns - 1;
        int res = -1;
        while (x < rows && y >= 0) {
            if (binaryMatrix.get(x, y) == 1) {
                res = y;
                y--;
            } else {
                x++;
            }
        }
        return res;
    }
}
