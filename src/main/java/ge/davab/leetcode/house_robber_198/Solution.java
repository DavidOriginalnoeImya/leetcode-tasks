package ge.davab.leetcode.house_robber_198;

class Solution {
    public int rob(int[] nums) {
        int[] money = new int[nums.length];

        for (int i = 0; i < money.length; ++i) {
            money[i] = -1;
        }

        int max = 0;

        for (int i = 0; i < nums.length; ++i) {
            int cur = rob(nums, money, i);
            if (cur > max) max = cur;
        }

        return max;
    }

    private int rob(int[] nums, int[] money, int house) {
        if (money[house] != -1) return money[house];

        for (int i = house + 2; i < nums.length; ++i) {
            int cur = rob(nums, money, i);
            if (cur > money[house]) money[house] = cur;
        }

        if (money[house] == -1) money[house] = 0;
        money[house] += nums[house];

        return money[house];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.rob(new int[]{
                0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0
        }));
    }
}
