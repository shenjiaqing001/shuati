package WeeklyContest206;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 9/13/20
 */
public class lc5513 {
    int[] p;

    int get(int x) {
        return p[x] == x ? x : (p[x] = get(p[x]));
    }

    void union(int x, int y) {
        p[get(x)] = p[get(y)];
    }

    public class Line {
        int p1;
        int p2;
        int length;

        Line(int p1, int p2, int length) {
            this.p1 = p1;
            this.p2 = p2;
            this.length = length;
        }
    }

    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        if (n == 1) return 0;
        p = new int[n];
        for (int i = 0; i < n; ++i) p[i] = i;

        Line[] lines = new Line[n * (n - 1) / 2];
        int now = 0;
        for (int i = 0; i < points.length; ++i) {
            for (int j = i + 1; j < points.length; ++j) {
                int dis = Math.abs(points[i][0] - points[j][0]) +
                        Math.abs(points[i][1] - points[j][1]);
                System.out.println(dis);
                lines[now++] = new Line(i, j, dis);
            }
        }
        Arrays.sort(lines, Comparator.comparingInt(o -> o.length));
        int res = 0;
        for (int i = 0; i < lines.length; ++i) {
            if (get(lines[i].p1) != get(lines[i].p2)) {
                union(lines[i].p1, lines[i].p2);
                res += lines[i].length;
            }
        }
        return res;
    }
}
