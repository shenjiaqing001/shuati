import z.template.SegmentTree_NodeBase;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/6/18
 */
public class lc307 {
    class NumArray {
        int[] segmentTree = new int[100000];
        int n = 0;

        void build(int[] nums, int index, int left, int right) {
            if (left == right) {
                segmentTree[index] = nums[left];
                return;
            }
            int mid = (left + right) / 2;

            build(nums, index * 2, left, mid);
            build(nums, index * 2 + 1, mid + 1, right);
            segmentTree[index] = segmentTree[index * 2] + segmentTree[index * 2 + 1];
        }

        void update(int index, int left, int right, int x, int val) {
            if (left == right) {
                segmentTree[index] = val;
                return;
            }

            int mid = (left + right) / 2;
            if (x <= mid) {
                update(index * 2, left, mid, x, val);
            } else {
                update(index * 2 + 1, mid + 1, right, x, val);
            }
            segmentTree[index] = segmentTree[index * 2] + segmentTree[index * 2 + 1];
        }

        int sum(int index, int left, int right, int start, int end) {
            if (left == start && right == end) {
                return segmentTree[index];
            }
            int mid = (left + right) / 2;
            if (end <= mid) {
                return sum(index * 2, left, mid, start, end);
            }
            if (start >= mid + 1) {
                return sum(index * 2 + 1, mid + 1, right, start, end);
            }


            return sum(index * 2, left, mid, start, mid) +
                    sum(index * 2 + 1, mid + 1, right, mid + 1, end);
        }


        public NumArray(int[] nums) {
            n = nums.length - 1;
            build(nums, 1, 0, n);
        }

        public void update(int index, int val) {
            update(1, 0, n, index, val);
        }

        public int sumRange(int left, int right) {
            return sum(1, 0, n, left, right);
        }
    }


    class NumArray2 {

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

        SegmentTree root;

        public NumArray2(int[] nums) {
            int n = nums.length;
            root = new SegmentTree(nums, 0, n - 1);
        }

        public void update(int index, int val) {
            root.update(index, val);
        }

        public int sumRange(int left, int right) {
            return root.sum(left, right);
        }
    }
}
