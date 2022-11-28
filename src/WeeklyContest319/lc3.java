package WeeklyContest319;

import WeeklyContest204.lc4;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 11/12/22
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

    public class UnionFind {
        int[] p;

        public UnionFind(int n) {
            p = new int[n];
            for (int i = 0; i < n; ++i) p[i] = i;
        }

        public int get(int x) {
            return p[x] == x ? x : (p[x] = get(p[x]));
        }

        public void union(int x, int y) {
            int a = get(x);
            int b = get(y);
            if (p[a] < p[b]) p[b] = p[a];
            else p[a] = p[b];
        }
    }

    public int minimumOperations(TreeNode root) {
        int res = 0;
        Queue<TreeNode> q = new ArrayDeque<>();

        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            int[][] arr = new int[size][2];
            for (int i = 0; i < size; i++) {
                arr[i][0] = i;
                TreeNode now = q.poll();
                arr[i][1] = now.val;
                if (now.left != null) q.add(now.left);
                if (now.right != null) q.add(now.right);
            }
            Arrays.sort(arr, (o1, o2) -> (o1[1] - o2[1]));
            UnionFind uf = new UnionFind(arr.length);
            for (int i = 0; i < arr.length; i++) {
                if (uf.get(i) != uf.get(arr[i][0])) {
                    uf.union(i, arr[i][0]);
                    res++;
                }
            }

        }
        return res;
    }
}
