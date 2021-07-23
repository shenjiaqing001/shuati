/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/7/17
 */
public class lc927 {
    public int[] threeEqualParts(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; ++i) count += arr[i];
        if (count == 0) return new int[]{0, 2};
        if (count % 3 != 0) return new int[]{-1, -1};

        int rightRemain = count / 3;
        int rightIndex = arr.length - 1;
        while (true) {
            rightRemain -= arr[rightIndex];
            if (rightRemain == 0) break;
            rightIndex--;
        }

        // System.out.println(rightIndex);

        int leftIndex = 0;
        while (arr[leftIndex] == 0) leftIndex++;
        for (int i = rightIndex; i < arr.length; ++i) {
            if (arr[leftIndex] != arr[i]) return new int[]{-1, -1};
            leftIndex++;
        }
        // System.out.println(leftIndex);

        int middleIndex = leftIndex;
        while (arr[middleIndex] == 0) middleIndex++;
        for (int i = rightIndex; i < arr.length; ++i) {
            if (arr[middleIndex] != arr[i]) return new int[]{-1, -1};
            middleIndex++;
        }
        // System.out.println(middleIndex);
        return new int[]{leftIndex-1, middleIndex};
    }

    public static void main(String[] args) {
        lc927 test = new lc927();
        test.threeEqualParts(new int[]{1, 0, 1, 0, 1});
    }
}
