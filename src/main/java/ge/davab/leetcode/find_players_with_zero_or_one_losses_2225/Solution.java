package ge.davab.leetcode.find_players_with_zero_or_one_losses_2225;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        int[] playerLosses = new int[100000];;

        for (int[] match: matches) {
            if (playerLosses[match[0] - 1] == 0) {
                playerLosses[match[0] - 1] = -1;
            }

            if (playerLosses[match[1] - 1] == -1) {
                playerLosses[match[1] - 1] = 0;
            }

            ++playerLosses[match[1] - 1];
        }

        List<List<Integer>> winners = List.of(new LinkedList<>(), new LinkedList<>());

        for (int i = 0; i < playerLosses.length; ++i) {
            if (playerLosses[i] == -1) {
                winners.get(0).add(i + 1);
            } else if (playerLosses[i] == 1) {
                winners.get(1).add(i + 1);
            }
        }

        return winners;
    }
}
