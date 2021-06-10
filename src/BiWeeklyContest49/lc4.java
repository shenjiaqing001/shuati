package BiWeeklyContest49;

import java.util.*;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/4/3
 */
public class lc4 {
    public int maxHappyGroups(int batchSize, int[] groups) {
        int[] count = new int[batchSize];
        int sum = groups.length;
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

        //helper(count,, , )

        return res;
    }

    int now = 2;

    public boolean helper(int[] count, List<Integer> tmp, int num, int sum,
                          int batchSize) {
        if (sum % batchSize == 0) return true;
        if (tmp.size() >= now) return false;

        for (int i = num; i >= 1; --i) {
            if (count[i] > 0) {
                count[i]--;
                tmp.add(i);
                if (sum == -1) sum = 0;
                if (helper(count, tmp, i, (sum + i) % batchSize, batchSize))
                    return true;
                count[i]++;
                tmp.remove(tmp.size() - 1);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        /**
         3
         [1,2,3,4,5,6]
         4
         [1,3,2,5,2,2,1,6]
         7
         [2,6,3,6,2,2,6,6,6,6,6]
         */
    }
}
