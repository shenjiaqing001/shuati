/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/24/20
 */
public class lc1032 {
    class StreamChecker {
        class TrieNode {
            boolean isWord;
            TrieNode[] next = new TrieNode[26];
        }

        TrieNode root = new TrieNode();
        StringBuffer sb = new StringBuffer();

        public StreamChecker(String[] words) {
            for (String word : words) {
                TrieNode node = root;
                for (int i = word.length() - 1; i >= 0; --i) {
                    char c = word.charAt(i);
                    if (node.next[c - 'a'] == null) {
                        node.next[c - 'a'] = new TrieNode();
                    }
                    node = node.next[c - 'a'];
                }
                node.isWord = true;
            }
        }

        public boolean query(char letter) {
            sb.append(letter);
            TrieNode node = root;
            for (int i = sb.length() - 1; i >= 0; --i) {
                char c = sb.charAt(i);
                node = node.next[c - 'a'];
                if (node != null && node.isWord == true)
                    return true;
                else if (node == null) {
                    break;
                }
            }
            return false;
        }
    }
}
