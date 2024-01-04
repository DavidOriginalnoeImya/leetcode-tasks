package ge.davab.leetcode.minimum_penalty_for_a_shop_2483;

class Solution {
    public int bestClosingTime(String customers) {
        int penalty = 0;

        for (int index = 0; index < customers.length(); ++index) {
            if (customers.charAt(index) == 'Y') ++penalty;
        }

        int minPenalty = penalty, minPenaltyHour = 0;

        for (int index = 0; index < customers.length(); ++index) {
            if (customers.charAt(index) == 'Y') --penalty;
            else ++penalty;

            if (penalty < minPenalty) {
                minPenalty = penalty;
                minPenaltyHour = index + 1;
            }
        }

        return minPenaltyHour;
    }
}
