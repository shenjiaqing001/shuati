package WeeklyContest315;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 10/15/22
 */
public class lc4 {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        long res = 0;
        int lastBlock = -1;
        int lowMatch = -1;
        int highMatch = -1;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] < minK || nums[i] > maxK) {
                highMatch = -1;
                lowMatch = -1;
                lastBlock = i;
            } else {
                if (nums[i] == minK) {
                    lowMatch = i;
                }
                if (nums[i] == maxK) {
                    highMatch = i;
                }
                if (highMatch != -1 && lowMatch != -1) {
                    int low = Math.min(highMatch, lowMatch);
                    int high = Math.max(highMatch, lowMatch);

                    res += (long) (low - lastBlock);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        lc4 test = new lc4();
        test.countSubarrays(new int[]{1,3,5,2,7,5}, 1, 5);
    }
}
