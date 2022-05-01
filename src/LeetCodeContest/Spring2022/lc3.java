package LeetCodeContest.Spring2022;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 4/16/22
 */
public class lc3 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class SegmentTree2 {
        long leftBound;
        long rightBound;
        SegmentTree2 leftChild;
        SegmentTree2 rightChild;
        int count = 0;
        int red = 0;
        boolean lazyFlag = false;

        SegmentTree2(int[] nums, int lIndex, int rIndex) {
            if (lIndex == rIndex) {
                this.leftBound = this.rightBound = nums[lIndex];
                this.count = 1;
            } else {
                int mid = lIndex + (rIndex - lIndex) / 2;
                this.leftBound = nums[lIndex];
                this.rightBound = nums[rIndex];
                this.leftChild = new SegmentTree2(nums, lIndex, mid);
                this.rightChild = new SegmentTree2(nums, mid + 1, rIndex);
                this.count = this.leftChild.count + this.rightChild.count;
            }
        }

        void rangeUpdate(long left, long right, int color) {
            if (left <= leftBound && rightBound <= right) {
                lazyFlag = true;
                if (color == 1) this.red = this.count;
                else this.red = 0;
            } else if (rightBound < left || right < leftBound) {

            } else {
                if (lazyFlag) {
                    this.lazyFlag = false;
                    leftChild.red = Math.min(leftChild.count, this.red);
                    rightChild.red = Math.min(rightChild.count, this.red);
                    leftChild.lazyFlag = true;
                    rightChild.lazyFlag = true;
                }
                leftChild.rangeUpdate(left, right, color);
                rightChild.rangeUpdate(left, right, color);
                this.red = leftChild.red + rightChild.red;
            }
        }
    }

    List<Integer> list = new ArrayList<>();

    public void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);
        list.add(root.val);
        dfs(root.right);
    }

    public int getNumber(TreeNode root, int[][] ops) {
        dfs(root);
        int[] nums = new int[list.size()];
        int index = 0;
        for (int num : list) {
            nums[index++] = num;
        }

        SegmentTree2 r = new SegmentTree2(nums, 0, nums.length - 1);
        for (int[] op : ops) {
            r.rangeUpdate(op[1], op[2], op[0]);
        }
        return r.red;
    }


}
