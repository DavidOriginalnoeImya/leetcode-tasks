package ge.davab.leetcode.find_players_with_zero_or_one_losses_2225;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        Map<Integer, Integer> players = new HashMap<>();

        for (int[] match: matches) {
            if (!players.containsKey(match[0])) players.put(match[0], 0);

            Integer playerLose = players.getOrDefault(match[1], 0);
            if (playerLose < 2)
                players.put(match[1], playerLose + 1);
        }

        List<List<Integer>> winners = List.of(new LinkedList<>(), new LinkedList<>());

        for (Map.Entry<Integer, Integer> entry: players.entrySet()) {
            if (entry.getValue() == 0) winners.get(0).add(entry.getKey());
            else if (entry.getValue() == 1) winners.get(1).add(entry.getKey());
        }
        winners.get(0).sort(Integer::compareTo);
        winners.get(1).sort(Integer::compareTo);

        return winners;
    }
}
