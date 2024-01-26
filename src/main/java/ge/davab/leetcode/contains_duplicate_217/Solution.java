package ge.davab.leetcode.contains_duplicate_217;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> numbers = new HashSet<>();

        for (int num: nums) {
            if (!numbers.add(num)) return true;
        }

        return false;
    }
}
