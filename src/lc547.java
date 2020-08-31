/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/31/20
 */
public class lc547 {
    int[] p;
    boolean[] flag;

    public int find(int x) {
        return p[x] == x ? x : (p[x] = find(p[x]));
    }

    public void union(int x, int y) {
        p[find(x)] = p[find(y)];
    }


    public int findCircleNum(int[][] M) {
        flag = new boolean[M.length];
        p = new int[M.length];
        int res = 0;
        for (int i = 0; i < M.length; ++i) {
            if (flag[i] == false) {
                flag[i] = true;
                dfs(i, M);
                res++;
            }
        }
        return res;
    }

    public void dfs(int x, int[][] M) {
        for (int i = 0; i < M.length; ++i) {
            if (i == x || flag[i] == true) continue;
            if (M[x][i] == 1) {
                union(x, i);
                flag[i] = true;
                dfs(i, M);
            }
        }
    }
}
