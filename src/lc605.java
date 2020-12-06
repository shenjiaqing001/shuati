/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/12/6
 */
public class lc605 {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n == 0) return true;
        if (flowerbed.length == 1) {
            if (flowerbed[0] == 1) return false;
            if (n <= 1) return true;
            else return false;
        }

        int count = 0;


        if (flowerbed[0] == 0 && flowerbed.length > 1 && flowerbed[1] == 0) {
            count++;
            flowerbed[0] = 1;
        }
        if (flowerbed.length > 2 && flowerbed[flowerbed.length - 1] == 0 &&
                flowerbed[flowerbed.length - 2] == 0) {
            count++;
            flowerbed[flowerbed.length - 1] = 1;
        }

        for (int i = 1; i < flowerbed.length - 1; ++i) {
            if (flowerbed[i] == 0 && flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0) {
                count++;
                flowerbed[i] = 1;
            }
        }
        return count >= n;
    }
}
