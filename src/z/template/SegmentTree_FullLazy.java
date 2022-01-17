package z.template;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 1/14/22
 */
public class SegmentTree_FullLazy {

    int leftBound;
    int rightBound;
    boolean flag = false;
    SegmentTree_FullLazy leftChild;
    SegmentTree_FullLazy rightChild;
    boolean lazy = false;

    SegmentTree_FullLazy(int leftBound, int rightBound) {
        this.leftBound = leftBound;
        this.rightBound = rightBound;
    }

    SegmentTree_FullLazy(int leftBound, int rightBound, boolean flag) {
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
                leftChild = new SegmentTree_FullLazy(leftBound, mid, this.flag);
                rightChild = new SegmentTree_FullLazy(mid + 1, rightBound, this.flag);
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
