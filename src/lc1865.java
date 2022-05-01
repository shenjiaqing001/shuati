import java.util.HashMap;
import java.util.Map;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 1/2/22
 */
public class lc1865 {


    class FindSumPairs {

        int[] nums1;
        int[] nums2;
        Map<Integer, Integer> map = new HashMap<>();

        public FindSumPairs(int[] nums1, int[] nums2) {
            this.nums1 = nums1;
            this.nums2 = nums2;
            for (int num : nums2) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
        }

        public void add(int index, int val) {
            int ori = nums2[index];
            nums2[index] += val;
            int after = ori + val;
            map.put(ori, map.get(ori) - 1);
            map.put(after, map.getOrDefault(after, 0) + 1);
        }

        public int count(int tot) {
            int sum = 0;
            for (int num : nums1) {
                sum += map.getOrDefault(tot - num, 0);
            }
            return sum;
        }
    }
}
