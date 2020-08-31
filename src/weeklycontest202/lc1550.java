package weeklycontest202;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/16/20
 */
public class lc1550 {

    public boolean threeConsecutiveOdds(int[] arr) {
        if (arr.length == 0) return false;
        int res = 0;
        for (int i = 0; i < arr.length; ++i) {
            if (arr[i] % 2 == 1) {
                res++;
                if (res == 3) return true;
            } else {
                res = 0;
            }
        }
        return false;
    }


}
