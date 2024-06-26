package org.semen.test1;

import java.util.TreeMap;

class Converter {

    TreeMap<Character, Integer>  romanKeyMap  = new TreeMap<>();
    TreeMap<Integer, String>  arabianKeyMap = new TreeMap<>();
    Converter() {
        romanKeyMap.put('I', 1);
        romanKeyMap.put('V', 5);
        romanKeyMap.put('X', 10);
        romanKeyMap.put('L', 50);
        romanKeyMap.put('C', 100);

        arabianKeyMap.put(100, "C");
        arabianKeyMap.put(90, "XC");
        arabianKeyMap.put(50, "L");
        arabianKeyMap.put(40, "XL");
        arabianKeyMap.put(10, "X");
        arabianKeyMap.put(9, "IX");
        arabianKeyMap.put(5, "V");
        arabianKeyMap.put(4, "IV");
        arabianKeyMap.put(1, "I");
    }
    boolean isRoman(String number) {
        return   romanKeyMap.containsKey(number.charAt(0));
    }
    String intToRoman(int number) {
        String roman = "";
        int arabianKey;
        if(number == -1) {
            System.out.println("");
        } else if(number < 1) {
                System.out.println(" в римской системе нет отрицательных чисел");
        }
        do {
            arabianKey = arabianKeyMap.floorKey(number);
            roman += arabianKeyMap.get(arabianKey);
            number -= arabianKey;
        } while(number != 0);
        return roman;
    }
    int romanToInt(String s) {
        int end = s.length() - 1;
        char[] arr = s.toCharArray();
        int arabian;
        int result = romanKeyMap.get(arr[end]);
        for (int i = end - 1; i >= 0; i--) {
            arabian = romanKeyMap.get(arr[i]);
            if (arabian < romanKeyMap.get(arr[i + 1])) {
                result -= arabian;
            } else {
                result += arabian;
            }
        }
        return result;

    }
}