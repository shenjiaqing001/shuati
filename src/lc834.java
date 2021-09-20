import java.util.ArrayList;
import java.util.List;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/11/30
 */
public class lc834 {
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        List<Integer>[] list = new List[n];
        for (int i = 0; i < n; ++i) list[i] = new ArrayList<>();
        for (int[] edge : edges) {
            list[edge[0]].add(edge[1]);
            list[edge[1]].add(edge[0]);
        }
        int[] res = new int[n];
        int[] child = new int[n];
        dfsChild(list, child, res, 0, 0);
        dfsRes(list, child, res, 0, 0);
        return res;
    }

    public void dfsRes(List<Integer>[] list, int[] child, int[] res, int root, int from) {
        if (root == 0) {

        } else {
            res[root] = res[from] - child[root] + (list.length - child[root]);
        }
        if (list[root].size() > 0) {
            for (int c : list[root]) {
                if (c == from) continue;
                dfsRes(list, child, res, c, root);
            }
        }
    }


    public int[] dfsChild(List<Integer>[] list, int[] child, int[] res, int root, int from) {
        int sumChild = 0;
        int sumDis = 0;
        for (int c : list[root]) {
            if (c == from) continue;
            int[] tmp = dfsChild(list, child, res, c, root);
            sumChild += tmp[0];
            sumDis += tmp[1];
        }
        sumDis += sumChild;
        child[root] = sumChild + 1;
        res[root] = sumDis;
        return new int[]{sumChild + 1, sumDis};
    }
}
