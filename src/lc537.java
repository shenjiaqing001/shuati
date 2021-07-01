/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/7/1
 */
public class lc537 {
    public String complexNumberMultiply(String num1, String num2) {
        int d1 = Integer.parseInt(num1.split("\\+")[0]);
        int d2 = Integer.parseInt(num1.split("\\+")[1].replace("i", ""));
        int d3 = Integer.parseInt(num2.split("\\+")[0]);
        int d4 = Integer.parseInt(num2.split("\\+")[1].replace("i", ""));

        //(a + bi) ( c + di) = ac-bd+(ad+bc)i;
        return (d1 * d3 - d2 * d4) + "+" + (d1 * d4 + d2 * d3) + "i";
    }
}
