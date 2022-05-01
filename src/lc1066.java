import java.util.Arrays;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 9/5/20
 */
public class lc1066 {
    int min = Integer.MAX_VALUE;

    public int assignBikes(int[][] workers, int[][] bikes) {
        boolean[] visited = new boolean[bikes.length];
        int n = workers.length;
        int m = bikes.length;
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                dp[i][j] = dis(workers[i], bikes[j]);
            }
        }

        dfs(dp, visited, 0, 0);
        return min;
    }

    public void dfs(int[][] dp, boolean[] visited, int now, int dis) {
        if (now == dp.length) {
            min = Math.min(min, dis);
            return;
        }

        for (int i = 0; i < dp[0].length; ++i) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(dp, visited, now + 1, dis + dp[now][i]);
                visited[i] = false;
            }
        }
    }

    public int dis(int[] worker, int[] bike) {
        return Math.abs(worker[0] - bike[0]) + Math.abs(worker[1] - bike[1]);
    }


    public class KuhnMunkres {
        int nx, ny;
        int INF = Integer.MAX_VALUE;
        int[] match, lx, ly, slack;
        boolean[] visx, visy;
        int[][] G;

        public KuhnMunkres(int left, int right, int[][] G) {
            this.nx = left;
            this.ny = right;
            this.G = G;
            lx = new int[left];
            ly = new int[right];
            slack = new int[right];
            match = new int[right];
        }

        boolean findpath(int x) {
            int tempDelta;
            visx[x] = true;
            for (int y = 0; y < ny; ++y) {
                if (visy[y]) continue;
                tempDelta = lx[x] + ly[y] - G[x][y];
                if (tempDelta == 0) {//(x,y)在相等子图中
                    visy[y] = true;
                    if (match[y] == -1 || findpath(match[y])) {
                        match[y] = x;
                        return true;
                    }
                } else if (slack[y] > tempDelta)
                    slack[y] = tempDelta;//(x,y)不在相等子图中且y不在交错树中
            }
            return false;
        }

        void KM() {
            for (int x = 0; x < nx; ++x) {
                for (int j = 0; j < ny; ++j) slack[j] = INF;//这里不要忘了，每次换新的x结点都要初始化slack
                while (true) {
                    visx = new boolean[nx];
                    visy = new boolean[ny];
                    if (findpath(x)) break;
                    else {
                        int delta = INF;
                        for (int j = 0; j < ny; ++j)//因为dfs(x)失败了所以x一定在交错树中，y不在交错树中，第二类边
                            if (!visy[j] && delta > slack[j])
                                delta = slack[j];
                        for (int i = 0; i < nx; ++i)
                            if (visx[i]) lx[i] -= delta;
                        for (int j = 0; j < ny; ++j) {
                            if (visy[j])
                                ly[j] += delta;
                            else
                                slack[j] -= delta;
                        }
                    }
                }
            }
        }

        int[] solve() {
            Arrays.fill(match, -1);
            for (int i = 0; i < nx; ++i) {
                lx[i] = Integer.MIN_VALUE;
                for (int j = 0; j < ny; ++j)
                    if (lx[i] < G[i][j])
                        lx[i] = G[i][j];
            }
            KM();
            return match;
        }
    }

    public int assignBikes2(int[][] workers, int[][] bikes) {
        // distance worker bike
        int[][] G = new int[workers.length][bikes.length];
        for (int i = 0; i < workers.length; ++i) {
            for (int j = 0; j < bikes.length; ++j) {
                G[i][j] = -Math.abs(workers[i][0] - bikes[j][0]) -
                        Math.abs(workers[i][1] - bikes[j][1]);
            }
        }
        KuhnMunkres km = new KuhnMunkres(workers.length, bikes.length, G);
        int[] match = km.solve();
        int res = 0;
        for (int i = 0; i < match.length; ++i) {
            if(match[i] != -1){
                res += Math.abs(workers[match[i]][0] - bikes[i][0]) + Math.abs(workers[match[i]][1] - bikes[i][1]);
            }
        }
        return res;
    }

}
