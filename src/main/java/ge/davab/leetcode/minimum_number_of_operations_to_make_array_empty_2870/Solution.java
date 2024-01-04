package ge.davab.leetcode.minimum_number_of_operations_to_make_array_empty_2870;

import java.util.Arrays;

class Solution {
    public int minOperations(int[] nums) {
        Arrays.sort(nums);

        int prevNum = nums[0], count = 1, opNum = 0;

        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] == prevNum) {
                ++count;
            } else {
                if (count > 1) {
                    while (count % 3 != 0 && count > 0) {
                        count -= 2; ++opNum;
                    }
                    opNum += count / 3;
                    count = 1; prevNum = nums[i];
                } else {
                    return -1;
                }
            }
        }

        if (count > 1) {
            while (count % 3 != 0 && count > 0) {
                count -= 2; ++opNum;
            }
            return opNum + count / 3;
        }

        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minOperations(new int[]{2,1,2,2,3,3}));
        System.out.println(-2 % 2);
    }
}