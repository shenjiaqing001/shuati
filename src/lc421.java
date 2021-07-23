/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 9/16/20
 */
public class lc421 {
    class TrieNode {
        TrieNode[] children;
        TrieNode() {
            this.children = new TrieNode[2];
        }
    }

    public int findMaximumXOR(int[] nums) {
        TrieNode root = new TrieNode();


        for (int num : nums) {
            TrieNode tmp = root;
            for (int i = 30; i >= 0; --i) {
                int bit = getIthBit(num, i);
                if (tmp.children[bit ^ 1] == null) {
                    tmp.children[bit ^ 1] = new TrieNode();
                }
                tmp = tmp.children[bit ^ 1];
            }
        }
        int max = Integer.MIN_VALUE;

        for (int num : nums) {
            TrieNode tmp = root;
            int ans = 0;
            for (int i = 30; i >= 0; --i) {
                int bit = getIthBit(num, i);
                if (tmp.children[bit] != null) {
                    tmp = tmp.children[bit];
                    ans += (1 << i);
                } else {
                    tmp = tmp.children[bit ^ 1];
                }
            }
            max = Math.max(max, ans);
            if (max == Integer.MAX_VALUE) break;
        }
        return max;
    }

    private int getIthBit(int num, int i) {
        return (num & (1 << i)) == 0 ? 0 : 1;
    }

}
