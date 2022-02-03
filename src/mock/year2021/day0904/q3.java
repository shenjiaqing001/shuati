package mock.year2021.day0904;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/9/4
 */
public class q3 {
    // 给出一个数组，问有多少个subarray包含了这个数组的最大值最小值
    // 4 6 3 2 1 5

    public static int minmaxSubarray(int[] nums) {
        int n = nums.length;
        int total = (n + 1) * n / 2;

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        int res = 0;
        int maxCount = 0;
        int minCount = 0;
        int left = 0;
        for (int i = 0; i < n; ++i) {
            if (nums[i] == min) minCount++;
            if (nums[i] == max) maxCount++;

            while (minCount > 0 && maxCount > 0) {
                int now = i - 1;
                res += now - left + 1;
                if (nums[left] == min) minCount--;
                if (nums[left] == max) maxCount--;
                left++;
            }
        }
        res += (n - left) * (n - left + 1) / 2;

        return total - res;
    }

    public static void main(String[] args) {
        System.out.println(minmaxSubarray(new int[]{6, 4, 5, 1, 6}));
    }


}
