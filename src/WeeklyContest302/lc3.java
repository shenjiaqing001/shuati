package WeeklyContest302;

import java.util.Arrays;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 7/16/22
 */
public class lc3 {
    public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
        int[] res = new int[queries.length];
        int n = nums.length;
        int length = nums[0].length();
        String[][] sortList = new String[n][2];
        for (int i = 0; i < queries.length; ++i) {
            int[] q = queries[i];
            int start = length - q[1];
            for (int j = 0; j < n; ++j) {
                String tmp = nums[j].substring(start);
                sortList[j][0] = tmp;
                sortList[j][1] = String.valueOf(j);
            }
            Arrays.sort(sortList, (o1, o2) -> (o1[0].compareTo(o2[0])));
            res[i] = Integer.valueOf(sortList[q[0] - 1][1]);
        }
        return res;
    }
}
