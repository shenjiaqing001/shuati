package WeeklyContest250;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/7/17
 */
public class lc1938 {
    class Trie {
        Trie[] children;
        int count;

        public Trie() {
            children = new Trie[2];
            count = 0;
        }
    }

    class TreeNode {
        int num;
        List<TreeNode> chilren = new LinkedList<>();

        public TreeNode(int num) {
            this.num = num;
        }
    }

    Trie root = new Trie();

    public void addNum(int num, int plus) {
        Trie curNode = root;
        for (int i = 17; i >= 0; i--) {
            int curBit = (num >>> i) & 1;
            if (curNode.children[curBit] == null) {
                curNode.children[curBit] = new Trie();
            }
            curNode = curNode.children[curBit];
            curNode.count += plus;
        }
    }

    int treeRoot = -1;
    Map<Integer, TreeNode> map = new HashMap<>();
    Map<Integer, List<int[]>> queryMap = new HashMap<>();
    int[] res;

    public int[] maxGeneticDifference(int[] parents, int[][] queries) {
        int n = queries.length;
        res = new int[n];
        for (int i = 0; i < parents.length; ++i) {
            if (parents[i] == -1) treeRoot = i;
            map.put(i, new TreeNode(i));
        }

        for (int i = 0; i < parents.length; ++i) {
            if (parents[i] == -1) continue;
            TreeNode fa = map.get(parents[i]);
            fa.chilren.add(map.get(i));
        }

        for (int i = 0; i < queries.length; ++i) {
            int index = queries[i][0];
            queryMap.putIfAbsent(index, new LinkedList<>());
            queryMap.get(index).add(new int[]{i, queries[i][1]});
        }

        dfs(map.get(treeRoot));

        return res;
    }

    public void dfs(TreeNode root) {
        if (root == null) return;
        addNum(root.num, 1);
        if (queryMap.containsKey(root.num)) {
            for (int[] query : queryMap.get(root.num)) {
                int ans = max_ans(query[1]);
                res[query[0]] = ans;
            }
        }
        if (root.chilren.size() > 0) {
            for (TreeNode node : root.chilren) {
                dfs(node);
            }
        }
        addNum(root.num, -1);
    }


    public int max_ans(int num) {
        Trie curNode = root;
        int curSum = 0;
        for (int i = 17; i >= 0; i--) {
            int curBit = (num >>> i) & 1;
            if (curNode == null || curNode.children == null)
                break;
            if (curNode.children[curBit ^ 1] != null && curNode.children[curBit ^ 1].count > 0) {
                curSum += (1 << i);
                curNode = curNode.children[curBit ^ 1];
            } else {
                curNode = curNode.children[curBit];
            }
        }
        return curSum;
    }

    public static void main(String[] args) {
        lc1938 test = new lc1938();
        test.maxGeneticDifference(new int[]{-1, 0, 1, 1}, new int[][]{{0, 2}});
    }
}
