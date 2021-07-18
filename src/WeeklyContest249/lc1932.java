package WeeklyContest249;

import java.util.*;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/7/10
 */
public class lc1932 {
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


    public TreeNode canMerge(List<TreeNode> trees) {
        Map<Integer, TreeNode> map = new HashMap<>();
        Map<Integer, TreeNode> leftFa = new HashMap<>();
        Map<Integer, TreeNode> rightFa = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        Set<Integer> valSet = new HashSet<>();

        for (TreeNode treeNode : trees) {
            valSet.add(treeNode.val);
            if (leftFa.containsKey(treeNode.val)) {
                TreeNode fa = leftFa.get(treeNode.val);
                fa.left = treeNode;
                map.remove(treeNode.val);
            } else if (rightFa.containsKey(treeNode.val)) {
                TreeNode fa = rightFa.get(treeNode.val);
                fa.right = treeNode;
                map.remove(treeNode.val);
            } else {
                map.put(treeNode.val, treeNode);
            }

            if (treeNode.left != null) {
                valSet.add(treeNode.left.val);
                if (set.contains(treeNode.left.val)) return null;
                set.add(treeNode.left.val);
                if (map.containsKey(treeNode.left.val)) {
                    treeNode.left = map.get(treeNode.left.val);
                    map.remove(treeNode.left.val);
                } else {
                    leftFa.put(treeNode.left.val, treeNode);
                }
            }

            if (treeNode.right != null) {
                valSet.add(treeNode.right.val);
                if (set.contains(treeNode.right.val)) return null;
                set.add(treeNode.right.val);
                if (map.containsKey(treeNode.right.val)) {
                    treeNode.right = map.get(treeNode.right.val);
                    map.remove(treeNode.right.val);
                } else {
                    rightFa.put(treeNode.right.val, treeNode);
                }
            }
        }

        if (map.size() > 1) return null;
        TreeNode res = null;
        for (Integer key : map.keySet()) res = map.get(key);
        if (!isValid(res, 0, 50001, valSet)) return null;
        if (valSet.size() > 0) return null;
        return res;
    }

    public boolean isValid(TreeNode node, int left, int right, Set<Integer> set) {
        if (node == null) return true;
        if (node.val < left || node.val > right) return false;
        if (!set.contains(node.val)) return false;
        set.remove(node.val);
        return isValid(node.left, left, node.val - 1, set) &&
                isValid(node.right, node.val + 1, right, set);
    }

    public static void main(String[] args) {
        lc1932 test = new lc1932();
        TreeNode t1 = new TreeNode(1);

        TreeNode t3 = new TreeNode(3);
        TreeNode t2 = new TreeNode(2, t1, t3);
        List<TreeNode> list = new ArrayList<>();
        list.add(t2);
        System.out.println(test.canMerge(list));
    }
}
