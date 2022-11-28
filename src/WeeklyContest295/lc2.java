package WeeklyContest295;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 5/28/22
 */
public class lc2 {
    public String discountPrices(String sentence, int discount) {
        String[] strs = sentence.split(" ");
        for (int i = 0; i < strs.length; ++i) {
            if (strs[i].charAt(0) == '$' && strs[i].length() > 1) {
                String tmpNumber = strs[i].substring(1);
                if (!tmpNumber.startsWith("0")) {
                    try {
                        long number = Long.parseLong(tmpNumber);
                        number *= (100 - discount);
                        if (number % 100 < 10) {
                            strs[i] = "$" + number / 100 + ".0" + (number % 100);
                        } else {
                            strs[i] = "$" + number / 100 + "." + (number % 100);
                        }
                    } catch (Exception e) {

                    }
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(strs[0]);
        for (int i = 1; i < strs.length; ++i) {
            stringBuilder.append(" ");
            stringBuilder.append(strs[i]);
        }
        return stringBuilder.toString();
    }
}
