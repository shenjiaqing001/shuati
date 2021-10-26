/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/10/25
 */
public class lc1603 {
    class ParkingSystem {
        int[] slot = new int[4];

        public ParkingSystem(int big, int medium, int small) {
            slot[1] = big;
            slot[2] = medium;
            slot[3] = small;
        }

        public boolean addCar(int carType) {
            if (slot[carType] <= 0) return false;
            slot[carType]--;
            return true;
        }
    }
}
