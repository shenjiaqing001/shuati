package WeeklyContest240;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/5/8
 */
public class lc2 {
    public int maxDistance(int[] nums1, int[] nums2) {
        int j = nums2.length - 1;
        int i = Math.min(nums1.length - 1, j);

        int max = 0;

        while (i >= 0 && j >= 0) {
            i = Math.min(i, j);
            while (i >= 1 && nums1[i - 1] <= nums2[j]) i--;

            if (nums1[i] <= nums2[j]) {
                max = Math.max(j - i, max);
            }
            j--;
        }

        return max;
    }
}
