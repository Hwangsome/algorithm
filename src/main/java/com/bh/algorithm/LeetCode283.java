package com.bh.algorithm;

import java.util.Arrays;

public class LeetCode283 {

    public static void main(String[] args) {
        int nums[] = {0, 1, 0, 3, 12};
        leetCode283(nums);
    }

    /**
     * j来计算数组中有多少个0，初始化为0个0
     * i来遍历数组
     * @param nums
     */
    public static void leetCode283(int[] nums) {
        if (nums == null){
            return;
        }
        int j =0;
        for (int i = 0; i < nums.length; i++) {
            /**
             * 当遍历到非0的数的时候，将非零的数移动到j对应的下标中，再将j进行加操作
             */
            if (nums[i] !=0 ){
                nums[j++] = nums[i];
            }
        }
        for (int i = j; i <nums.length ; i++) {
            nums[i] =0;
        }
        Arrays.stream(nums).forEach(value -> System.out.println(value));
    }
}
