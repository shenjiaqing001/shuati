package OnlineAssessment.googleVO;

import java.util.*;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/11/3
 */
public class q1 {

    List<List<String>> list = new ArrayList<>();
    int res = 0;

    public static void main(String[] args) {
        q1 test = new q1();
        System.out.println(
                test.solve("aabbcc", new String[]{"a", "a", "a", "aa", "aa", "bb", "cc"}));
    }

    public int solve(String target, String[] words) {
        Arrays.sort(words);
        char[] c = target.toCharArray();
        dfs(c, 0, words, new HashSet<>());
        System.out.println(list);
        return res;
    }

    public void dfs(char[] c, int index, String[] words, Set<Integer> set) {
        if (index == c.length) {
            res += 1;
            ArrayList<String> tmp = new ArrayList<>();
            for (Integer id : set) {
                tmp.add(words[id]);
            }
            list.add(tmp);
            return;
        }

        int lastUsed = -1;
        for (int i = 0; i < words.length; ++i) {
            if (set.contains(i)) continue;
            if (lastUsed != -1) {
                if (Objects.equals(words[i], words[lastUsed])) continue;
            }
            int length = words[i].length();
            char[] cWord = words[i].toCharArray();
            boolean flag = true;
            for (int j = 0; j < length; ++j) {
                if (c[j + index] != cWord[j]) {
                    flag = false;
                    break;
                }
            }
            if (flag == true) {
                lastUsed = i;
                set.add(i);
                dfs(c, index + length, words, set);
                set.remove(i);
            }
        }
    }


}
