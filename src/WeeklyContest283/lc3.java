package WeeklyContest283;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 3/5/22
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

    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> map = new HashMap<>();
        Set<Integer> notRoot = new HashSet<>();
        for (int[] des : descriptions) {
            TreeNode p = new TreeNode(des[0]);
            TreeNode c = new TreeNode(des[1]);
            if (map.containsKey(des[0])) {
                p = map.get(des[0]);
            } else {
                map.put(des[0], p);
            }
            if (map.containsKey(des[1])) {
                c = map.get(des[1]);
            } else {
                map.put(des[1], c);
            }
            if (des[2] == 1) {
                p.left = c;
            } else {
                p.right = c;
            }
            notRoot.add(des[1]);
        }
        int num = -1;
        for(int key : map.keySet()){
            if(!notRoot.contains(key)) num = key;
        }
        return map.get(num);

    }
}
