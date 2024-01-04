package ge.davab.leetcode.path_crossing_1496;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {

    private static class Point {
        private final int x;

        private final int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof Point p)) return false;

            return x == p.x && y == p.y;
        }

        @Override
        public int hashCode() {
            return 31 * Integer.hashCode(x) + Integer.hashCode(y);
        }
    }

    public boolean isPathCrossing(String path) {
        Set<Point> points = new HashSet<>();
        points.add(new Point(0, 0));

        int x = 0, y = 0;

        Map<Character, Integer> xDir = Map.ofEntries(
                Map.entry('N', 0), Map.entry('S', 0),
                Map.entry('E', 1), Map.entry('W', -1)
        );

        Map<Character, Integer> yDir = Map.ofEntries(
                Map.entry('N', 1), Map.entry('S', -1),
                Map.entry('E', 0), Map.entry('W', 0)
        );

        for (int index = 0; index < path.length(); ++index) {
            x += xDir.get(path.charAt(index));
            y += yDir.get(path.charAt(index));

            Point point = new Point(x, y);

            if (points.contains(point)) return true;

            points.add(point);
        }

        return false;
    }
}
