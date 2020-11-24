package WeeklyContest214;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/11/25
 */
public class lc1649 {
    int[] c = new int[10005];

    public int createSortedArray(int[] instructions) {
        int res = 0;

        for (int i = 0; i < instructions.length; ++i) {
            res = (res + Math.min(get(instructions[i] - 1), i - get(instructions[i]))) %
                    ((int) 1e9 + 7);
            update(instructions[i]);
        }

        return res;
    }

    public void update(int x) {
        while (x < 100001) {
            c[x]++;
            x += x & -x;
        }
    }

    public int get(int x) {
        int res = 0;
        while (x > 0) {
            res += c[x];
            x -= x & -x;
        }
        return res;
    }
}
