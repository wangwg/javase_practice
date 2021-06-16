package com.algorithm.string;

/**
 * xiaOgang
 */
class SolutionMultiply {
    public String multiply(String num1, String num2) {

        if (num1.equals("0") || num2.equals("0")) return "0";
        int[] resultArr = new int[num1.length() + num2.length()];

        for (int i = num1.length() - 1; i >= 0; i--) {
            int x = num1.charAt(i) - '0';
            for (int j = num2.length() - 1; j >= 0; j--) {
                int y = num2.charAt(j) - '0';
                int product = x * y;
                int temp = resultArr[i + j + 1] + product;
                resultArr[i + j + 1] = temp % 10;
                resultArr[i + j] += temp / 10;
            }
        }
        StringBuffer result = new StringBuffer();
        int start = resultArr[0] == 0 ? 1 : 0;
        for (int i = start; i < resultArr.length; i++) {
            result.append(resultArr[i]);
        }
        return result.toString();
    }
}

public class Multiply {
    public static void main(String[] args) {
        String num1 = "3";
        String num2 = "19";

        System.out.println(new SolutionMultiply().multiply(num1, num2));
    }
}
