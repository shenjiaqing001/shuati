package WeeklyContest262;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/10/9
 */
public class lc2032 {
    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        Set<Integer> s1 = new HashSet<>();
        Set<Integer> s2 = new HashSet<>();
        Set<Integer> s3 = new HashSet<>();

        for (int num : nums1) s1.add(num);
        for (int num : nums2) s2.add(num);
        for (int num : nums3) s3.add(num);

        Set<Integer> res = new HashSet<>();
        for (int num : s1) {
            if (s2.contains(num)) res.add(num);
            if (s3.contains(num)) res.add(num);
        }
        for (int num : s2) {
            if (s3.contains(num)) res.add(num);
        }
        List<Integer> list = new ArrayList<>();
        for (int num : res) list.add(num);
        return list;
    }
}
