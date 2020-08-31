package weeklycontest202;

import java.util.Arrays;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/16/20
 */
public class lc1552 {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int left = 1;
        int right = (position[position.length - 1] - position[0]) / (m-1)+1;
        while (left < right) {
            System.out.println(left + " " + right);
            int mid = (left + right) / 2;
            if (can(position, m, mid)) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left - 1;
    }

    public boolean can(int[] position, int m, int dis) {
        int res = 1;
        int last = position[0];
        for (int i = 1; i < position.length; ++i) {
            if (position[i] >= last + dis) {
                last = position[i];
                res++;
            }
        }
        if (res < m) return false;
        else return true;
    }
}
