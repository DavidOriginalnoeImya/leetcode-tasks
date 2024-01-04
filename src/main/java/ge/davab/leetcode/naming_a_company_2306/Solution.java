package ge.davab.leetcode.naming_a_company_2306;

import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;
import java.util.stream.Collectors;

class Solution {
    public long distinctNames(String[] ideas) {
        Set<String> ideaSet = Arrays.stream(ideas)
                .collect(Collectors.toCollection(HashSet::new));

        int[][] poss = new int[26][26];

        for (String idea: ideas) {
            String ideaSub = idea.substring(1);

            for (char ch = 'a'; ch <= 'z'; ++ch) {
                if (!ideaSet.contains(ch + ideaSub)) {
                    ++poss[idea.charAt(0) - 97][ch - 97];
                }
            }
        }

        long distinctNames = 0;

        for (int index1 = 0; index1 < poss.length; ++index1) {
            for (int index2 = index1; index2 < poss[index1].length; ++index2) {
                distinctNames += 2L * poss[index1][index2] * poss[index2][index1];
            }
        }

        return distinctNames;
    }
}
