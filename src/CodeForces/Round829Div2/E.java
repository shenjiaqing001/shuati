package CodeForces.Round829Div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 10/23/22
 */
public class E {
    static class Reader {
        BufferedReader in;
        StringTokenizer st;

        public Reader() {
            in = new BufferedReader(new InputStreamReader(System.in));
            st = new StringTokenizer("");
        }

        public String nextLine() throws IOException {
            st = new StringTokenizer("");
            return in.readLine();
        }

        public String next() throws IOException {
            while (!st.hasMoreTokens()) {
                st = new StringTokenizer(in.readLine());
            }
            return st.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        public long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        public double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }

        public int[] readArray(int n) throws IOException {
            int[] arr = new int[n];
            for (int i = 0; i < n; ++i) {
                arr[i] = nextInt();
            }
            return arr;
        }
    }

    public static long[] inverseN(int n, long p) {
        long[] inv = new long[n + 1];
        inv[1] = 1;

        for (int i = 2; i <= n; i++) {
            inv[i] = (p - p / i) * inv[(int) (p % i)] % p;
        }
        return inv;
    }

    public static void main(String[] args) throws IOException {
        Reader reader = new Reader();
        PrintWriter out = new PrintWriter(System.out);
        int cases = reader.nextInt();
        long p = 998244353;
        for (int caseIndex = 0; caseIndex < cases; ++caseIndex) {
            int n = reader.nextInt();
            int[] arr = reader.readArray(n);
            int count0 = 0;
            for (int num : arr) {
                if (num == 0) count0++;
            }
            int needChange = 0;
            long res = 0;
            for (int i = 0; i < count0; ++i) {
                if (arr[i] == 1) needChange++;
            }
            long[] inv = inverseN(needChange + 2, p);
            long fenzi = (long) n * (n - 1) / 2 % p;
            while (needChange > 0) {
                res += (inv[needChange] * inv[needChange] % p) * fenzi % p;
                res %= p;
                needChange--;
            }
            System.out.println(res);
        }
        out.close();
    }
}
