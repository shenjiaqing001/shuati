package WeeklyContest314;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 10/8/22
 */
public class lc2 {
    public int[] findArray(int[] pref) {
        int[] res = new int[pref.length];
        int last = 0;
        for (int i = 0; i < pref.length; ++i) {
            res[i] = last ^ pref[i];
            last ^= res[i];
        }
        return res;
    }
}
