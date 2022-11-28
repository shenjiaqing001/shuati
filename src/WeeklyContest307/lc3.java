package WeeklyContest307;

import java.net.Inet4Address;
import java.util.*;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/20/22
 */
public class lc3 {
    public static class TreeNode {
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


    Map<Integer, TreeNode> map = new HashMap<>();

    public void dfs(TreeNode root) {
        if (root.left != null) {
            map.put(root.left.val, root);
            dfs(root.left);
        }
        if (root.right != null) {
            map.put(root.right.val, root);
            dfs(root.right);
        }
    }

    TreeNode node;

    public void dfsFindNode(TreeNode root, int val) {
        if (root == null) return;
        if (root.val == val) {
            node = root;
        }
        dfsFindNode(root.left, val);
        dfsFindNode(root.right, val);
    }

    public int amountOfTime(TreeNode root, int start) {
        dfsFindNode(root, start);
        dfs(root);
        Set<Integer> set = new HashSet<>();
        Queue<TreeNode> q = new ArrayDeque<>();
        int steps = 0;
        q.add(node);
        set.add(node.val);
        while (true) {
            int size = q.size();
            for (int i = 0; i < size; ++i) {
                TreeNode now = q.poll();
                if (now.left != null) {
                    if (!set.contains(now.left.val)) {
                        set.add(now.left.val);
                        q.add(now.left);
                    }
                }
                if (now.right != null) {
                    if (!set.contains(now.right.val)) {
                        set.add(now.right.val);
                        q.add(now.right);
                    }
                }
                if (map.containsKey(now.val)) {
                    TreeNode tmp = map.get(now.val);
                    if (!set.contains(tmp.val)) {
                        set.add(tmp.val);
                        q.add(tmp);
                    }
                }
            }

            if (q.isEmpty()) {
                break;
            } else {
                steps++;
            }
        }
        return steps;
    }

    public static void main(String[] args) {
        lc3 test = new lc3();


        test.amountOfTime(new TreeNode(1, new TreeNode(5, null,
                        new TreeNode(4, new TreeNode(9), new TreeNode(2))),
                        new TreeNode(3, new TreeNode(10), new TreeNode(6))),
                3);
    }
}
