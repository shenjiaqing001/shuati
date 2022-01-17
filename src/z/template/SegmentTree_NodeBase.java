package z.template;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 1/12/22
 */
public class SegmentTree_NodeBase {



    class SegmentTree2 {
        long leftBound;
        long rightBound;
        SegmentTree2 leftChild;
        SegmentTree2 rightChild;
        int count = 0;

        SegmentTree2(Long[] nums, int lIndex, int rIndex) {
            if (lIndex == rIndex) {
                this.leftBound = this.rightBound = nums[lIndex];
            } else {
                int mid = lIndex + (rIndex - lIndex) / 2;
                this.leftBound = nums[lIndex];
                this.rightBound = nums[rIndex];
                this.leftChild = new SegmentTree2(nums, lIndex, mid);
                this.rightChild = new SegmentTree2(nums, mid + 1, rIndex);
            }
        }

        int sum(long left, long right) {
            if (left <= leftBound && rightBound <= right) {
                return count;
            } else if (leftBound > right || rightBound < left) {
                return 0;
            } else {
                return leftChild.sum(left, right) + rightChild.sum(left, right);
            }
        }

        void update(long val) {
            if (leftBound == val && rightBound == val) {
                this.count += 1;
            } else if (val >= leftBound && val <= rightBound) {
                leftChild.update(val);
                rightChild.update(val);
                this.count = leftChild.count + rightChild.count;
            }
        }
    }

    class SegmentTree {
        int leftBound;
        int rightBound;
        SegmentTree leftChild;
        SegmentTree rightChild;
        int val;
        int sum = 0;

        SegmentTree(int[] nums, int leftBound, int rightBound) {
            this.leftBound = leftBound;
            this.rightBound = rightBound;
            if (leftBound == rightBound) {
                this.val = nums[leftBound];
                this.sum = nums[leftBound];
            } else {
                int mid = leftBound + (rightBound - leftBound) / 2;
                this.leftChild = new SegmentTree(nums, leftBound, mid);
                this.rightChild = new SegmentTree(nums, mid + 1, rightBound);
                this.sum = this.leftChild.sum + this.rightChild.sum;
            }
        }

        int sum(int left, int right) {
            if (left <= leftBound && rightBound <= right) {
                return sum;
            } else if (leftBound > right || rightBound < left) {
                return 0;
            } else {
                return leftChild.sum(left, right) + rightChild.sum(left, right);
            }
        }

        void update(int index, int val) {
            if (leftBound == index && rightBound == index) {
                this.val = val;
                this.sum = val;
            } else if (index >= leftBound && index <= rightBound) {
                leftChild.update(index, val);
                rightChild.update(index, val);
                this.sum = leftChild.sum + rightChild.sum;
            }
        }
    }
}
