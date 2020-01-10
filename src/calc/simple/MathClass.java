package calc.simple;

public class MathClass {
    static void calcThis(String input) {
        PatternExp.isExp(input); //Определение введенных чисел как арабских или римских
        Split.splitExp(input);	//Разделение на составляющии введеного выражения
        int num1 = 0;
        int num2 = 0;
        if ((PatternExp.isArab) && (!PatternExp.isRoman)) { //Если оба числа арабские
            num1 = Integer.parseInt(Split.num1);
            num2 = Integer.parseInt(Split.num2);
        } else if ((!PatternExp.isArab) && (PatternExp.isRoman)) { //Если оба числа римские
            num1 = Convert.convertToArab(Split.num1);
            num2 = Convert.convertToArab(Split.num2);
        }
        if ((num1 > 10) | (num2 > 10) | (num1 < 1) | (num2 < 1)) {
            /*Проверка соответсвия введенных чисел - от 1 до 10*/
            throw new ArithmeticException("\n'" + num1 + "' or '" + num2 + "' are not from 1 to 10." );
        } else if (num2 >= num1 & Split.mathAct.equals("-") & PatternExp.isRoman) {
            /*Проверка римских чесел на возможность получения отрицательных значений*/
            throw new ArithmeticException("\n'" + num2 + "' is greater than or equal to '" + num1 + "'.");
        } else {
            int res = 0;
            switch (Split.mathAct) {
                case "+": res = num1 + num2;
                    break;
                case "-": res = num1 - num2;
                    break;
                case "*": res = num1 * num2;
                    break;
                case "/": res = num1 / num2;
                    if (num1 % num2 > 0) {
                        /*Проверка чесел на возможность получения дробных значений*/
                        throw new ArithmeticException("\nThe answer is not integer.");
                    } else {
                        break;
                    }
                default: System.out.println("I can't calculate it...");
            }
            String resStr = Integer.toString(res);
            if ((PatternExp.isArab) && (!PatternExp.isRoman)) {
                System.out.println("The answer is '" + resStr + "' of Arabic numerals.");
            } else if ((!PatternExp.isArab) && (PatternExp.isRoman)) {
                String romanRes = Convert.convertToRoman(resStr);
                System.out.println("The answer is '" + romanRes + "' of Roman numerals.");
            }
        }
    }
}
