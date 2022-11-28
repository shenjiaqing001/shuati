package WeeklyContest320;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 11/19/22
 */
public class lc2 {
    public class TreeNode {
        int val;
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

    public void dfs(TreeNode root, TreeSet<Integer> set) {
        if (root == null) return;
        set.add(root.val);
        dfs(root.left, set);
        dfs(root.right, set);
    }

    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        TreeSet<Integer> set = new TreeSet<>();
        dfs(root, set);
        List<List<Integer>> res = new ArrayList<>();
        for (int num : queries) {
            Integer ceiling = set.ceiling(num);
            Integer floor = set.floor(num);
            List<Integer> tmp = new ArrayList<>();
            if (floor == null) tmp.add(-1);
            else tmp.add(floor);
            if (ceiling == null) tmp.add(-1);
            else tmp.add(ceiling);
            res.add(tmp);
        }
        return res;
    }
}
