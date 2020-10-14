package SomethingInteresting;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/10/14
 */
public class MaxSeqZeroOne {

    public int solve(int k, int m, int n) {
        int[] zero = new int[m];
        int[] one = new int[n];

        zero[1] = 1;
        one[1] = 1;
        for (int i = 2; i <= k; ++i) {
            //加个0
            int[] nextzero = new int[m];
            for (int j = 1; j < n; ++j) nextzero[1] += one[j];
            for (int j = 2; j < m; ++j) {
                nextzero[j] = nextzero[j - 1];
            }

            //加个1
            int[] nextone = new int[n];
            for (int j = 1; j < m; ++j) nextone[1] += zero[j];
            for (int j = 2; j < n; ++j) {
                nextone[j] = nextone[j - 1];
            }

            one = nextone;
            zero = nextzero;
        }

        int sum = 0;
        for(int i = 1;i<m;++i) sum += zero[i];
        for(int i = 1;i<n;++i) sum += one[i];

        return sum;
    }

}
