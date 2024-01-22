package ge.davab.leetcode.set_mismatch_645;

class Solution {
    public int[] findErrorNums(int[] nums) {
        int[] numFreq = new int[nums.length + 1];

        for (int num: nums) {
            ++numFreq[num];
        }

        int loss = 0, rep = 0;

        for (int i = 1; i < numFreq.length; ++i) {
            if (numFreq[i] == 0) {
                loss = i;
            } else if (numFreq[i] == 2) {
                rep = i;
            }
        }

        return new int[] {rep, loss};
    }
}
