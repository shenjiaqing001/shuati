import java.util.*;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/10/4
 */
public class lc398 {
    class Solution {
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        Random R = new Random(0);
        public Solution(int[] nums) {
            for (int i = 0; i < nums.length; ++i) {
                map.putIfAbsent(nums[i], new ArrayList<>());
                map.get(nums[i]).add(i);
            }
        }

        public int pick(int target) {
            if (!map.containsKey(target)) return -1;
            ArrayList<Integer> list = map.get(target);


            int i = R.nextInt(list.size());
            return list.get(i);
        }
    }
}
