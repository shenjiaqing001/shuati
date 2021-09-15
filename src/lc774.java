/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/9/15
 */
public class lc774 {
    public static void main(String[] args) {
        lc774 test = new lc774();
        test.minmaxGasDist(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 9);

    }

    public double minmaxGasDist(int[] stations, int k) {
        int n = stations.length;
        double[] s = new double[n];
        for (int i = 0; i < n; ++i) {
            s[i] = stations[i];
        }
        double left = 0;
        double right = s[n - 1];
        while (right - left >= 0.00001) {
            double mid = right - (right - left) / 2;
            if (check(s, k, mid)) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return left;
    }

    public boolean check(double[] stations, int k, double dis) {
        int res = 0;
        for (int i = 1; i < stations.length; ++i) {
            double distance = stations[i] - stations[i - 1];
            int used = (int) ((distance - 0.00001) / dis);
            res += used;
            if (res > k) return false;
        }
        return true;
    }

}
