package ge.davab.leetcode.number_of_dice_rolls_with_target_sum_1155;

class Solution {
    public int numRollsToTarget(int n, int k, int target) {
        int[] rolls = new int[target];

        for (int face = 0; face < k && face < target; ++face) {
            rolls[face] = 1;
        }

        int modulo = 1000000007;

        for (int dice = 1; dice < n; ++dice) {
            int[] _rolls = new int[target];

            for (int face = 0; face < k; ++face) {
                for (int roll = dice + face; roll < target; ++roll) {
                    _rolls[roll] = (_rolls[roll] % modulo) + (rolls[roll - face - 1] % modulo);
                }
            }

            rolls = _rolls;
        }

        return rolls[rolls.length - 1] % modulo;
    }
}
