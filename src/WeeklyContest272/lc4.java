package WeeklyContest272;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 12/18/21
 */
public class lc4 {
    public int lengthOfLIS(int[] nums) {
        int[] lis = new int[nums.length];
        int size = 0;
        for (int num : nums) {
            int lo = 0;
            int hi = size;

            while (lo < hi) {
                int mid = (lo + hi) / 2;
                if (lis[mid] <= num)
                    lo = mid + 1;
                else
                    hi = mid;
            }
            lis[lo] = num;
            if (lo == size) size++;
        }
        return size;
    }

    public int kIncreasing(int[] arr, int k) {
        int res = 0;
        for (int i = 0; i < k; ++i) {
            int length = arr.length / k;
            if (i < arr.length % k) length += 1;
            int[] subArray = new int[length];
            for (int j = 0; j < length; ++j) {
                subArray[j] = arr[k * j];
            }
            int longest = lengthOfLIS(subArray);
            res += length - longest;
        }
        return res;
    }
}
