import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 9/14/20
 */
public class lc787 {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        int[][] dp = new int[n][n];
        int[] minValue = new int[n];

        List<int[]>[] map = new LinkedList[n];
        for (int i = 0; i < minValue.length; ++i) minValue[i] = Integer.MAX_VALUE;
        for (int[] flight : flights) {
            int start = flight[0];
            if (map[start] == null) map[start] = new LinkedList<>();
            map[start].add(flight);
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        minValue[src] = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= K + 1; ++i) {
            int size = q.size();
            for (int j = 0; j < size; ++j) {
                int now = q.poll();
                if (map[now] == null) continue;
                List<int[]> nowFlights = map[now];
                for (int[] flight : nowFlights) {
                    int des = flight[1];
                    int prices = dp[now][i - 1] + flight[2];
                    if (prices >= minValue[des]) continue;
                    System.out.println(prices);
                    dp[des][i] = prices;
                    minValue[des] = prices;
                    q.add(des);
                }
            }
        }

        if (minValue[dst] == Integer.MAX_VALUE) return -1;
        else return minValue[dst];
    }
}
