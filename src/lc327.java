import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 1/12/22
 */
public class lc327 {
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


    public int countRangeSum(int[] nums, int lower, int upper) {
        Set<Long> set = new HashSet<>();
        long sum = 0;
        for (int num : nums) {
            sum += num;
            set.add(sum);
        }
        set.add(0l);
        Long[] sums = set.toArray(new Long[0]);
        Arrays.sort(sums);
        SegmentTree root = new SegmentTree(sums, 0, sums.length - 1);
        int res = 0;
        sum = 0;
        root.update(0);
        for (int num : nums) {
            sum += num;

            res += root.sum( sum - upper, sum-lower);

            root.update(sum);
        }
        return res;
    }

    //[2147483647,-2147483648,-1,0]
    //-1
    //0
    public static void main(String[] args) {
        lc327 test = new lc327();
        test.countRangeSum(new int[]{2147483647,-2147483648,-1,0}, -1, 0);
    }
}
