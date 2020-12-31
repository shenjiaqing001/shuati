package WeeklyContest220;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/12/31
 */
public class lc1697 {
    int[] p;

    int get(int x) {
        return p[x] == x ? x : (p[x] = get(p[x]));
    }

    void union(int x, int y) {
        p[get(x)] = p[get(y)];
    }

    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        boolean[] res = new boolean[queries.length];
        int[][] queriesTemp = new int[queries.length][4];
        for (int i = 0; i < queries.length; ++i) {
            for (int j = 0; j < 3; ++j) queriesTemp[i][j] = queries[i][j];
            queriesTemp[i][3] = i;
        }
        queries = queriesTemp;
        Arrays.sort(queries, (o1, o2) -> o1[2] - o2[2]);
        Arrays.sort(edgeList, (o1, o2) -> o1[2] - o2[2]);
        p = new int[n];
        for (int i = 0; i < n; ++i) p[i] = i;
        int index = 0;
        for (int i = 0; i < queries.length; ++i) {
            while (index < edgeList.length && edgeList[index][2] < queries[i][2]) {
                union(edgeList[index][0], edgeList[index][1]);
                index++;
            }
            res[queries[i][3]] = (get(queries[i][0]) == get(queries[i][1]));
        }
        return res;
    }
}
