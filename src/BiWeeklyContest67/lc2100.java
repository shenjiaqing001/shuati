package BiWeeklyContest67;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 12/11/21
 */
public class lc2100 {
    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        int n = security.length;
        int[] left2right = new int[n];
        int[] right2left = new int[n];
        for (int i = 1; i < n; ++i) {
            if (security[i] <= security[i - 1]) {
                left2right[i] = left2right[i - 1] + 1;
            }
        }
        for (int i = n - 2; i >= 0; --i) {
            if (security[i] <= security[i + 1]) {
                right2left[i] = right2left[i + 1] + 1;
            }
        }
        List<Integer> res= new ArrayList<>();
        for(int i = 0 ; i< n; ++i){
            if(left2right[i] >= time && right2left[i] >= time){
                res.add(i);
            }
        }
        return res;
    }
}
