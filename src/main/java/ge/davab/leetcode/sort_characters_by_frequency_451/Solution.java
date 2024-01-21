package ge.davab.leetcode.sort_characters_by_frequency_451;

import java.util.*;

class Solution {
    public String frequencySort(String s) {
        int[] frArr = new int[128];

        for (int i = 0; i < s.length(); ++i) {
            ++frArr[s.charAt(i)];
        }

        Queue<Character> chQueue = new PriorityQueue<>((c1, c2) ->
                -Integer.compare(frArr[c1], frArr[c2]));

        for (int i = 0; i < 128; ++i) {
            if (frArr[i] > 0) {
                chQueue.add((char)i);
            }
        }
        System.out.println(Arrays.toString(frArr));
        System.out.println(chQueue);
        StringBuilder strBuilder = new StringBuilder();

        while (!chQueue.isEmpty()) {
            char ch = chQueue.poll();
            strBuilder.append((ch + "").repeat(frArr[ch]));
        }

        return strBuilder.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.frequencySort("raaeaedere"));
    }
}
