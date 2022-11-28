package CodeForces.Round829Div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 10/23/22
 */
public class A {
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
        int test = reader.nextInt();
        for (int i = 0; i < test; ++i) {
            int noNeed = reader.nextInt();
            char[] c = reader.next().toCharArray();
            int Q = 0;
            for (char tmp : c) {
                if (tmp == 'Q') {
                    Q++;
                } else {
                    Q--;
                }
                if (Q < 0) Q = 0;
            }

            if (Q > 0) out.println("No");
            else out.println("Yes");
        }
        out.close();
    }
}
