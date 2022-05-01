import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 1/12/22
 */
public class lc493 {
    class SegmentTree {
        long leftBound;
        long rightBound;
        SegmentTree leftChild;
        SegmentTree rightChild;
        int count = 0;

        SegmentTree(Long[] nums, int lIndex, int rIndex) {
            if (lIndex == rIndex) {
                this.leftBound = this.rightBound = nums[lIndex];
            } else {
                int mid = lIndex + (rIndex - lIndex) / 2;
                this.leftBound = nums[lIndex];
                this.rightBound = nums[rIndex];
                this.leftChild = new SegmentTree(nums, lIndex, mid);
                this.rightChild = new SegmentTree(nums, mid + 1, rIndex);
            }
        }

        int sum(long left, long right) {
            if (right < left) return 0;
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
                this.count += 1;
            }
        }
    }

    public int reversePairs(int[] nums) {
        Set<Long> set = new HashSet<>();
        for (int num : nums) set.add((long) num);
        Long[] tmp = set.toArray(new Long[0]);
        Arrays.sort(tmp);
        SegmentTree root = new SegmentTree(tmp, 0, tmp.length - 1);
        int res = 0;
        for (int i = nums.length - 1; i >= 0; --i) {
            int upper = nums[i] > 0 ? (nums[i] - 1) / 2 : nums[i] / 2 - 1;
            res += root.sum(tmp[0], upper);
            root.update(nums[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        lc493 test = new lc493();
        test.reversePairs(new int[]{1, 3, 2, 3, 1});
    }
}
