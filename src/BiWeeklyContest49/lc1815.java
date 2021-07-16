package BiWeeklyContest49;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/4/3
 */
public class lc1815 {
    Map<Long, Integer> map = new HashMap<>();

    public int maxHappyGroups(int batchSize, int[] groups) {
        int[] count = new int[batchSize];
        int res = 0;
        for (int i = 0; i < groups.length; ++i) {
            int remain = groups[i] % batchSize;
            if (remain == 0) res++;
            else count[remain]++;
        }

        for (int i = 1; i <= batchSize / 2; ++i) {
            int min = Math.min(count[i], count[batchSize - i]);
            if (batchSize % 2 == 0 && i == batchSize / 2) min /= 2;
            res += min;
            count[i] -= min;
            count[batchSize - i] -= min;
        }

        long state = 0;
        for (int i = 0; i < batchSize; ++i) {
//            System.out.println(count[i]);
            state += (long) count[i] << (i * 5);
        }

        return res + dfs(count, state, 0, batchSize);
    }

    public int dfs(int[] count, long state, int sum, int batchSize) {
        if (state == 0) return 0;
        if (map.containsKey(state)) return map.get(state);
        System.out.println(state);
        int max = 0;
        long tmp = state;
        for (int i = 0; i < batchSize; ++i) {
            if (count[i] == 0) {
                continue;
            }
            state -= (long) (1 << (i * 5));
            count[i] -= 1;
            max = Math.max(max, dfs(count, state, (sum + i) % batchSize, batchSize));
            state += (long) (1 << (i * 5));
            count[i] += 1;
            tmp = tmp >> 5;
        }
        map.put(state, (sum == 0 ? 1 : 0) + max);
        return (sum == 0 ? 1 : 0) + max;
    }


    public static void main(String[] args) {

        lc1815 test = new lc1815();
        test.maxHappyGroups(4, new int[]{1, 3, 2, 5, 2, 2, 1, 6});
        /**
         3
         [1,2,3,4,5,6]
         4
         [1,3,2,5,2,2,1,6]
         7
         [2,6,3,6,2,2,6,6,6,6,6]
         8
         [8,8,4,1,6,8,6,3,7,7,2,4,1,6,7,4,1,4,2,4,4,7,6,1,5,1,3,4,1,1]
         9
         [3,1,3,3,5,6,1,1,9,10,3,3,3,1,1,3,3,3,19,20,1,3,3,3,3,1,1,3,3,30]
         */
    }
}
