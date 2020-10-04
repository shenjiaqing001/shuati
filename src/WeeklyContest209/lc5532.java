package WeeklyContest209;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/10/4
 */
public class lc5532 {
    public class TreeNode {
        Integer val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean isEvenOddTree(TreeNode root) {
        if (root == null) return true;
        int level = 1;
        ArrayList<TreeNode> list = new ArrayList<>();
        list.add(root);
        while (!list.isEmpty()) {
            ArrayList<TreeNode> next = new ArrayList<>();
            if (level % 2 == 1) {
                int first = Integer.MIN_VALUE;
                for (int i = 0; i < list.size(); ++i) {
                    if (list.get(i).val % 2 == 0) return false;
                    if (list.get(i).val <= first) return false;
                    if (list.get(i).left != null) next.add(list.get(i).left);
                    if (list.get(i).right != null) next.add(list.get(i).right);
                    first = list.get(i).val;
                }
            } else {
                int first = Integer.MAX_VALUE;
                for (int i = 0; i < list.size(); ++i) {
                    if (list.get(i).val % 2 == 1) return false;
                    if (list.get(i).val >= first) return false;
                    if (list.get(i).left != null) next.add(list.get(i).left);
                    if (list.get(i).right != null) next.add(list.get(i).right);
                    first = list.get(i).val;
                }
            }
            list = next;
            level++;
        }
        return true;
    }


}
