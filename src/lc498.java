import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 9/6/20
 */
public class lc498 {
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return new int[]{};
        int i = 0;
        int j = 0;
        int x = matrix.length;
        int y = matrix[0].length;
        int direction = 1;


        int[] res = new int[x * y];
        int now = 0;

        while (now < x * y) {
            res[now++] = matrix[i][j];
            if (direction == 1) {
                if (i - 1 >= 0 && j + 1 < y) {
                    i -= 1;
                    j += 1;
                } else {
                    if (i == 0) {
                        if (j + 1 < y) {
                            j += 1;
                        } else {
                            i += 1;
                        }
                    } else {
                        i += 1;
                    }
                    direction = 2;
                }
            } else {
                if (i + 1 < x && j - 1 >= 0) {
                    i += 1;
                    j -= 1;
                } else {
                    if (j == 0) {
                        if (i + 1 < x) {
                            i += 1;
                        } else {
                            j += 1;
                        }
                    } else {
                        j += 1;
                    }
                    direction = 1;
                }
            }
        }
        return res;
    }
}
