package WeeklyContest212;

import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/10/25
 */
public class lc1632 {

    int[] p;

    void uf(int n) {
        p = new int[n];
        for (int i = 0; i < n; ++i) {
            p[i] = i;
        }
    }

    int get(int x) {
        return p[x] == x ? x : (p[x] = get(p[x]));
    }

    void union(int x, int y) {
        p[get(x)] = p[get(y)];
    }

    public int[][] matrixRankTransform(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] res = new int[n][m];

        TreeMap<Integer, List<int[]>> map = new TreeMap<>();
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                map.putIfAbsent(matrix[i][j], new LinkedList<>());
                map.get(matrix[i][j]).add(new int[]{i, j});
            }
        }

        int[] rank = new int[m + n], rank2;

        for (int value : map.keySet()) {
            List<int[]> list = map.get(value);
            rank2 = rank.clone();
            uf(m + n); // create union-find

            for (int[] a : list) {
                int i = get(a[0]), j = get(a[1] + n);
                p[i] = j; // union
                rank2[j] = Math.max(rank2[i], rank2[j]); // the parent will store the maximum value.
            }

            for (int[] a : list) {
                int i = a[0], j = a[1], pi = get(i);
                // update rank & A[i][j] with the maximum value of parent + 1 (the next minimum possible rank)
                rank[i] = rank[j + n] = matrix[i][j] = rank2[pi] + 1;
            }
        }

        return matrix;
    }

}
