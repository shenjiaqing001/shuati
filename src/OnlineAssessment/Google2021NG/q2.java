package OnlineAssessment.Google2021NG;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/9/23
 */
public class q2 {
    public static int solution(String S) {
        // a b b a a b a
        // 0 2 3 4 5 6 5  left to right
        // 1 2   3 3 5
        // a b b a a b a
        //   6 4 2 2 2 0
        //   6 5 4 3   1

        // a  b  b  a  a  a  b  a  a  a  b  b  a
        // 0  2  3  3  3  3  5  5  5  5  7  9  9

        // a  b  b  a  a  a  b  a  a  a  b  b  a
        // 9  9  7  5  5  5  5  3  3  3  3  2  0


        //   a b b a a b a
        // 0 1 2 3 4 5 6 7
        // 0 0 2 3 3 3 5 5

        //  7 6 5 4 3 2 1
        //  6 6 4 2 2 2 0

        //  0 2 3 3 3 5 5
        //  6 6 4 2 2 2 0

        //  6 8 7 5 5 7 5

        // aba
        // aabbbaaaaa

        // 对任意1个i， dpLeftToRight表示i的左边所有b删除需要的cost， dpRightToLeft表示i的右边所有b删除需要的cost

        char[] c = S.toCharArray();
        int n = c.length;

        // 0   1----n   n+1
        int[] dpLeftToRight = new int[n + 2];
        int[] dpRightToLeft = new int[n + 2];

        for (int i = 1; i <= n; ++i) {
            if (c[i - 1] == 'a') {
                dpLeftToRight[i] = Math.min(i - 1, dpLeftToRight[i - 1]);
            } else {
                dpLeftToRight[i] = Math.min(i, dpLeftToRight[i - 1] + 2);
            }
        }

        for (int i = n; i >= 1; --i) {
            if (c[i - 1] == 'a') {
                dpRightToLeft[i] = Math.min(n - i, dpRightToLeft[i + 1]);
            } else {
                dpRightToLeft[i] = Math.min(n + 1 - i, dpRightToLeft[i + 1] + 2);
            }
        }

        int min = n;
        for (int i = 1; i <= n; ++i) {
            if (c[i - 1] == 'a')
                min = Math.min(min, dpLeftToRight[i] + dpRightToLeft[i]);
        }

        return min;
    }

    public static void main(String[] args) {
        System.out.println(solution("aabaaabbbbbbbbaaaba"));
    }
}
