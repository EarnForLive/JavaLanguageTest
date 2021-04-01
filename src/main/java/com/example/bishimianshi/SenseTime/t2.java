package com.example.bishimianshi.SenseTime;

import java.util.Arrays;

/**
 * @author Duan Xiangqing
 * @version 1.0
 * @date 2021/4/1 5:39 下午
 */
//商汤面试题
//题面：输入N= 13,返回: [1,10,11,12,13,2,3,4,5,6,7,8,9]，将这些数字按字典序排序
//自定义比较器
public class t2 {

    static class Node implements Comparable {
        String num;

        public Node(String num) {
            this.num = num;
        }

        @Override
        public int compareTo(Object o) {
            Node oo = (Node) o;
            int minlen = Math.min(oo.num.length(), num.length());
            for (int i = 0; i < minlen; i++) {
                if (num.charAt(i) == oo.num.charAt(i)) {
                    continue;
                }
                return Integer.valueOf(num.charAt(i)) - Integer.valueOf(oo.num.charAt(i));
            }
//            ???
            return 1;
        }
    }

    public static void domain(int[] nums) {
        Node[] nodes = new Node[nums.length];
        for (int i = 0; i < nums.length - 1; i++) {
            nodes[i] = new Node(String.valueOf(nums[i]));
        }

        Arrays.sort(nodes);

        for (Node node : nodes) {
            System.out.print(node.num + " ");
        }

        System.out.println();
    }


    public static void main(String[] args) {

        int N = 13;
        int[] nums = new int[N];
        for (int i = 1; i < N; i++) {
            nums[i - 1] = i;
        }

        domain(nums);
    }

}
