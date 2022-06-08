package com.bh.algorithm;

import java.util.Arrays;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 *  请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 *
 *
 *
 *  示例 1:
 *
 *
 * 输入: nums = [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 *
 *
 *  示例 2:
 *
 *
 * 输入: nums = [0]
 * 输出: [0]
 *
 *
 *
 *  提示:
 *
 *
 *
 *  1 <= nums.length <= 10⁴
 *  -2³¹ <= nums[i] <= 2³¹ - 1
 *
 *
 *
 *
 *  进阶：你能尽量减少完成的操作次数吗？
 */
public class LeetCode283 {

    public static void main(String[] args) {
        int nums[] = {0, 1, 0, 3, 12,0,8};
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
