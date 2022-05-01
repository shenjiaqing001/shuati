/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 1/14/22
 */
public class lc308 {
    class QuadTree {
        int left = -1, right = -1, top = -1, down = -1;
        QuadTree topLeftChild, topRightChild, downLeftChild, downRightChild;
        int sum = 0;

        QuadTree() {
        }

        QuadTree(int[][] matrix, int top, int down, int left, int right) {
            if (left > right || top > down) return;
            this.top = top;
            this.down = down;
            this.left = left;
            this.right = right;
            if (left == right && top == down) {
                this.sum = matrix[top][left];
            } else {
                int verMid = top + (down - top) / 2;
                int horMid = left + (right - left) / 2;
                topLeftChild = new QuadTree(matrix, top, verMid, left, horMid);
                topRightChild = new QuadTree(matrix, top, verMid, horMid + 1, right);
                downLeftChild = new QuadTree(matrix, verMid + 1, down, left, horMid);
                downRightChild = new QuadTree(matrix, verMid + 1, down, horMid + 1, right);
                this.sum = downLeftChild.sum + downRightChild.sum +
                        topLeftChild.sum + topRightChild.sum;
            }
        }

        void update(int row, int col, int val) {
            if (left == -1) return;
            if (row < top || row > down || col < left || col > right) return;
            if (top == down && left == right) {
                this.sum = val;
            } else {
                topLeftChild.update(row, col, val);
                topRightChild.update(row, col, val);
                downLeftChild.update(row, col, val);
                downRightChild.update(row, col, val);
                this.sum = downLeftChild.sum + downRightChild.sum +
                        topLeftChild.sum + topRightChild.sum;
            }
        }

        int getSum(int row1, int col1, int row2, int col2) {
            if (left == -1) return 0;
            if (col1 <= left && right <= col2 && row1 <= top && down <= row2) {
                return this.sum;
            } else if (right < col1 || left > col2 || top > row2 || down < row1) {
                return 0;
            } else {
                return topLeftChild.getSum(row1, col1, row2, col2) +
                        topRightChild.getSum(row1, col1, row2, col2) +
                        downLeftChild.getSum(row1, col1, row2, col2) +
                        downRightChild.getSum(row1, col1, row2, col2);
            }
        }
    }

    class NumMatrix {
        QuadTree quadTree;

        public NumMatrix(int[][] matrix) {
            quadTree = new QuadTree(matrix, 0, matrix.length - 1, 0, matrix[0].length - 1);
        }

        public void update(int row, int col, int val) {
            quadTree.update(row, col, val);
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            return quadTree.getSum(row1, col1, row2, col2);
        }
    }


    NumMatrix nm = new NumMatrix(
            new int[][]{{3, 0, 1, 4, 2}, {5, 6, 3, 2, 1}, {1, 2, 0, 1, 5}, {4, 1, 0, 1, 7}, {1, 0, 3, 0, 5}});

    public static void main(String[] args) {
        lc308 test = new lc308();
        test.nm.sumRegion(2, 1, 4, 3);
    }
}
