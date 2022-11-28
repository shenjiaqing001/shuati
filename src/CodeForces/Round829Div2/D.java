package CodeForces.Round829Div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 10/23/22
 */
public class D {
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
        int n = reader.nextInt();
        int m = reader.nextInt();
        int[] arr = reader.readArray(n);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : arr) {
            if (num < m) {
                pq.add(num);
            }
        }
        int last = -1;
        int count = 0;
        boolean flag = true;
        while (!pq.isEmpty()) {
            if (last == -1) {
                last = pq.poll();
                count = 1;
            } else {
                if (pq.poll() != last) {
                    flag = false;
                    break;
                } else {
                    count++;
                }
                if (count == last + 1) {
                    if (count < m) {
                        pq.add(count);
                    }
                    count = 0;
                    last = -1;
                }
            }
        }
        if (last != -1) flag = false;
        if (flag) out.println("Yes");
        else out.println("No");
        out.close();
    }
}
