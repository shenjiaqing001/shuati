package OnlineAssessment.ebay;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/10/9
 */
public class q1 {
    int evemNumberDigit(int[] a) {
        int res = 0;
        for (int num : a) {
            String s = String.valueOf(num);
            if (s.length() % 2 == 0) res++;
        }
        return res;
    }
}
