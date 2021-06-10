package WeeklyContest236;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/4/13
 */
public class lc1823 {
    public int findTheWinner(int n, int k) {
        boolean[] flag = new boolean[n + 1];
        int count = 0;
        int index = 1;
        while (count < n - 1) {

            int tmp = 1;
            while (flag[index]) {
                index++;
                if (index > n) index = 1;
            }
            while (tmp < k) {
                while (flag[index]) {
                    index++;
                    if (index > n) index = 1;
                }
                tmp++;
                index++;
                if (index > n) index = 1;
            }
            while (flag[index]) {
                index++;
                if (index > n) index = 1;
            }
            flag[index] = true;
            System.out.println(index);
            count++;
        }
        for (int i = 1; i <= n; ++i) {
            if (!flag[i]) return i;
        }
        return 0;
    }


    public int findTheWinner2(int n, int k) {
        int res = 0;
        for (int i = 1; i <= n; ++i)
            res = (res + k) % i;
        return res + 1;
    }

    public static void main(String[] args) {
        lc1823 test = new lc1823();
        test.findTheWinner(5, 3);
    }
}
