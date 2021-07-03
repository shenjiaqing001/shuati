package WeeklyContest247;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/6/27
 */
public class lc1915 {
    public long wonderfulSubstrings(String word) {
        long res = 0;
        int[] count = new int[1024];
        int state = 0;
        count[0] = 1;

        for (char c : word.toCharArray()) {
            state ^= 1 << (c - 'a');
            res += count[state];

            for (int i = 0; i < 10; ++i)
                res += count[state ^ (1 << i)];
            count[state]++;
        }

        return res;
    }
}
