package org.semen.test2;


public class Calculator {
    public String calculate(String exp) throws Exception {
        char action;
        String[] data;
        if (exp.contains(" + ")) {
            data = exp.split(" \\+ ");
            action = '+';
        } else if (exp.contains(" - ")) {
            data = exp.split(" - ");
            action = '-';
        } else if (exp.contains(" * ")) {
            data = exp.split(" \\* ");
            action = '*';
        } else if (exp.contains(" / ")) {
            data = exp.split(" / ");
            action = '/';
        } else {
            throw new Exception("Некорректный знак действия");
        }

        if (!data[0].startsWith("\"") || !data[0].endsWith("\"")) {
            throw new Exception("Первым аргументом выражения, подаваемого на вход, должна быть строка. Пример \"Dad\"");
        }

        if (action == '*' || action == '/') {
            if (data[1].contains("\"")) throw new Exception("Строчку можно делить или умножать только на число");
        }

        for (int i = 0; i < data.length; i++) {
            data[i] = data[i].replace("\"", "");
            if (data[i].length() > 10) {
                throw new Exception("Строка длиннее 10 символов");
            }
        }

        if (action == '*' || action == '/') {
            if (!isInteger(data[1])) {
                throw new Exception("Калькулятор умеет работать только с целыми числами.");
            }
            int number = Integer.parseInt(data[1]);
            if (number < 1 || number > 10) {
                throw new Exception("Число должно быть от 1 до 10");
            }
        }



        switch (action) {
            case '+':
                return data[0] + data[1];
            case '*':
                return multiplyString(data[0], Integer.parseInt(data[1]));
            case '-':
                return subtractString(data[0], data[1]);
            case '/':
                return divideString(data[0], Integer.parseInt(data[1]));
            default:
                throw new Exception("Некорректный знак действия");
        }
    }

    private String multiplyString(String str, int multiplier) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < multiplier; i++) {
            result.append(str);
        }
        return result.toString();
    }

    private String subtractString(String str, String substr) {
        int index = str.indexOf(substr);
        if (index == -1) {
            return str;
        } else {
            return str.substring(0, index) + str.substring(index + substr.length());
        }
    }

    private String divideString(String str, int divisor) {
        int newLen = str.length() / divisor;
        return str.substring(0, newLen);
    }

    public static boolean isInteger(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            if (i == 0 && str.charAt(i) == '-') {
                if (str.length() == 1) {
                    return false;
                } else {
                    continue;
                }
            }
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}