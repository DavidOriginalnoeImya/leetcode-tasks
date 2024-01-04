package ge.davab.leetcode.calculate_money_in_leetcode_bank_1716;

class Solution {
    public int totalMoney(int n) {
        int weeks = (int) Math.ceil((double) n / 7);
        double totalMoney = 0;

        for (int week = 1; week <= weeks; ++week) {
            int days = Math.min(n, 7);
            totalMoney += (double)  days / 2 * (2 * week + days - 1);
            n -= 7;
        }

        return (int)totalMoney;
    }
}
