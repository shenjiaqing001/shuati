import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/9/4
 */
public class lc587 {

    public int cross(int[] o, int[] a, int[] b) {
        return (a[0] - o[0]) * (b[1] - o[1]) - (a[1] - o[1]) * (b[0] - o[0]);
    }

    public boolean equal(int[] a, int[] b) {
        return a[0] == b[0] && a[1] == b[1];
    }

    public int[][] outerTrees(int[][] trees) {
        int n = trees.length;
        if (n <= 2) return trees;
        Arrays.sort(trees, (o1, o2) -> (o1[1] == o2[1] ? o1[0] - o2[0] : o1[1] - o2[1]));

        int[] stack = new int[n + 5];
        int index = 0;
        for (int i = 0; i < n; ++i) {
            while (index >= 2 &&
                    cross(trees[stack[index - 2]], trees[i], trees[stack[index - 1]]) > 0) index--;
            stack[index++] = i;
        }

        int max = index + 1;
        for (int i = n - 2; i >= 0; --i) {
            if (equal(trees[stack[index - 2]], trees[i])) continue;
            while (index >= max &&
                    cross(trees[stack[index - 2]], trees[i], trees[stack[index - 1]]) > 0) index--;
            stack[index++] = i;
        }

        int len = Math.max(index - 1, 1);
        Set<int[]> res = new HashSet<>();
        for (int i = 0; i < len; ++i) {
            res.add(trees[stack[i]]);
        }
        return res.toArray(new int[res.size()][]);
    }
}
