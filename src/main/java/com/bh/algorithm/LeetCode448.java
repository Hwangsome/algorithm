package com.bh.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * 给你一个含 n 个整数的数组 nums ，其中 nums[i] 在区间 [1, n] 内。请你找出所有在 [1, n] 范围内但没有出现在 nums 中的数
 * 字，并以数组的形式返回结果。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：nums = [4,3,2,7,8,2,3,1]
 * 输出：[5,6]
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：nums = [1,1]
 * 输出：[2]
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * n == nums.length
 * 1 <= n <= 10⁵
 * 1 <= nums[i] <= n
 * <p>
 * <p>
 * 进阶：你能在不使用额外空间且时间复杂度为 O(n) 的情况下解决这个问题吗? 你可以假定返回的数组不算在额外空间内。
 * <p>
 * 为人贵在“实”，工作贵在“专”，学习贵在“恒”。
 */

public class LeetCode448 {
    public static void main(String[] args) {
        int nums[] = {4, 3, 2, 7, 8, 2, 3, 1};
//        leetCode448_1(nums).stream().forEach(System.out::println);
//        leetCode448_2(nums).stream().forEach(System.out::println);
//        leetCode448_3(nums).stream().forEach(System.out::println);
        leetCode448_4(nums).stream().forEach(System.out::println);
    }


    /**
     * 遍历数组，将每个数字交换到他理应出现的位置上，下面情况不用交换
     *
     * @param nums
     * @return
     */
    public static List<Integer> leetCode448_4(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int i = 0;
        while (i < nums.length) {
            if (nums[i] == i + 1) {
                i++;
                continue;
            }

            // 这个位置上的数字不是理应存储的位置，找出这个数字理应出现在哪个位置下（索引）
            int idealIdx = nums[i] - 1;
            //在判断数组中的数字是不是理应出现的位置
            if (nums[i] == nums[idealIdx]) {
                i++;
                continue;
            }
            /**
             * 交换数组中的数字，将数字放到正确的位置
             */
            int tmp = nums[i];
            nums[i] = nums[idealIdx];
            nums[idealIdx] = tmp;
        }
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != j + 1) {
                res.add(j + 1);
            }
        }
        return res;
    }

    public static List<Integer> leetCode448_3(int[] nums) {
        // 无关元素
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] <= 0 ? nums.length + 1 : nums[i];
        }
        // 原地标记
        for (int i = 0; i < nums.length; i++) {
            if (Math.abs(nums[i]) <= nums.length) {
                int a = nums[Math.abs(nums[i]) - 1];
                nums[Math.abs(nums[i]) - 1] = Math.min(-a, a);
            }
        }
        // 查找结果
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                result.add(i + 1);
            }
        }
        return result;

    }


    /**
     * 遍历nums，每遇到一个数 x，就让 nums[x-1] 增加 n。由于 nums 中所有数均在[1,n] 中，
     * 增加以后，这些数必然大于 n。最后我们遍历 nums，
     * 若 nums[i] 未大于 n，就说明没有遇到过数i+1。这样我们就找到了缺失的数字。
     * <p>
     * 思路就是将数组中的元素放到合适的位置
     *
     * @param nums
     * @return
     */
    public static List<Integer> leetCode448_2(int[] nums) {
        int n = nums.length;
        for (int num : nums) {
            //表示数组中的每个元素应该放在哪个下标中，{4, 3, 2, 7, 8, 2, 3, 1}; 比如4应该放在下标为 4-1 =3 的位置
            // 数组中没有进行加操作的数字就说明那个数字不应该放那里，就是数组中缺失的数字
            int x = (num - 1) % n;
            nums[x] += n;
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (nums[i] <= n) {
                result.add(i + 1);
            }
        }
        return result;
    }

    public static List<Integer> leetCode448_1(int[] nums) {
        HashSet<Integer> result = new HashSet<>();
        for (int i = 1; i <= nums.length; i++) {
            result.add(i);
        }
//        result.stream().forEach(System.out::println);
//        System.out.println("===");
        for (int i = 0; i < nums.length; i++) {
            if (result.contains(nums[i])) {
                result.remove(nums[i]);
            }
        }
//        result.stream().forEach(System.out::println);
        ArrayList<Integer> integers = new ArrayList<>(result);
        return integers;
    }

}
