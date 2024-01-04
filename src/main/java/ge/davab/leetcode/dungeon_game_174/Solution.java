package ge.davab.leetcode.dungeon_game_174;

class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        short maxShort = 0;

        for (int i = dungeon.length - 1; i >= 0; --i) {
            for (int j = dungeon[i].length - 1; j >= 0; --j) {
                int right = j + 1 < dungeon[i].length ? dungeon[i][j + 1] : maxShort;
                int bottom = i + 1 < dungeon.length ? dungeon[i + 1][j] : maxShort;

                if (dungeon[i][j] >= right || dungeon[i][j] >= bottom) {
                    dungeon[i][j] = 0;
                }
                else {
                    dungeon[i][j] = -(dungeon[i][j] - Math.min(right, bottom));
                }
                maxShort = Short.MAX_VALUE;
            }
        }

        return dungeon[0][0] + 1;
    }
}
