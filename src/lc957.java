/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/21/20
 */
public class lc957 {
    public int[] prisonAfterNDays(int[] cells, int N) {
        if (N == 0) return cells;
        doOneTime(cells);
        N -= 1;
        N %= 14;
        while (N > 0) {
            N--;
            doOneTime(cells);
        }
        return cells;
    }

    public void doOneTime(int[] cells) {
        int left = cells[0];
        for (int i = 1; i <= 6; ++i) {
            int temp = cells[i];
            if (cells[i + 1] == left)
                cells[i] = 1;
            else
                cells[i] = 0;
            left = temp;
        }
        cells[0] = cells[7] = 0;
    }
}
