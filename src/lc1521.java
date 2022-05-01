import org.w3c.dom.ls.LSOutput;
import z.template.SegmentTree_NodeBase;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 1/12/22
 */
public class lc1521 {
    class SegmentTree {
        int leftBound;
        int rightBound;
        SegmentTree leftChild;
        SegmentTree rightChild;
        int and = 0;

        SegmentTree(int[] nums, int leftBound, int rightBound) {
            this.leftBound = leftBound;
            this.rightBound = rightBound;
            if (leftBound == rightBound) {
                this.and = nums[leftBound];
            } else {
                int mid = leftBound + (rightBound - leftBound) / 2;
                this.leftChild = new SegmentTree(nums, leftBound, mid);
                this.rightChild = new SegmentTree(nums, mid + 1, rightBound);
                this.and = this.leftChild.and & this.rightChild.and;
            }
        }

        int getAnd(int left, int right) {
            if (left <= leftBound && rightBound <= right) {
                return and;
            } else if (leftBound > right || rightBound < left) {
                return Integer.MAX_VALUE;
            } else {
                return leftChild.getAnd(left, right) & rightChild.getAnd(left, right);
            }
        }
    }


    // target 5
    int binarySearch(SegmentTree root, int right, int target) {
        int lo = 0;
        int hi = right;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (root.getAnd(mid, right) < target) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    public int closestToTarget(int[] arr, int target) {
        SegmentTree root = new SegmentTree(arr, 0, arr.length - 1);

        int and = Integer.MAX_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; ++i) {
            and &= arr[i];
            if (arr[i] <= target) {
                min = Math.min(min, target - arr[i]);
            } else {
                int index = binarySearch(root, i, target);
                min = Math.min(min, Math.abs(target - root.getAnd(index, i)));
                if (index - 1 >= 0) {
                    min = Math.min(min, Math.abs(target - root.getAnd(index - 1, i)));
                }
            }
        }
        return min;
    }

    public static void main(String[] args) {
        lc1521 test = new lc1521();
        test.closestToTarget(new int[]{1000000, 1000000, 1000000}, 1);
    }
}
