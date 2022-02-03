package mock.day0130;

import java.util.*;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 1/30/22
 */
public class canku1 {

    /*
        保持一致: 给你一个数组nums。允许你最多操作k次，每次操作可以将任意元素替换为任意值。问可以构造的最长subarray，满足所有的元素都相等。
     */

    public int yizhi(int[] nums, int k) {
        // key: 频次， value，频次为key的数字有哪些
        TreeMap<Integer, Set<Integer>> treeMap = new TreeMap<>();
        // 记录频次
        Map<Integer, Integer> map = new HashMap<>();
        treeMap.put(0, new HashSet<>());
        for (int num : nums) {
            treeMap.get(0).add(num);
        }
        int left = -1;
        int max = 0;
        for (int i = 0; i < nums.length; ++i) {
            int old = map.getOrDefault(nums[i], 0);
            treeMap.putIfAbsent(old + 1, new HashSet<>());
            treeMap.get(old + 1).add(nums[i]);
            treeMap.get(old).remove(nums[i]);
            map.put(nums[i], old + 1);
            while (i - left > treeMap.lastKey() + k) {
                left++;
                old = map.get(nums[left]);
                treeMap.get(old).remove(nums[i]);
                treeMap.get(old - 1).add(nums[i]);
                if (treeMap.get(old).size() == 0) treeMap.remove(old);
                map.put(nums[left], old - 1);
            }
            max = Math.max(max, i - left);
        }
        return max;
    }

}