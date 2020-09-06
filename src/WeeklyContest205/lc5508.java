package WeeklyContest205;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 9/6/20
 */
public class lc5508 {
    public int numTriplets(int[] nums1, int[] nums2) {
        Map<Integer, Integer> left = new HashMap<>();
        Map<Integer, Integer> right = new HashMap<>();

        for (int i = 0; i < nums1.length; ++i) {
            left.put(nums1[i], left.getOrDefault(nums1[i], 0) + 1);
        }
        for (int i = 0; i < nums2.length; ++i) {
            right.put(nums2[i], right.getOrDefault(nums2[i], 0) + 1);
        }
        int res1 = 0;
        int res2 = 0;
        for (Integer key : left.keySet()) {
            int num1 = left.get(key);
            for (Integer key2 : right.keySet()) {
                int num2 = right.get(key2);
                long a = (long) key * (long) key;
                if (a % (long) key2 == 0) {
                    int key3 = (int) (a / (long) key2);
                    if (key3 == key2) {
                        System.out.println(num1 + " " + num2);
                        res1 += num1 * num2 * (num2 - 1) / 2;
                    } else if (right.containsKey(key3)) {
                        System.out.println(key + " " + key2 + " " + key3);
                        res2 += num1 * num2 * right.get(key3);
                    }
                }

            }
        }

        for (Integer key : right.keySet()) {
            int num1 = right.get(key);
            for (Integer key2 : left.keySet()) {
                int num2 = left.get(key2);
                long a = (long) key * (long) key;
                if (a % (long) key2 == 0) {
                    int key3 = (int) (a / (long) key2);
                    if (key3 == key2) {
                        System.out.println(num1 + " " + num2);
                        res1 += num1 * num2 * (num2 - 1) / 2;
                    } else if (left.containsKey(key3)) {
                        System.out.println(key + " " + key2 + " " + key3);
                        res2 += num1 * num2 * left.get(key3);
                    }
                }

            }
        }
        return res1 + res2 / 2;
    }
}
