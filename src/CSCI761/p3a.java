package CSCI761;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 9/5/20
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author Yuyao Ning (yn1106@rit.edu)
 * @date 9/4/20
 */
public class p3a {
    public static int Knapsack(int[] items, int weightLimit, int modulo) {

        int[] newItems = new int[items.length + 1];
        newItems[0] = 0;
        for (int i = 0; i < items.length; i++) {
            newItems[i + 1] = items[i];
        }


        int[][] dp = new int[newItems.length][weightLimit + 1];

        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 1;
        }

        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (j < newItems[i]) {
                    dp[i][j] = dp[i - 1][j] % modulo;
                }

                if (j >= newItems[i]) {
                    dp[i][j] = (dp[i - 1][j] + dp[i - 1][j - newItems[i]])%modulo;
                }
            }
        }

        for (int[] row : dp) {
            System.out.println(Arrays.toString(row));
        }

        return dp[newItems.length - 1][weightLimit] % modulo;

    }

    public static void main(String[] args) {


        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        try {
            String[] firstLine = bf.readLine().split(" ");
            int n = Integer.parseInt(firstLine[0]);
            int weightLimit = Integer.parseInt(firstLine[1]);
            int modulo = Integer.parseInt(firstLine[2]);
            int[] items = new int[n];

            int num = 0;

            String line = "";

            while ((line = bf.readLine()) != null && !"".equals(line)) {
                items[num] = Integer.parseInt(line);
                num++;
            }

            if (items.length == 0) {
                System.out.println(1);
                return;
            }
            if (items.length == 1) {
                System.out.println(2);
                return;
            }

            System.out.println(Knapsack(items, weightLimit, modulo));

        } catch (Exception e) {
            System.out.println(e);

        }
    }
}
