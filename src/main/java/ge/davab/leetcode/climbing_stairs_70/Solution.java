package ge.davab.leetcode.climbing_stairs_70;

class Solution {
    public int climbStairs(int n) {
        int[] stairs = new int[n + 1]; stairs[0] = stairs[1] = 1;

        for (int stair = 2; stair <= n; ++stair) {
            stairs[stair] = stairs[stair - 1] + stairs[stair - 2];
        }

        return stairs[n];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.climbStairs(10));
    }
}
