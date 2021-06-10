package WeeklyContest225;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/1/24
 */
public class lc4 {
    public int minimumBoxes(int n) {
        long i = 1;
        long left = n;
        while (i * (i + 1) * (i + 2) / 6 < left) {
            i++;
        }
        i--;
        left -= i * (i + 1) * (i + 2) / 6;

        long res = i * (i + 1) / 2;
        int index = 1;
        while (left > 0) {
            res++;
            left -= index;
            index++;
        }

        return (int) res;
    }

    public static void main(String[] args) {
        lc4 t = new lc4();
        t.minimumBoxes(11);
    }
}
