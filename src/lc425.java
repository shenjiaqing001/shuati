import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/10/2
 */
public class lc425 {
    public class Trie {
        Trie[] children = new Trie[26];
        boolean isWord = false;
    }

    public List<List<String>> wordSquares(String[] words) {
        Trie root = new Trie();
        int length = words[0].length();
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
        List<List<String>> res = new LinkedList<>();
        dfs(res, new ArrayList<>(), root, length);
        return res;
    }

    public void dfs(List<List<String>> res, List<String> list, Trie root, int length) {
        if (list.size() == length) {
            res.add(new ArrayList<>(list));
            return;
        }

        StringBuilder sb = new StringBuilder();
        int now = list.size();
        Trie nowRoot = root;
        for (int i = 0; i < now; ++i) {
            sb.append(list.get(i).charAt(now));
            int charnow = list.get(i).charAt(now) - 'a';
            if (nowRoot.children[charnow] == null) {
                return;
            }
            nowRoot = nowRoot.children[charnow];
        }

        List<String> tmp = new ArrayList<>();
        makeString(tmp, nowRoot, sb);

        for (String str : tmp) {
            list.add(str);
            dfs(res, list, root, length);
            list.remove(list.size() - 1);
        }
    }

    public void makeString(List<String> tmp, Trie root, StringBuilder sb) {
        if (root.isWord == true) {
            tmp.add(sb.toString());
            return;
        }

        for (int i = 0; i < 26; ++i) {
            if (root.children[i] != null) {
                sb.append((char) (i + 'a'));
                makeString(tmp, root.children[i], sb);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

    public static void main(String[] args) {
        String[] words = new String[]{"area", "lead", "wall", "lady", "ball"};
        lc425 t = new lc425();
        t.wordSquares(words);
    }
}
