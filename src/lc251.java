/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/1/27
 */
public class lc251 {
    class Vector2D {
        int[][] v;
        int row;
        int col;

        public Vector2D(int[][] v) {
            row = 0;
            col = 0;
            this.v = v;
        }

        public int next() {
            hasNext();
            System.out.println(row + " " + col);
            return v[row][col++];
        }

        public boolean hasNext() {
            while (true) {
                if (row >= v.length) return false;
                if (v[row].length == 0) {
                    row++;
                } else if (col >= v[row].length) {
                    row++;
                    col = 0;
                } else break;
            }
            return true;
        }
    }
}
