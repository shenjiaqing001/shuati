/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 5/27/22
 */
public class lc2158 {

    class SegmentTree {
        int val;
        int sum;
        int left, right;
        boolean flag = false;
        SegmentTree leftChild;
        SegmentTree rightChild;

        SegmentTree(int left, int right) {
            this.left = left;
            this.right = right;
            this.val = 0;
            this.sum = 0;
        }

        public void update(int leftBound, int rightBound) {
            if (flag) return;
            if (right < leftBound || left > rightBound) return;
            if (leftBound <= left && right <= rightBound) {
                this.sum = right - left + 1;
                this.flag = true;
                return;
            }
            int mid = left + (right - left) / 2;
            if (this.leftChild == null) {
                this.leftChild = new SegmentTree(left, mid);
                this.rightChild = new SegmentTree(mid + 1, right);
            }
            this.leftChild.update(leftBound, rightBound);
            this.rightChild.update(leftBound, rightBound);
            this.sum = leftChild.sum + rightChild.sum;
        }
    }


    public int[] amountPainted(int[][] paint) {
        SegmentTree root = new SegmentTree(0, 50000);
        int[] res = new int[paint.length];
        int index = 0;
        for (int[] p : paint) {
            int sum = root.sum;
            root.update(p[0], p[1] - 1);
            res[index++] = root.sum - sum;
        }
        return res;
    }
}
