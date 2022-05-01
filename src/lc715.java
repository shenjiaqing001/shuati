/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 1/13/22
 */
public class lc715 {

    class SegmentTree {
        int leftBound;
        int rightBound;
        boolean flag = false;
        SegmentTree leftChild;
        SegmentTree rightChild;
        boolean lazy = false;

        SegmentTree(int leftBound, int rightBound) {
            this.leftBound = leftBound;
            this.rightBound = rightBound;
        }

        SegmentTree(int leftBound, int rightBound, boolean flag) {
            this.leftBound = leftBound;
            this.rightBound = rightBound;
            this.rangeUpdate(leftBound, rightBound, flag);
        }


        void rangeUpdate(int left, int right, boolean flag) {
            if (left <= leftBound && rightBound <= right) {
                this.flag = flag;
                this.lazy = true;
            } else if (rightBound < left || right < leftBound) {

            } else {
                if (leftChild == null) {
                    int mid = leftBound + (rightBound - leftBound) / 2;
                    leftChild = new SegmentTree(leftBound, mid, this.flag);
                    rightChild = new SegmentTree(mid + 1, rightBound, this.flag);
                }
                if (lazy) {
                    leftChild.lazy = true;
                    rightChild.lazy = true;
                    leftChild.flag = this.flag;
                    rightChild.flag = this.flag;
                    this.lazy = false;
                }
                leftChild.rangeUpdate(left, right, flag);
                rightChild.rangeUpdate(left, right, flag);
                this.flag = leftChild.flag & rightChild.flag;
            }
        }

        boolean query(int left, int right) {
            if (left <= leftBound && rightBound <= right) {
                return this.flag;
            } else if (rightBound < left || right < leftBound) {
                return true;
            } else {
                if (this.flag) return true;
                if (this.lazy) return false;
                if (leftChild == null || rightChild == null) return false;
                else return leftChild.query(left, right) & rightChild.query(left, right);
            }
        }
    }


    class RangeModule {

        SegmentTree root = new SegmentTree(1, 1_000_000_000);

        public RangeModule() {

        }

        public void addRange(int left, int right) {
            root.rangeUpdate(left, right - 1, true);
        }

        public boolean queryRange(int left, int right) {
            return root.query(left, right - 1);
        }

        public void removeRange(int left, int right) {
            root.rangeUpdate(left, right - 1, false);
        }
    }

    RangeModule rm = new RangeModule();

    public static void main(String[] args) {
        lc715 test = new lc715();
        test.rm.addRange(10, 20);
        test.rm.queryRange(10, 11);
        System.out.println(11);
    }

}
