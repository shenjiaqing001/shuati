/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/11/3
 */
public class lc1184 {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int sum = 0;
        for (int i = 0; i < distance.length; ++i) {
            sum += distance[i];
        }
        if (destination < start) {
            int tmp = start;
            start = destination;
            destination = tmp;
        }

        int sum2 = 0;
        for (int i = start; i < destination; ++i) {
            sum2 += distance[i];
        }
        return Math.min(sum2, sum - sum2);
    }
}
