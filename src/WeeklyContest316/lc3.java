package WeeklyContest316;

import java.util.Arrays;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 10/22/22
 */
public class lc3 {
    public long minCost(int[] nums, int[] cost) {
        int n = nums.length;
        long[][] array = new long[n][];
        for (int i = 0; i < nums.length; ++i) {
            array[i] = new long[]{nums[i], cost[i]};
        }
        Arrays.sort(array, (o1, o2) -> (int) (o1[0] - o2[0]));
        long min = Long.MAX_VALUE;
        long costNow = 0;
        for (int i = 1; i < n; ++i) {
            costNow += (long) (array[i][0] - array[0][0]) * (array[i][1]);
        }
        min = Math.min(min, costNow);

        long[] preSumCost = new long[n + 1];
        for (int i = 0; i < n; ++i) {
            preSumCost[i + 1] = preSumCost[i] + array[i][1];
        }
        for (int i = 1; i < n; ++i) {
            costNow -= (preSumCost[n] - preSumCost[i]) * (long) (array[i][0] - array[i - 1][0]);
            costNow += preSumCost[i] * (long) (array[i][0] - array[i - 1][0]);
            min = Math.min(min, costNow);
        }
        return min;
    }

    //[]
//[]
    public static void main(String[] args) {
        lc3 test = new lc3();
        test.minCost(
                new int[]{735103, 366367, 132236, 133334, 808160, 113001, 49051, 735598, 686615, 665317, 999793, 426087, 587000, 649989, 509946, 743518},
                new int[]{724182, 447415, 723725, 902336, 600863, 287644, 13836, 665183, 448859, 917248, 397790, 898215, 790754, 320604, 468575, 825614});
    }
}
