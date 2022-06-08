package com.bh.algorithm;

import java.util.Arrays;

/**
 * 给定两个排序后的数组 A 和 B，其中 A 的末端有足够的缓冲空间容纳 B。 编写一个方法，将 B 合并入 A 并排序。
 *
 *  初始化 A 和 B 的元素数量分别为 m 和 n。
 *
 *  示例:
 *
 *  输入:
 * A = [1,2,3,0,0,0], m = 3
 * B = [2,5,6],       n = 3
 *
 * 输出: [1,2,2,3,5,6]
 *
 *  说明:
 *
 *
 *  A.length == n + m
 */
public class LeetCode88 {
    public static void main(String[] args) {
        int[] nums1 = {1, 7, 8, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        leetCode88(nums1, 3, nums2, 3);
    }

    public static void leetCode88(int[] nums1, int m, int[] nums2, int n) {
        int tmp[] = new int[m + n];

        /**
         * 双指针
         */
        for (int nums1Index = 0, nums2Index = 0, index = 0; index < tmp.length; index++) {
            if (nums1Index >= m) {
                tmp[index] = nums2[nums2Index++];
            } else if (nums2Index >= n) {
                tmp[index] = nums1[nums1Index++];
            } else if (nums1[nums1Index] >= nums2[nums2Index]) {
                tmp[index] = nums2[nums2Index];
                nums2Index++;
            } else if (nums1[nums1Index] < nums2[nums2Index]) {
                tmp[index] = nums1[nums1Index];
                nums1Index++;
            }
        }
        Arrays.stream(tmp).forEach(value -> System.out.println(value));
    }
}
