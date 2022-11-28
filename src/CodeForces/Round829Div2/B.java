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
public class B {
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

    public static void main(String[] args) throws IOException {
        Reader reader = new Reader();
        PrintWriter out = new PrintWriter(System.out);
        int tests = reader.nextInt();
        for (int t = 0; t < tests; ++t) {
            int num = reader.nextInt();
            for (int i = 0; i < num; ++i) {
                if (i % 2 == 0) {
                    out.print(((num + 1) / 2 - i / 2) + " ");
                } else {
                    out.print((num - (i - 1) / 2) + " ");
                }
            }
            out.println();
        }

        out.close();
    }

}
