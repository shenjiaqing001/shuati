import java.util.*;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/4/20
 */
public class lc127 {
    public int ladderLength(String beginWord, String endWord,
                            List<String> wordList) {
        Set<String> totalSet = new HashSet<>(wordList);
        int count = 1;
        Set<String> used = new HashSet<>();
        Set<String> tmp = new HashSet<>();
        tmp.add(beginWord);
        while (true) {
            Set<String> now = new HashSet<>();
            for (String str : tmp) {
                if (str.equals(endWord))
                    return count;
                char[] s = str.toCharArray();
                for (int i = 0; i < s.length; ++i) {
                    char t = s[i];
                    for (char j = 'a'; j <= 'z'; ++j) {
                        s[i] = j;
                        String newStr = String.valueOf(s);
                        if (totalSet.contains(newStr)) {
                            if (!used.contains(newStr)) {
                                used.add(newStr);
                                now.add(newStr);
                            }
                        }
                    }
                    s[i] = t;
                }
            }
            count++;
            tmp = now;
            if (now.size() == 0) return 0;
        }
    }

    public static void main(String[] args) {
        lc127 t = new lc127();
        List<String> list =
                Arrays.asList(
                        new String[]{"hot", "dot", "dog", "lot", "log", "cog"});
        System.out.println(t.ladderLength("hit", "cog", list));
    }
}
