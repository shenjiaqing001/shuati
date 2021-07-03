

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/7/3
 */
public class lc720 {
    public class Trie {
        boolean isWord = false;
        char c = 'a';
        Trie[] children = new Trie[26];
    }

    public String longestWord(String[] words) {
        Trie root = new Trie();
        for (String str : words) {
            Trie trie = root;
            for (char c : str.toCharArray()) {
                if (trie.children[c - 'a'] == null) {
                    trie.children[c - 'a'] = new Trie();
                }
                trie = trie.children[c - 'a'];
                trie.c = c;
            }
            trie.isWord = true;
        }


        return dfs(root).substring(1);
    }

    public String dfs(Trie root) {
//        System.out.println(root.c);
        String res = "";
        int max = 0;
        for (int i = 0; i < 26; ++i) {
            Trie child = root.children[i];
            if (child != null) {
                if (child.isWord) {
                    String ans = dfs(child);
                    if (ans.length() > max) {
                        res = ans;
                        max = ans.length();
                    }
                }
            }
        }

        return root.c + res;
    }

}
