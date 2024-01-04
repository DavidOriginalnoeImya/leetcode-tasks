package ge.davab.leetcode.buy_two_chocolates_2706;

class Solution {
    public int buyChoco(int[] prices, int money) {
        int fLPrice = 101, sLPrice = 101;

        for (int price: prices) {
            if (price < fLPrice) {
                sLPrice = fLPrice;
                fLPrice = price;
            } else if (price < sLPrice) {
                sLPrice = price;
            }
        }

        return fLPrice + sLPrice <= money
                ? money - fLPrice - sLPrice
                : money;
    }
}
