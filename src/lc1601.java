/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/9/20
 */
public class lc1601 {
    public int maximumRequests(int n, int[][] requests) {
        int m = requests.length;
        for (int i = m; i >= 1; --i) {
            int state = (1 << i) - 1;
            while (state < (1 << m)) {
                int[] count = new int[n];
                for (int j = 0; j < m; ++j) {
                    if (((state >> j) & 1) > 0) {
                        count[requests[j][0]]++;
                        count[requests[j][1]]--;
                    }
                }
                boolean flag = true;
                for (int j = 0; j < n; ++j) {
                    if (count[j] != 0) {
                        flag = false;
                        break;
                    }
                }
                if (flag) return i;

                int c = state & -state;
                int r = state + c;
                state = (((r ^ state) >> 2) / c) | r;
            }
        }
        return 0;
    }
}
