package com.example.brushalgorithmproblem.leetcodehot100;

import java.util.ArrayList;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/3/25 4:09 下午
 */
//完全平方数
public class lt279 {

    public static int reslult;

    //    这种枚举会超时
    public static int numSquares(int n) {

//        产生所有可用的完全平方数
        ArrayList<Integer> nums = new ArrayList<>();

        for (int i = (int) Math.sqrt(n); i >= 1; i--) {
            nums.add(i * i);
        }

//        初始化
        reslult = Integer.MAX_VALUE;
        dfs(nums, n, 0, 0);

        return reslult;

    }

    public static void dfs(ArrayList<Integer> nums, int n, int sum, int num) {

        if (sum == n) {
            reslult = Math.min(reslult, num);
        }

        if (sum > n) {
            return;
        }

        for (int i = 0; i < nums.size(); i++) {
            dfs(nums, n, sum + nums.get(i), num + 1);
        }

    }

    //    动态规划
    public static int numSquares1(int n) {

    }


//    建立m叉树+层序遍历

    public static int numSquares2(int n) {

    }


    public static void main(String[] args) {
        int n = 12;
        System.out.println(numSquares(n));

        System.out.println(numSquares1(n));

        System.out.println(numSquares2(n));
    }
}
