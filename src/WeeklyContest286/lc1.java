package WeeklyContest286;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 3/26/22
 */
public class lc1 {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for(int num : nums1) set1.add(num);
        for(int num : nums2) set2.add(num);
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        res.add(l1);
        res.add(l2);
        for(int num : set1){
            if(!set2.contains(num)) l1.add(num);
        }
        for(int num : set2){
            if(!set1.contains(num)) l2.add(num);
        }
        return res;
    }
}
