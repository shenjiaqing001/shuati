package WeeklyContest310;

import z.template.SegmentTree_NodeBase;

import javax.swing.text.Segment;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 9/10/22
 */
public class lc4 {

    class SegmentTree {
        int leftBound;
        int rightBound;
        SegmentTree leftChild;
        SegmentTree rightChild;
        int max;

        SegmentTree(int left, int right) {
            this.leftBound = left;
            this.rightBound = right;
            this.max = 0;
            if (left == right) {
                return;
            } else {
                int mid = left + (right - left) / 2;
                this.leftChild = new SegmentTree(left, mid);
                this.rightChild = new SegmentTree(mid + 1, right);
            }
        }

        void update(int index, int num) {
            if (index < leftBound || index > rightBound) return;
            if (index == leftBound && index == rightBound) {
                this.max = Math.max(this.max, num);
            } else {
                leftChild.update(index, num);
                rightChild.update(index, num);
                this.max = Math.max(leftChild.max, rightChild.max);
            }
        }

        int query(int left, int right) {
            if (left > rightBound || right < leftBound) return -1;
            if (left <= leftBound && rightBound <= right) {
                return this.max;
            } else {
                return Math.max(leftChild.query(left, right), rightChild.query(left, right));
            }
        }

    }

    public int lengthOfLIS(int[] nums, int k) {
        SegmentTree root = new SegmentTree(0, 100000);
        int max = 1;
        for (int num : nums) {
            int size = root.query(Math.max(0, num - k), Math.max(0, num - 1));
            root.update(num, size + 1);
            max = Math.max(max, size + 1);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,5};
        lc4 test = new lc4();
        test.lengthOfLIS(nums, 3);
    }
}
