/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/8/20
 */
public class lc135 {
    public int candy(int[] ratings) {
        int[] res = new int[ratings.length];
        if (ratings.length == 0) return 0;
        if (ratings.length == 1) return 1;

        res[0] = 1;
        for (int i = 1; i < ratings.length; ++i) {
            res[i] = 1;
            if (ratings[i] > ratings[i - 1]) res[i] = res[i - 1] + 1;
        }
        int sum = res[res.length - 1];
        for (int i = ratings.length - 2; i >= 0; --i) {
            if (ratings[i] > ratings[i + 1])
                res[i] = Math.max(res[i], res[i + 1] + 1);
            sum += res[i];
        }

        return sum;
    }

    public static void main(String[] args) {
        lc135 t = new lc135();
        System.out.println(t.candy(new int[]{1, 3, 4, 5, 2}));
    }
}
