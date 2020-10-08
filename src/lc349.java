import java.util.HashSet;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/10/9
 */
public class lc349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> res = new HashSet<>();
        for (int i = 0; i < nums1.length; ++i) set.add(nums1[i]);
        for (int i = 0; i < nums2.length; ++i) if (set.contains(nums2[i])) res.add(nums2[i]);
        int[] tmp = new int[res.size()];
        return res.stream().mapToInt(Integer::valueOf).toArray();
    }
}
