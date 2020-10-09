import java.util.HashSet;
import java.util.Set;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/10/9
 */
public class lc526 {
    int[][] list = new int[][]{
            {},
            {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15},//1
            {1, 2, 4, 6, 8, 10, 12, 14},
            {1, 3, 6, 9, 12, 15},
            {1, 2, 4, 8, 12},
            {1, 5, 19, 15},
            {1, 2, 3, 6, 12},//6
            {1, 7, 14},
            {1, 2, 4, 8},
            {1, 3, 9},
            {1, 2, 5, 10},
            {1, 11},//11
            {1, 2, 3, 6, 12},
            {1, 13},
            {1, 2, 7, 14},
            {1, 3, 5, 15}
    };

    int count = 0;

    public int countArrangement(int N) {
        Set<Integer> set = new HashSet<>();
        dfs(set, 1, N);
        return count;
    }

    public void dfs(Set<Integer> set, int now, int total) {
        if (now == total + 1) {
            count++;
        } else {
            for (int i = 1; i <= total; ++i) {
                if (set.contains(i)) continue;
                if (now % i == 0 || i % now == 0) {
                    set.add(i);
                    dfs(set, now + 1, total);
                    set.remove(i);
                }
            }
        }
    }

}
