/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/9/30
 */
public class lc1274 {
    class Sea {
        public boolean hasShips(int[] topRight, int[] bottomLeft) {
            return true;
        }
    }

    public int countShips(Sea sea, int[] topRight, int[] bottomLeft) {
        if (sea.hasShips(topRight, bottomLeft) == false) return 0;
        if (topRight[0] == bottomLeft[0] && topRight[1] == bottomLeft[1]) return 1;

        int midX = (topRight[0] + bottomLeft[0]) / 2;
        int midY = (topRight[1] + bottomLeft[1]) / 2;

        return countShips(sea, new int[]{midX, midY}, bottomLeft) +
                countShips(sea, topRight, new int[]{midX + 1, midY + 1}) +
                countShips(sea, new int[]{midX, topRight[1]}, new int[]{bottomLeft[0], midY + 1}) +
                countShips(sea, new int[]{topRight[0], midY}, new int[]{midX + 1, bottomLeft[1]});
    }
}
