package com.algorithm.binarytree;

/**
 * xiaOgang
 */
public class Recursion {

    public int factorial(int n) {
        if (n == 0) return 1;

        return factorial(n - 1) * n;
    }

    /**
     * 尾递归，需要多一个参数保存计算状态
     * 一些语言对尾递归有优化，可以节约栈调用空间
     * Java不支持尾递归的优化
     *
     * @param n
     * @param acc
     * @return 阶乘结果
     */
    public int factorial(int n, int acc) {
        if (n == 0) return acc;

        return factorial(n - 1, acc * n);
    }

    public static void main(String[] args) {

        System.out.println(new Recursion().factorial(6));
        System.out.println(new Recursion().factorial(6, 1));

    }
}
