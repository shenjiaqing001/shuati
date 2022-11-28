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
public class C {
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
            int n = reader.nextInt();
            int[] arr = reader.readArray(n);
            int sum = 0;
            Deque<int[]> q = new ArrayDeque<>();
            for (int i = 0; i < n; ++i) {
                sum += Math.abs(arr[i]);
            }
            if (sum % 2 != 0) {
                out.println(-1);
                continue;
            }
            List<int[]> res = new ArrayList<>();
            for (int i = n - 1; i >= 0; --i) {
                if (arr[i] == 0) {
                    q.addFirst(new int[]{0, i});
                } else {
                    if (!q.isEmpty()) {
                        if (q.peekFirst()[0] == 0) {
                            q.addFirst(new int[]{arr[i], i});
                        } else {
                            if (q.peekFirst()[0] + arr[i] == 0) {
                                res.add(new int[]{i + 1, i + 1});
                                res.add(new int[]{i, i});
                            } else {
                                res.add(new int[]{i, i + 1});
                            }
                            q.pollFirst();
                        }
                    } else {
                        q.addFirst(new int[]{arr[i], i});
                    }
                }
            }
            int tmp = 0;
            int start = -1;
            int last = -1;
            if (!q.isEmpty()) {
                if (q.peekFirst()[0] != 0) {
                    int[] first = q.pollFirst();
                    res.add(new int[]{first[1], first[1]});
                    tmp += first[0];
                }
            }

            while (!q.isEmpty()) {
                int[] first = q.pollFirst();
                if (first[0] == 0) {
                    if (start == -1) {
                        start = first[1];
                    } else {
                        if (first[1] != last + 1) {
                            res.add(new int[]{start, last});
                            start = first[1];
                        }
                    }
                    last = first[1];
                } else {
                    if (tmp > 0) {
                        if (first[0] == 1) {
                            if (start == first[1] - 1) {
                                res.add(new int[]{start, first[1]});
                            } else {
                                res.add(new int[]{first[1] - 1, first[1]});
                                res.add(new int[]{start, first[1] - 2});
                            }
                        } else {
                            if (start == first[1]) {
                                res.add(new int[]{start, first[1]});
                            } else {
                                res.add(new int[]{first[1], first[1]});
                                res.add(new int[]{start, first[1] - 1});
                            }
                        }
                        tmp = 0;
                    } else if (tmp < 0) {
                        if (first[0] == 1) {
                            if (start == first[1]) {
                                res.add(new int[]{start, first[1]});
                            } else {
                                res.add(new int[]{first[1], first[1]});
                                res.add(new int[]{start, first[1] - 1});
                            }
                        } else {
                            if (start == first[1] - 1) {
                                res.add(new int[]{start, first[1]});
                            } else {
                                res.add(new int[]{first[1] - 1, first[1]});
                                res.add(new int[]{start, first[1] - 2});
                            }
                        }
                        tmp = 0;
                    } else {
                        if (start == first[1]) {
                            res.add(new int[]{start, first[1]});
                        } else {
                            res.add(new int[]{first[1], first[1]});
                            res.add(new int[]{start, first[1] - 1});
                        }
                        tmp += first[0];
                    }
                    start = -1;
                }
            }
            if (start != -1) {
                res.add(new int[]{start, last});
            }
            res.sort(((o1, o2) -> (o1[0] - o2[0])));
            out.println(res.size());
            for (int[] re : res) {
                out.println((re[0] + 1) + " " + (re[1] + 1));
            }
        }

        out.close();
    }
}
