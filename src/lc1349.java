import java.util.ArrayList;
import java.util.List;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2/18/22
 */
public class lc1349 {
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


    public int maxStudents(char[][] seats) {
        int n = seats.length;
        int m = seats[0].length;
        FordFulkerson ff = new FordFulkerson(n * m + 2);
        int index = 1;
        int[][] map = new int[n][m];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (seats[i][j] == '.') {
                    map[i][j] = index;
                    if (j % 2 == 0) {
                        ff.addEdge(index, n * m + 1, 1);
                    } else {
                        ff.addEdge(0, index, 1);
                    }
                    index++;
                }
            }
        }
        int total = index - 1;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (seats[i][j] == '.') {
                    if (j % 2 == 1) {
                        for (int x = -1; x <= 1; ++x) {
                            for (int y = -1; y <= 1; y += 2) {
                                if (x == 0 && y == 0) continue;
                                if (i + x < 0 || i + x >= n || j + y < 0 || j + y >= m) continue;
                                if (seats[i + x][j + y] != '.') continue;
                                ff.addEdge(map[i][j], map[i + x][j + y], 1);
                            }
                        }
                    }
                }
            }
        }
        return total - ff.solve(0, n * m + 1);
    }

    class Hungarian {
        int left, right;
        boolean[][] map;
        int[] p; //right //记录当前右侧元素所对应的左侧元素
        boolean[] vis; // right //记录右侧元素是否已被访问过

        Hungarian(int left, int right) {
            this.left = left;
            this.right = right;
            map = new boolean[left][right];
            p = new int[right];
        }

        void addEdge(int i, int j) {
            map[i][j] = true;
        }

        boolean match(int i) {
            for (int j = 0; j < right; ++j)
                if (map[i][j] && !vis[j]) //有边且未访问
                {
                    vis[j] = true;                 //记录状态为访问过
                    if (p[j] == 0 || match(p[j])) //如果暂无匹配，或者原来匹配的左侧元素可以找到新的匹配
                    {
                        p[j] = i;    //当前左侧元素成为当前右侧元素的新匹配
                        return true; //返回匹配成功
                    }
                }
            return false; //循环结束，仍未找到匹配，返回匹配失败
        }

        int solve() {
            int res = 0;
            for (int i = 0; i < left; ++i) {
                vis = new boolean[right];
                if (match(i))
                    res++;
            }
            return res;
        }
    }

    public int maxStudents2(char[][] seats) {
        int n = seats.length;
        int m = seats[0].length;
        int[][] map = new int[n][m];
        int left = 1;
        int right = 1;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (seats[i][j] == '.') {
                    if (j % 2 == 0) {
                        map[i][j] = right++;
                    } else {
                        map[i][j] = left++;
                    }
                }
            }
        }
        Hungarian hungarian = new Hungarian(left, right);
        int total = left + right - 2;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (seats[i][j] == '.') {
                    if (j % 2 == 1) {
                        for (int x = -1; x <= 1; ++x) {
                            for (int y = -1; y <= 1; y += 2) {
                                if (x == 0 && y == 0) continue;
                                if (i + x < 0 || i + x >= n || j + y < 0 || j + y >= m) continue;
                                if (seats[i + x][j + y] != '.') continue;
                                hungarian.addEdge(map[i][j], map[i + x][j + y]);
                            }
                        }
                    }
                }
            }
        }
        return total - hungarian.solve();
    }


    public static void main(String[] args) {
        lc1349 test = new lc1349();
        test.maxStudents(new char[][]{{'#', '.', '#'}, {'#', '#', '.'}, {'.', '#', '.'}});
    }
}
