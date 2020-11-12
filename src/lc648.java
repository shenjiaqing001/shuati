import java.util.List;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/11/13
 */
public class lc648 {
    public class Trie {
        boolean isWord = false;
        Trie[] children = new Trie[26];
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        Trie root = new Trie();
        for (String str : dictionary) {
            Trie trie = root;
            for (char c : str.toCharArray()) {
                if (trie.isWord) break;
                if (trie.children[c - 'a'] == null) {
                    trie.children[c - 'a'] = new Trie();
                }
                trie = trie.children[c - 'a'];
            }
            trie.isWord = true;
        }

        StringBuilder sb = new StringBuilder();

        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; ++i) {
            boolean flag = false;
            StringBuilder tmp = new StringBuilder();
            Trie trie = root;
            for (int j = 0; j < words[i].length(); ++j) {
                tmp.append(words[i].charAt(j));
                if (trie.children[words[i].charAt(j) - 'a'] != null) {
                    if (trie.children[words[i].charAt(j) - 'a'].isWord) {
                        sb.append(tmp.toString()).append(" ");
                        flag = true;
                        break;
                    }
                    trie = trie.children[words[i].charAt(j) - 'a'];
                } else {
                    sb.append(words[i]).append(" ");
                    flag = true;
                    break;
                }
            }
            if (flag == false)
                sb.append(words[i]).append(" ");
        }
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }
}
