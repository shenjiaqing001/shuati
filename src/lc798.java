/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 1/19/22
 */
public class lc798 {
    public int bestRotation(int[] nums) {
        //0 1 2 3 4
        // k = 1 , 2 3 1 4 0
        // k = 2 , 3 1 4 0 2
        // k = 3 , 1 4 0 2 3
        // k = 4 , 4 0 2 3 1
        // k = 5 , 0 2 3 1 4

        // i = 2,  k = 1 2 3
        // i = 3,  k = 2 3
        // i = 1,  k = 0 1 3 4
        // i = 4,  k = 4
        // i = 0,  k = 0 1 2 3 4

        int n = nums.length;

        int[] preSum = new int[n + 5];
        for (int i = 0; i < n; ++i) {
            int start = i + 1;
            int end = i + 1 + (n - nums[i]);
            preSum[start] += 1;
            preSum[Math.min(end, n)] -= 1;
            if (end >= n) {
                preSum[0] += 1;
                end -= n;
                preSum[end] -= 1;
            }
        }
        int count = 0;
        int max = 0;
        int index = 0;
        for (int i = 0; i < n; ++i) {
            count += preSum[i];
            // System.out.println( preSum[i] );
            if (count > max) index = i;
            max = Math.max(max, count);
        }
        return index;
    }
}
