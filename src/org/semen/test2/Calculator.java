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

        if (action == '*' || action == '/') {
            if (data[1].contains("\"")) throw new Exception("Строчку можно делить или умножать только на число");
        }

        for (int i = 0; i < data.length; i++) {
            data[i] = data[i].replace("\"", "");
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
}