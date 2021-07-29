package OnlineAssessment.ZYJ20210728;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/7/28
 */
public class OA1 {

    public int[] solution(int[] A, int F, int M) {
        int length = A.length;
        int total = (length + F) * M;
        for (int num : A) total -= num;
        if (total < F || total > F * 6) return new int[]{0};
        int[] res = new int[F];
        total -= F;
        for (int i = 0; i < F; ++i) res[i] = 1;
        for (int i = 0; i < F; ++i) {
            if (total >= 5) {
                res[i] += 5;
                total -= 5;
            } else {
                res[i] += total;
                break;
            }
        }
        return res;
    }


}
