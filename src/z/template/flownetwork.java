package z.template;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2/18/22
 */
public class flownetwork {
    FordFulkerson ff = new FordFulkerson(10);

    public class FordFulkerson {
        public class Edge {
            int to, cap, rev;

            Edge(int to, int cap, int rev) {
                this.to = to;
                this.cap = cap;
                this.rev = rev;
            }
        }

        int n;
        List<Edge>[] map;
        boolean[] visited;

        FordFulkerson(int n) {
            this.n = n;
            map = new List[n];
            for (int i = 0; i < n; ++i) {
                map[i] = new ArrayList<>();
            }
        }

        public void addEdge(int u, int v, int flow) {
            map[u].add(new Edge(v, flow, map[v].size()));
            map[v].add(new Edge(u, 0, map[u].size() - 1));
        }

        int dfs(int s, int t, int f) {
            if (s == t) return f;
            visited[s] = true;
            for (Edge edge : map[s]) {
                if (edge.cap > 0 && !visited[edge.to]) {
                    int d = dfs(edge.to, t, Math.min(f, edge.cap));      //两者之间流量较小的一个
                    if (d > 0) {
                        edge.cap -= d;                       //改变正向边和反向边
                        map[edge.to].get(edge.rev).cap += d;
                        return d;
                    }
                }
            }
            return 0;
        }

        int solve(int s, int t) {
            int ans = 0;
            while (true) {
                visited = new boolean[n];
                int d = dfs(s, t, Integer.MAX_VALUE);
                if (d == 0) return ans;
                ans += d;
            }
        }
    }


    public class KuhnMunkres {
        int nx, ny;
        int INF = Integer.MAX_VALUE;
        int[] match, lx, ly, slack;
        boolean[] visx, visy;

        public KuhnMunkres(int left, int right) {
            this.nx = left;
            this.ny = right;
            lx = new int[left];
            ly = new int[right];
            slack = new int[right];
            match = new int[right];
        }

        int[][] G; // G[left][right]

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
                            //修改顶标后，要把所有的slack值都减去delta
                            //这是因为lx[i] 减小了delta
                            //slack[j] = min(lx[i] + ly[j] -w[i][j]) --j不属于交错树--也需要减少delta，第二类边
                        }
                    }
                }
            }
        }

        void solve() {
            Arrays.fill(match, -1);
            for (int i = 0; i < nx; ++i) {
                lx[i] = Integer.MIN_VALUE;
                for (int j = 0; j < ny; ++j)
                    if (lx[i] < G[i][j])
                        lx[i] = G[i][j];
            }
            KM();
        }

//        int main() {
//            while (scanf("%d", & n) !=EOF){
//                nx = ny = n;
//                for (int i = 0; i < nx; ++i)
//                    for (int j = 0; j < ny; ++j)
//                        scanf("%d", & G[i][j]);
//                solve();
//                int ans = 0;
//                for (int i = 0; i < ny; ++i)
//                    if (match[i] != -1)
//                        ans += G[match[i]][i];
//                printf("%d\n", ans);
//            }
//            return 0;
//        }


    }

    public static void main(String[] args) throws IOException {
        flownetwork test = new flownetwork();
        test.ff.addEdge(1, 5, 10);
        test.ff.addEdge(1, 2, 10);
        test.ff.addEdge(2, 5, 10);
        System.out.println(test.ff.solve(1, 5));
        BufferedReader bi = new BufferedReader(new InputStreamReader(System.in));
        String[] s = bi.readLine().split(" ");
    }


}
