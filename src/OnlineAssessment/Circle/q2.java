package OnlineAssessment.Circle;

import java.util.Arrays;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/11/1
 */
public class q2 {
    public static void main(String[] args) {
        q2 test = new q2();
        System.out.println(test.scoterTotal(23, new int[]{4, 7, 14}));
    }

    int scoterTotal(int finish, int[] scooters) {
        int res = 0;
        Arrays.sort(scooters);
        int last = -100;
        for (int scooter : scooters) {
            if (scooter >= finish) break;
            if (scooter < last + 10) continue;
            res += Math.min(scooter + 10, finish) - scooter;
            last = scooter;
        }
        return res;
    }
}
