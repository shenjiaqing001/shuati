package WeeklyContest297;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 6/11/22
 */
public class lc3 {
    int min = Integer.MAX_VALUE;
    int[] c;

    public void dfs(int depth, int num, int n, int k) {
        if (depth == n) {
            int[] sum = new int[k + 1];
            for (int i = 0; i < n; ++i) {
                int remain = num % 10;
                num /= 10;
                sum[remain] += c[i];
            }
            int tmp = 0;
            for (int i = 1; i <= k; ++i) {
                tmp = Math.max(tmp, sum[i]);
            }
            min = Math.min(min, tmp);
            return;
        }
        for (int i = 1; i <= k; ++i) {
            dfs(depth + 1, num * 10 + i, n, k);
        }
    }

    public int distributeCookies(int[] cookies, int k) {
        int n = cookies.length;
        c = cookies;
        dfs(0, 0, n, k);
        return min;
    }

    public static void main(String[] args) {
        lc3 test = new lc3();
        test.distributeCookies(new int[]{8, 15, 10, 20, 8}, 2);
    }
}
