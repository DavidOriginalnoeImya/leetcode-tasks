package ge.davab.leetcode.minimum_number_of_increments_on_subarrays_to_form_a_target_array_1526;

class Solution {
    public int minNumberOperations(int[] target) {
        if (target.length <= 1) return target[0];

        int opNum = target[0], cur = 0;

        while (cur < target.length - 1 && target[cur] < target[cur + 1]) {
            opNum = target[++cur];
        }

        for (int index = cur + 1; index < target.length; ++index) {
            if (target[index - 1] < target[index]) {
                opNum += target[index] - target[index - 1];
            }
        }

        return opNum;
    }
}