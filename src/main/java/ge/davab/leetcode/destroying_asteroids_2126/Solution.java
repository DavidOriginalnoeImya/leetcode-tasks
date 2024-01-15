package ge.davab.leetcode.destroying_asteroids_2126;

class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        int[] astMasses = new int[100001];

        for (int asteroid: asteroids) {
            if (mass >= asteroid) {
                mass += asteroid;
            } else {
                ++astMasses[asteroid];
            }
        }

        for (int i = 1; i < astMasses.length; ++i) {
            if (astMasses[i] != 0) {
                if (mass >= i) {
                    mass += i * astMasses[i];
                } else {
                    return false;
                }
            }
        }

        return true;
    }
}
