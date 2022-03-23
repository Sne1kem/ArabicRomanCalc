package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        // write your code here
        answer(7);
        String input = "0";
        Scanner scan = new Scanner(System.in);
        input = scan.nextLine();
        char[] input_char = check(input);
        char operation = operator(input_char);
        String near_values = String.valueOf(input_char);
        String[] values = near_values.split("[+-/*]");
        if (values.length <= 2) {
            String value1 = values[0];
            String value1cor = value1.trim();
            String value2 = "0";
            String value2cor;
            try {
                value2 = values[1];
            } catch (RuntimeException re) {
                answer(1);
                System.exit(0);
            }
            value2cor = value2.trim();
            boolean vCheck1, vCheck2;
            boolean Roman1 = IsRoman(value1cor);
            boolean Roman2 = IsRoman(value2cor);
            if (!Roman1 & !Roman2) {
                int a = parser(value1cor);
                int b = parser(value2cor);
                vCheck1 = match(a);
                vCheck2 = match(b);
                if (vCheck1 && vCheck2) {
                    int result = op(a, b, operation);
                    System.out.println(result);
                } else {
                    answer(2);
                }
            } else if (Roman1 & Roman2) {
                int a = translator(value1cor);
                int b = translator(value2cor);
                vCheck1 = match(a);
                vCheck2 = match(b);
                if (vCheck1 && vCheck2) {
                    retranslator(op(a, b, operation));
                } else {
                    answer(2);
                }
            } else answer(3);
        } else answer(4);

    }
    public static int op (int val1, int val2, char op){
        int result = 0;
        switch (op){
            case '+':{
                result = val1 + val2;
                break;
            }
            case '-':{
                result = val1 - val2;
                break;
            }
            case '*': {
                result = val1 * val2;
                break;
            }
            case '/': {
                    result = val1 / val2;
                break;
            }
            default: throw new IllegalArgumentException("Not an operation sign");
        }
        return result;
    }
    public static char[] check(String input) {
        char[] input_char = new char[10];
        try {
            for (int i = 0; i < input.length(); i++) {
                input_char[i] = input.charAt(i);
            }
        } catch (Exception ex) {answer(8); System.exit(0);};
        return input_char;
    }
    public static char operator(char[] input){
        char operation = '0';
        try {
            for (int i = 0; i < 10; i++) {
                if (input[i] == '+') {
                    operation = '+';
                }
                if (input[i] == '-') {
                    operation = '-';
                }
                if (input[i] == '*') {
                    operation = '*';
                }
                if (input[i] == '/') {
                    operation = '/';
                }
            }
        } catch (RuntimeException length){
            answer(6);
        }
        return operation;
    }
    public static boolean match(int value){
        char[] avail=new char [] {1,2,3,4,5,6,7,8,9,10};
        for(int i=0;i<10;i++){
            if(value==avail[i]){
                return true;
            }
        }
        return false;
    }
    public static int parser(String value){
        int parser=0;
        try {
            parser = Integer.parseInt(value);
        } catch (Exception ex) {
            System.out.println(value+" is not a integer value");
            System.exit(1);
        }
        return parser;
    }
    public static boolean IsRoman (String value){
        String[] roman = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};
        for(int i =0; i<roman.length;i++){
            if(roman[i].equals(value)){
                return true;
            }
        }
        return false;
    }
    public static int translator (String value) {
        String[] roman = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};
        for (int i = 0; i < roman.length; i++) {
            if (value.equals(roman[i])) {
                return i+1;
            }
        }
        return -1;
    }
    public static void retranslator (int value) {
        String[] roman = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"
        };
        try {
            System.out.println(roman[value-1]);
        } catch (Exception ex){
            answer(5);
        }
    }
    public static void answer (int value) {
        switch (value){
            case 1:
                System.out.println("Not a mathematics operation");
                break;
            case 2:
                System.out.println("Values are not match in a existence raw (1-10) or (I-X)");
                break;
            case 3:
                System.out.println("Calculator can's solve this operation because of different number system's");
                break;
            case 4:
                System.out.println("You have more then 2 values in operation");
                break;
            case 5:
                System.out.println("The answer is negative or 0, which is not possible in Roman system");
                break;
            case 6:
                System.out.println("The format of mathematics operation does not possible in this calculator, only 2 numbers with operation");
                break;
            case 7:
                System.out.println("Write a mathematics operation, like '2+2' ");
                break;
            case 8:
                System.out.println("Length of a mathematic operation is too big, try to right it shorter");
                break;
        }
    }
}
