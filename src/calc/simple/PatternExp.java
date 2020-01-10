package calc.simple;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternExp {

    public static boolean isPat;
    public static boolean isArab;
    public static boolean isRoman;

    static void isExp(String input) { //оценка пользовательского ввода
        Pattern patExp = Pattern.compile("(\\d+|[IVXLCD]+)(\\s[\\*/\\+-]\\s)(\\d+|[IVXLCD]+)"); //шаблон выражения
        Matcher mExp = patExp.matcher(input);
        isPat = mExp.matches();     //Соответсвует или нет выражение шаблону?
        Pattern patArab = Pattern.compile("(\\d+\\s)([\\*/\\+-])(\\s\\d+)"); //шаблон для определения ввода арабских чисел
        Matcher mArab = patArab.matcher(input);
        isArab = mArab.matches();   //Есть ли в выражение арабские числа?
        Pattern patRoman = Pattern.compile("([IVXLCD]+\\s)([\\*/\\+-])(\\s[IVXLCD]+)"); //шаблон для определения ввода римских чисел
        Matcher mRoman = patRoman.matcher(input);
        isRoman = mRoman.matches(); //Есть ли в выражение римские числа?
        if (!isPat) {
            /*Проверка введенного выражения на соответствие шаблону*/
            throw new ArithmeticException("\nThe expression '" + input + "' doesn't match the pattern.");
        } else if (isArab == isRoman) {
            /*Проверка введенного выражения на принадлежность чисел к арабским или римским*/
            throw new ArithmeticException("\nThe expression '" + input + "' has different numerals.");
        }
    }
}
