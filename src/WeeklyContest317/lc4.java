package WeeklyContest317;

import java.util.*;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 10/29/22
 */
public class lc4 {
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


    public int[] treeQueries(TreeNode root, int[] queries) {
        int[] res = new int[queries.length];
        List<Set<TreeNode>> levels = new ArrayList<>();
        Map<TreeNode, TreeNode> map = new HashMap<>();
        Map<TreeNode, Integer> levelMap = new HashMap<>();
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        Set<TreeNode> s = new HashSet<>();
        s.add(root);
        levels.add(s);
        while (!q.isEmpty()) {
            s = new HashSet<>();
            int size = q.size();
            for (int i = 0; i < size; ++i) {
                TreeNode tmp = q.poll();
                if (tmp.left != null) {
                    q.add(tmp.left);
                    s.add(tmp.left);
                    map.put(tmp.left, tmp);
                    levelMap.put(tmp.left, levels.size());
                }
                if (tmp.right != null) {
                    q.add(tmp.right);
                    s.add(tmp.right);
                    map.put(tmp.right, tmp);
                    levelMap.put(tmp.right, levels.size());
                }
            }
            if (!s.isEmpty()) {
                levels.add(s);
            }
        }
        int n = levels.size();
        Set<TreeNode> tmp = levels.get(n - 1);
        while (tmp.size() != 1) {
            Set<TreeNode> newS = new HashSet<>();
            for (TreeNode i : tmp) {
                newS.add(map.get(i));
            }
            tmp = newS;
        }
        TreeNode it = null;
        for (TreeNode i : tmp) {
            it = i;
        }
        Map<Integer, Integer> resMap = new HashMap<>();
        while (map.containsKey(it)) {
            int level = levelMap.get(it);
            Queue<TreeNode> qq = new ArrayDeque<>();
            qq.add(it);
            levels.get(level).remove(it);
            int ll = 1;
            while (!qq.isEmpty()) {
                int size = qq.size();
                for (int i = 0; i < size; ++i) {
                    TreeNode now = qq.poll();
                    if (now.left != null) {
                        if (levels.size() > level + ll &&
                                levels.get(level + ll).contains(now.left)) {
                            levels.get(level + ll).remove(now.left);
                            qq.add(now.left);
                        }
                    }
                    if (now.right != null) {
                        if (levels.size() > level + ll &&
                                levels.get(level + ll).contains(now.right)) {
                            levels.get(level + ll).remove(now.right);
                            qq.add(now.right);
                        }
                    }
                }
                ll++;
            }
            while (levels.get(levels.size() - 1).size() == 0) {
                levels.remove(levels.size() - 1);
            }
            resMap.put(it.val, levels.size() - 1);
            it = map.get(it);
        }
        for (int i = 0; i < queries.length; ++i) {
            if (resMap.containsKey(queries[i])) {
                res[i] = resMap.get(queries[i]);
            } else {
                res[i] = n - 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        lc4 test = new lc4();
        System.out.println(Arrays.toString(
                test.treeQueries(new TreeNode(1, new TreeNode(3, new TreeNode(2), null),
                                new TreeNode(4, new TreeNode(6), new TreeNode(5, new TreeNode(7), null))),
                        new int[]{4,5,7,2})));
    }
}
