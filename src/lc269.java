import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/26/20
 */
public class lc269 {
    public String alienOrder(String[] words) {
        boolean[][] map = new boolean[26][26];
        boolean[] c = new boolean[26];
        for (int i = 0; i < words.length; ++i) {
            for (int j = 0; j < words[i].length(); ++j) {
                c[words[i].charAt(j) - 'a'] = true;
            }
        }
        for (int i = 0; i < words.length; ++i) {
            if (i != 0) {
                int length = Math.min(words[i].length(), words[i - 1].length());
                for (int j = 0; j < length; ++j) {
                    if (words[i].charAt(j) == words[i - 1].charAt(j)) {
                        if (j == length - 1 && words[i - 1].length() > words[i].length())
                            return "";
                        continue;
                    }
                    map[words[i - 1].charAt(j) - 'a'][words[i].charAt(j) - 'a'] = true;
                    break;
                }
            }
        }

        int num = 26;
        List<Integer>[] pre = new List[num];
        int[] preCount = new int[num];
        for (int i = 0; i < num; ++i) {
            pre[i] = new ArrayList<>();
        }

        for (int i = 0; i < 26; ++i) {
            for (int j = 0; j < 26; ++j) {
                if (map[i][j] == true) {
                    pre[i].add(j);
                    preCount[j]++;
                }
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < num; ++i) {
            if (preCount[i] == 0 && c[i] == true) {
                q.add(i);
            }
        }
        List<Integer> res = new LinkedList<>();
        while (!q.isEmpty()) {
            int tmp = q.poll();
            res.add(tmp);
            for (int i = 0; i < pre[tmp].size(); ++i) {
                preCount[pre[tmp].get(i)]--;
                if (preCount[pre[tmp].get(i)] == 0)
                    q.add(pre[tmp].get(i));
            }
        }
        int count = 0;
        for (int i = 0; i < 26; ++i) {
            if (c[i] == true)
                count++;
        }

        if (res.size() != count) return "";
        else {
            StringBuilder sb = new StringBuilder();
            for (Integer i : res) {
                char tmp = (char) ('a' + i);
                sb.append(tmp);
            }
            return sb.toString();
        }
    }
}
