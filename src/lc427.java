/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/9/25
 */
public class lc427 {
    class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;


        public Node() {
            this.val = false;
            this.isLeaf = false;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft,
                    Node bottomRight) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = topLeft;
            this.topRight = topRight;
            this.bottomLeft = bottomLeft;
            this.bottomRight = bottomRight;
        }
    }

    public Node construct(int[][] grid) {
        int n = grid.length;
        Node res = helper(grid, 0, 0, n);
        return res;
    }

    public Node helper(int[][] grid, int x, int y, int length) {
        if (length == 1) {
            if (grid[x][y] == 1) return new Node(true, true);
            else return new Node(false, true);
        }
        int sum = 0;
        for (int i = x; i < x + length; ++i) {
            for (int j = y; j < y + length; ++j) {
                sum += grid[i][j];
            }
        }
        if (sum == 0) return new Node(false, true);
        if (sum == length * length) return new Node(true, true);
        return new Node(true, false,
                helper(grid, x, y, length / 2),
                helper(grid, x, y + length / 2, length / 2),
                helper(grid, x + length / 2, y, length / 2),
                helper(grid, x + length / 2, y + length / 2, length / 2));
    }
}
