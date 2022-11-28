package WeeklyContest311;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 9/17/22
 */
public class lc3 {
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

    public TreeNode reverseOddLevels(TreeNode root) {
        List<List<TreeNode>> levels = new ArrayList();
        List<TreeNode> first = new ArrayList<>();
        first.add(root);
        levels.add(first);
        while (levels.get(levels.size() - 1).get(0).left != null) {
            List<TreeNode> now = levels.get(levels.size() - 1);
            List<TreeNode> next = new ArrayList<>();
            for (TreeNode node : now) {
                next.add(node.left);
                next.add(node.right);
            }
            levels.add(next);
        }
        for (int i = 1; i < levels.size(); i += 2) {
            Collections.reverse(levels.get(i));
        }
        for (int i = 0; i < levels.size() - 1; ++i) {
            for (int j = 0; j < levels.get(i).size(); ++j) {
                levels.get(i).get(j).left = levels.get(i + 1).get(2 * j);
                levels.get(i).get(j).right = levels.get(i + 1).get(2 * j + 1);
            }
        }
        return levels.get(0).get(0);
    }
}
