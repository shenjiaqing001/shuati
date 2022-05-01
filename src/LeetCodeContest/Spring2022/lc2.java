package LeetCodeContest.Spring2022;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 4/16/22
 */
public class lc2 {
    public int perfectMenu(int[] materials, int[][] cookbooks, int[][] attribute, int limit) {
        int n = cookbooks.length;
        int max = -1;
        for (int i = 1; i < (1 << n); ++i) {
            boolean flag = true;
            int sum = 0;
            int total = 0;
            int[] need = new int[5];
            for (int j = 0; j < n; ++j) {
                if (((i >> j) & 1) > 0) {
                    sum += attribute[j][0];
                    total += attribute[j][1];
                    for (int k = 0; k < 5; ++k) {
                        need[k] += cookbooks[j][k];
                    }
                }
            }
            if (total < limit) flag = false;
            for (int k = 0; k < 5; ++k) {
                if (need[k] > materials[k]) flag = false;
            }
            if (flag) {
                max = Math.max(max, sum);
            }
        }
        return max;
    }
}
