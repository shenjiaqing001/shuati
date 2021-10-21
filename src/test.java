import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/1/20
 */
public class test {


    public static int mergeSort(int[] nums, int left, int right) {
        if (left == right) return 0;
        int mid = left + (right - left) / 2;
        int sumLeft = mergeSort(nums, left, mid);
        int sumRight = mergeSort(nums, mid + 1, right);
        int[] numsLeft = new int[mid - left + 1];
        int[] numsRight = new int[right - mid];
        for (int i = 0; i < mid - left + 1; ++i) {
            numsLeft[i] = nums[left + i];
        }
        for (int i = 0; i < right - mid; ++i) {
            numsRight[i] = nums[mid + 1 + i];
        }

        int index1 = 0;
        int index2 = 0;
        int preSum = 0;
        int itemsCount = 0;
        int total = sumLeft + sumRight;
        int index = 0;
        while (index1 < numsLeft.length && index2 < numsRight.length) {
            if (numsLeft[index1] <= numsRight[index2]) {
                nums[index + left] = numsLeft[index1];
                total += itemsCount * numsLeft[index1];
                index1++;
                index++;
            } else {
                nums[index + left] = numsRight[index2];
                preSum += numsRight[index2];
                itemsCount++;
                total += preSum;
                index2++;
                index++;
            }
        }

        while (index1 < numsLeft.length) {
            nums[index + left] = numsLeft[index1];
            total += itemsCount * numsLeft[index1];
            index1++;
            index++;
        }
        while (index2 < numsRight.length) {
            nums[index + left] = numsRight[index2];
            index2++;
            index++;
        }
        return total;
    }

    public static int min(List<List<String>> products, List<List<String>> discounts) {
        Map<String, List<String>> map = new HashMap<>();
        for (List<String> discount : discounts) {
            String tag = discount.remove(0);
            map.put(tag, discount);
        }

        int res = 0;
        for (List<String> product : products) {
            int ori = Integer.parseInt(product.remove(0));
            int min = ori;
            if (product.size() > 0) {
                for (String tag : product) {
                    List<String> discount = map.get(tag);
                    String type = discount.get(0);
                    if (type.equals("0")) {
                        min = Math.min(min, Integer.parseInt(discount.get(1)));
                    } else if (type.equals("1")) {
                        double dis = Double.valueOf(discount.get(1));
                        double num = min * (1 - dis);
                        int tmp = (int) Math.round(num);
                        min = Math.min(min, tmp);
                    } else {
                        min = Math.min(min, ori - Integer.parseInt(discount.get(1)));
                    }
                }
            }
            res += min;
        }
        return res;
    }

    public static int longest(String string) {
        int lastCount = 0;
        char nowNum = 'a';
        int nowCount = 0;
        int res = 0;
        for (char c : string.toCharArray()) {
            if (c == nowNum) {
                nowCount++;
            } else {
                res += Math.min(lastCount, nowCount);
                lastCount = nowCount;
                nowCount = 1;
                nowNum = c;
            }
        }
        res += Math.min(lastCount, nowCount);
        return res;
    }

    public static void main(String[] args) {
        String string = "ababcdefghijklmnoprstuvwxyzzzz";
        char[] c = string.toCharArray();
        int[] lastCharacter = new int[26];
        Arrays.fill(lastCharacter, -1);
//        int minLength = string.length() + 5;
        String res = "";
        for (int i = 0; i < c.length; ++i) {
            if (c[i] == 'a') {
                lastCharacter[0] = i;
            } else {
                lastCharacter[c[i] - 'a'] = lastCharacter[c[i] - 'a' - 1];
            }
            if (c[i] == 'z' && lastCharacter[25] != -1) {
//              minLength = Math.min(minLength, i - lastCharacter[25] + 1);
                if (res.equals("")) res = string.substring(lastCharacter[25], i + 1);
                else {
                    String subStr = string.substring(lastCharacter[25], i + 1);
                    if (subStr.length() < res.length()) res = subStr;
                }
            }
        }
        return;
    }

    public String gobang(int[][] pieces) {
        char[][] map = new char[10][10];
        for (int i = 0; i < 10; ++i) {
            for (int j = 0; j < 10; ++j) {
                map[i][j] = '_';
            }
        }

        for (int[] piece : pieces) {
            map[piece[0]][piece[1]] = piece[2] == 0 ? 'B' : 'A';
        }

        for (int i = 0; i < 10; ++i) {
            for (int j = 0; j < 10; ++j) {
                System.out.print(map[i][j] + "  ");
            }
            System.out.println();
        }

        return "";
    }

    public void test2() {
        System.out.println("123");

        System.out.println("123");

    }

}
