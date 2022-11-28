package WeeklyContest321;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 11/26/22
 */
public class lc1 {
    public int pivotInteger(int n) {
        int sum = n * (n + 1) / 2;
        int tmp = 0;
        for (int i = 1; i <= n; i++) {
            tmp += i;
            int left = tmp;
            int right = sum - tmp + i;

            if (left == right) return i;
        }
        return -1;
    }
}
