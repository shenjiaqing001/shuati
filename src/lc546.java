/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/8/14
 */
public class lc546 {
    int[][][] dp = new int[100][100][100];
    int[] boxes;
    int n;

    public int removeBoxes(int[] boxes) {
        this.boxes = boxes;
        this.n = boxes.length;
        return dfs(0, n - 1, 0);
    }

    public int dfs(int left, int right, int k) {
        if (left > right) return 0;

        if (dp[left][right][k] != 0)
            return dp[left][right][k];

        int i = right;
        int count = k;
        while (i >= left && boxes[i] == boxes[right]) {
            i--;
            count++;
        }
        dp[left][right][k] = dfs(left, i, 0) + count * count;

        for (int j = i; j >= left; j--) {
            if (boxes[j] != boxes[right]) continue;
            if (boxes[j] == boxes[right] && boxes[j + 1] == boxes[right]) continue;
            dp[left][right][k] =
                    Math.max(dp[left][right][k], dfs(left, j, count) + dfs(j + 1, i, 0));
        }
        return dp[left][right][k];
    }
}
