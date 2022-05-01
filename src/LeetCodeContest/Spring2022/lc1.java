package LeetCodeContest.Spring2022;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 4/16/22
 */
public class lc1 {
    public int giveGem(int[] gem, int[][] operations) {
        for (int[] op : operations) {
            int x = op[0];
            int y = op[1];
            gem[y] += gem[x] / 2;
            gem[x] = (gem[x] + 1) / 2;
        }

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int g : gem) {
            max = Math.max(max, g);
            min = Math.min(min, g);
        }
        return max - min;
    }
}
