package ge.davab.leetcode.destination_city_1436;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public String destCity(List<List<String>> paths) {
        Set<String> escapeCities = new HashSet<>();
        Set<String> nonEscapeCities = new HashSet<>();

        for (List<String> path: paths) {
            escapeCities.add(path.get(0));
            nonEscapeCities.remove(path.get(0));

            if (!escapeCities.contains(path.get(1))) {
                nonEscapeCities.add(path.get(1));
            }
        }

        return nonEscapeCities.stream()
                .findFirst().get();
    }
}
