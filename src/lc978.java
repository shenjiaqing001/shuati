/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/28/20
 */
public class lc978 {
    public int maxTurbulenceSize(int[] A) {
        if (A.length == 1) return 1;
        int max = 1;
        int left = 0;
        int flag = -1;

        for (int i = 1; i < A.length; ++i) {
            if (A[i - 1] == A[i]) {
                left = i;
            } else if (A[i - 1] < A[i]) {
                if (flag != -1) left = i - 1;
                flag = 1;
            } else {
                if (flag != 1) left = i - 1;
                flag = -1;
            }
            max = Math.max(max, i - left + 1);
        }
        return max;
    }
}
