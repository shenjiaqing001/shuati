import javax.swing.text.Segment;
import java.util.*;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 1/12/22
 */
public class lc699 {
    class SegmentTree2 {
        long leftBound;
        long rightBound;
        SegmentTree2 leftChild;
        SegmentTree2 rightChild;
        int max = 0;
        boolean lazyFlag = false;

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

        int max(long left, long right) {
            if (left <= leftBound && rightBound <= right) {
                return max;
            } else if (rightBound < left || right < leftBound) {
                return 0;
            } else {
                if (lazyFlag) {
                    leftChild.max = this.max;
                    rightChild.max = this.max;
                    leftChild.lazyFlag = true;
                    rightChild.lazyFlag = true;
                    lazyFlag = false;
                }
                return Math.max(leftChild.max(left, right), rightChild.max(left, right));
            }
        }

        void rangeUpdate(long left, long right, int max) {
            if (left <= leftBound && rightBound <= right) {
                lazyFlag = true;
                this.max = max;
            } else if (rightBound < left || right < leftBound) {

            } else {
                if (lazyFlag) {
                    leftChild.max = this.max;
                    rightChild.max = this.max;
                    leftChild.lazyFlag = true;
                    rightChild.lazyFlag = true;
                }
                leftChild.rangeUpdate(left, right, max);
                rightChild.rangeUpdate(left, right, max);
                this.max = Math.max(leftChild.max, rightChild.max);
            }
        }
    }


    public List<Integer> fallingSquares(int[][] positions) {
        Set<Long> set = new HashSet<>();
        for (int[] pos : positions) {
            set.add((long) pos[0]);
            set.add((long) (pos[1] + pos[0] - 1));
        }
        Long[] tmps = set.toArray(new Long[0]);
        Arrays.sort(tmps);
        SegmentTree2 root = new SegmentTree2(tmps, 0, tmps.length - 1);
        List<Integer> res = new ArrayList<>();
        for (int[] position : positions) {
            int max = root.max(position[0], position[0] + position[1] - 1);
            root.rangeUpdate(position[0], position[0] + position[1] - 1, max + position[1]);
            res.add(root.max);
        }
        return res;
    }

    public static void main(String[] args) {
        lc699 test = new lc699();
        test.fallingSquares(new int[][]{{3, 2}, {9, 8}, {4, 4}});
    }
}
