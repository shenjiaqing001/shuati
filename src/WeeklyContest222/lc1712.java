package WeeklyContest222;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/1/3
 */
public class lc1712 {
    public int waysToSplit(int[] nums) {
        int n = nums.length;
        for (int i = 1; i < n; ++i) nums[i] += nums[i - 1];

        int res = 0;
        int total = nums[n - 1];
        int first = 0;
        while (first < n && nums[first] <= total / 3) {
            int left = first + 1;
            int right = n - 1;
            while (left < right) {
                int mid = (left + right) / 2;
                if (nums[mid] - nums[first] < nums[first]) left = mid + 1;
                else right = mid;
            }

            int left2 = first + 1;
            int right2 = n - 1;
            while (left2 < right2) {
                int mid = (left2 + right2) / 2;
                if (nums[mid] - nums[first] <= total - nums[mid]) left2 = mid + 1;
                else right2 = mid;
            }
            res = (res + (left2 - left)) % 1000000007;
            first++;
        }
        return res;
    }
}
