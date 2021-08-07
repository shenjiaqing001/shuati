import java.util.*;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/8/6
 */
public class lc1168 {

    int[] p;

    int get(int x) {
        return p[x] == x ? x : (p[x] = get(p[x]));
    }

    void union(int x, int y) {
        p[get(x)] = p[get(y)];
    }

    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {

        List<int[]> lists = new LinkedList<>();
        p = new int[n + 1];
        for (int i = 0; i <= n; ++i) p[i] = i;

        for (int[] pipe : pipes) {
            lists.add(pipe);
        }
        for (int i = 0; i < n; ++i) {
            lists.add(new int[]{0, i + 1, wells[i]});
        }
        lists.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });

        int connected = 0;
        int cost = 0;

        for (int[] pipe : lists) {
            if (get(pipe[0]) != get(pipe[1])) {
                union(pipe[0], pipe[1]);
                cost += pipe[2];
            }
        }

        return cost;
    }


    public static void main(String[] args) {
        lc1168 test = new lc1168();
        test.minCostToSupplyWater(5, new int[]{46012, 72474, 64965, 751, 33304},
                new int[][]{
                        {2, 1, 6719}, {3, 2, 75312}, {5, 3, 44918}
                });


    }
}
