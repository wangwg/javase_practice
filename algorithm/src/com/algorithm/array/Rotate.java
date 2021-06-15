package com.algorithm.array;

/**
 * xiaOgang
 */
class SolutionRotate {
    public void rotate(int[][] matrix) {

        int length = matrix.length;

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][length - j - 1];
                matrix[i][length - j - 1] = temp;
            }
        }

    }
}

public class Rotate {
    public static void main(String[] args) {
        int[][] input = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        new SolutionRotate().rotate(input);

        for (int[] item : input) {
            for (int i : item) {
                System.out.print(i + "\t");
            }
            System.out.println();
        }
    }
}
