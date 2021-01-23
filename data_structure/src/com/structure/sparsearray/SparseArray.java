package com.structure.sparsearray;

/**
 * 稀疏数组
 */
public class SparseArray {

    public static void main(String[] args) {

        // 待保存棋盘
        int x = 11;
        int y = 11;
        int[][] chess = new int[x][y];

        chess[1][2] = 1;
        chess[2][3] = 2;
        chess[6][9] = 2;

        // 输出待保存棋盘
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                System.out.print(chess[i][j]);
            }
            System.out.println();
        }

        System.out.println("******************");

        // 转换稀疏数组
        int sum = 0;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (chess[i][j] != 0) {
                    sum++;
                }
            }
        }

        int[][] sparseArray = new int[sum + 1][3];
        sparseArray[0][0] = x;
        sparseArray[0][1] = y;
        sparseArray[0][2] = sum;

        int count = 0;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (chess[i][j] != 0) {
                    count++;
                    sparseArray[count][0] = i;
                    sparseArray[count][1] = j;
                    sparseArray[count][2] = chess[i][j];
                }
            }
        }

        // 输出稀疏数组
        for (int i = 0; i < sum + 1; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(sparseArray[i][j] + "\t");
            }
            System.out.println();
        }

        System.out.println("******************");

        // 恢复棋盘
        int[][] chessNew = new int[sparseArray[0][0]][sparseArray[0][1]];

        for (int i = 0; i < sparseArray[0][2]; i++) {
            chessNew[sparseArray[i + 1][0]][sparseArray[i + 1][1]] = sparseArray[i + 1][2];
        }

        // 输出待保存棋盘
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                System.out.print(chessNew[i][j]);
            }
            System.out.println();
        }

    }

}
