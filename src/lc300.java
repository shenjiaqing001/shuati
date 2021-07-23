/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/9/18
 */
public class lc300 {

    public int lengthOfLIS(int[] nums) {
        int[] lis = new int[nums.length];
        int size = 0;
        for (int num : nums) {
            int lo = 0;
            int hi = size;

            while (lo < hi) {
                int mid = (lo + hi) / 2;
                if (lis[mid] < num)
                    lo = mid + 1;
                else
                    hi = mid;
            }
            lis[lo] = num;
            if (lo == size) size++;

        }

        return size;
    }

}
