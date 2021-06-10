package BiWeeklyContest42;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/1/1
 */
public class lc1702 {
    public String maximumBinaryString(String binary) {
        char[] c = binary.toCharArray();
        int n = c.length;
        int first = 0;
        while (first < n && c[first] == '1') first++;
        if (first == n) return binary;
        int count = 0;
        for (int i = first; i < n; ++i) if (c[i] == '1') count++;


        for (int i = 0; i < n - count - 1; ++i) c[i] = '1';
        c[n - count - 1] = '0';
        for (int i = n - count; i < n; ++i) c[i] = '1';
        return new String(c);
    }
}
