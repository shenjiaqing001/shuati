/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 9/9/20
 */
public class lc1361 {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        boolean[] flag = new boolean[n];
        int count = 0;
        for (int i = 0; i < leftChild.length; ++i) {
            if (leftChild[i] != -1 && flag[leftChild[i]] == true) return false;
            if (rightChild[i] != -1 && flag[rightChild[i]] == true) return false;

            if (leftChild[i] != -1) {
                flag[leftChild[i]] = true;
                count++;
            }
            if (rightChild[i] != -1) {
                flag[rightChild[i]] = true;
                count++;
            }
        }
        if (count != n - 1) return false;
        for (int i = 0; i < n; ++i) {
            if (flag[i] == false) {
                int num = dfs(i, leftChild, rightChild);
                if (num != n) return false;
                break;
            }
        }
        return true;
    }

    public int dfs(int root, int[] leftChild, int[] rightChild) {
        if (root == -1) return 0;
        int left = dfs(leftChild[root], leftChild, rightChild);
        int right = dfs(rightChild[root], leftChild, rightChild);
        return left + right + 1;
    }
}
