import java.util.*;

public class Calculation {

    public static void action() throws Exception {
        Converter converter = new Converter();
        String[] actions = {"+", "-", "/", "*"};
        String[] regexActions = {"\\+", "-", "/", "\\*"};
        String[] aegexActions = {"\\+", "-", "/", "\\*"};
        Scanner scn = new Scanner(System.in);
        //System.out.println;
        String exception = scn.nextLine();
        int actionIndex = -1;
        for (int i = 0; i < actions.length; i++) {
            if (exception.contains(actions[i])) {
                actionIndex = i;
                break;

            }
        }
        if (actionIndex == -1) {
            System.out.println("строка не являеться матиматической операцией");

        }
        String[] data = exception.split(regexActions[actionIndex]);

        if (data.length != 2) {
            throw new Exception(" формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        }
        if (converter.isRoman(data[0]) == converter.isRoman(data[1])) {
            int a, b;
            boolean isRoman = converter.isRoman(data[0]);
            if (isRoman) {
                a = converter.romanToInt(data[0]);
                b = converter.romanToInt(data[1]);
            } else {
                a = Integer.parseInt(data[0]);
                b = Integer.parseInt(data[1]);
            }
            int result;
            switch (actions[actionIndex]) {
                case "+":
                    result = a + b;
                    break;
                case "-":
                    result = a - b;
                    break;
                case "*":
                    result = a * b;
                    break;
                default:
                    result = a / b;
                    break;
            }

            if (isRoman) {

                System.out.println(converter.intToRoman(result));


            } else {
                System.out.println(result);
            }

        } else {
            System.out.println("используються одновременно разные системы счисления");

        }
    }
}