package WeeklyContest242;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/5/22
 */
public class lc1870 {
    public int minSpeedOnTime(int[] dist, double hour) {
        if (canTravel(dist, hour, 10000000) == false) return -1;
        int left = 1;
        int right = 10000000;

        while (left < right) {
            int mid = (right + left) / 2;
            if (canTravel(dist, hour, mid)) right = mid;
            else left = mid + 1;
        }
        return left;
    }

    public boolean canTravel(int[] dist, double hour, int speed) {
        double time = 0;
        for (int i = 0; i < dist.length - 1; ++i) {
            if (dist[i] % speed == 0) time += dist[i] / speed;
            else time += dist[i] / speed + 1;
        }

        time += (double) dist[dist.length - 1] / (double) speed;
        return time <= hour;
    }

    public static void main(String[] args) {

        int a = 3;
        int b = 5;
        double t = (double) a / (double) b;
        System.out.println(t);
    }
}
