package calc.simple;

import java.util.regex.Pattern;

public class Split {

    public static String num1;
    public static String num2;
    public static String mathAct;

    static void splitExp(String input) { //разделение на состовляющии выражения
        Pattern patSymb = Pattern.compile("(\\s*[\\*/\\+-]\\s*)+"); //шаблон-разделитель: математические операции
        String[] nums = patSymb.split(input);
        num1 = nums[0];
        num2 = nums[1];
        Pattern patDig = Pattern.compile("\\s*(\\d|[IVXLCD])+\\s*"); //шаблон-разделитель: арабские и римские числа
        String[] opers = patDig.split(input);
        mathAct = opers[0];
       // return new String[]{nums[0], nums[1], opers[1]};
    }
}
