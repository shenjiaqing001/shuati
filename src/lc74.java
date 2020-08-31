/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 7/21/20
 */
public class lc74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;

        int back = matrix[0].length - 1;
        int left = 0;
        int right = matrix.length - 1;

        while (left < right) {
            int mid = (left + right) / 2;
            if (matrix[mid][back] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        int front = 0;
        while (front < back) {
            int mid = (front + back) / 2;
            if (matrix[left][mid] >= target) {
                back = mid;
            } else {
                front = mid + 1;
            }
        }

        if (matrix[left][front] == target) return true;
        else return false;
    }
}
