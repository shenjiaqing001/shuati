package z.template;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 9/9/20
 */
public class trie {
    public class Trie {
        boolean isWord = false;
        Trie[] children = new Trie[26];
    }

    public int[][] indexPairs(String text, String[] words) {
        List<int[]> result = new ArrayList<>();
        Trie root = new Trie();
        for (String str : words) {
            Trie trie = root;
            for (char c : str.toCharArray()) {
                if (trie.children[c - 'a'] == null) {
                    trie.children[c - 'a'] = new Trie();
                }
                trie = trie.children[c - 'a'];
            }
            trie.isWord = true;
        }

        for (int i = 0; i < text.length(); ++i) {
            Trie trie = root;
            if (trie.children[text.charAt(i) - 'a'] != null) {
                int j = i;
                while (j < text.length() && trie.children[text.charAt(j) - 'a'] != null) {
                    trie = trie.children[text.charAt(j) - 'a'];
                    if (trie.isWord) {
                        result.add(new int[]{i, j});
                    }
                    j += 1;
                }
            }
        }
        return result.toArray(new int[0][]);
    }
}
