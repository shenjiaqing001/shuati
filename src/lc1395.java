/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/6/23
 */
public class lc1395 {
    public int numTeams(int[] rating) {
        int res = 0;
        for (int i = 0; i < rating.length; ++i) {
            int leftLess = 0;
            int rightLarge = 0;
            for (int j = 0; j < i; ++j) {
                if (rating[j] < rating[i]) leftLess++;
            }
            for (int j = i + 1; j < rating.length; ++j) {
                if (rating[j] > rating[i]) rightLarge++;
            }
            int leftLarge = i - leftLess;
            int rightLess = rating.length - i - rightLarge-1;

            System.out.println(leftLess + " " + leftLarge + " " + rightLarge + " " + rightLess);
            res += leftLess * rightLarge + leftLarge * rightLess;
        }
        return res;
    }
}
