package ge.davab.leetcode.bitwise_and_of_numbers_range_201;

import java.util.List;

class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        if (left == right) return left;

        List<Integer> powOfTwo = List.of(
                1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024,
                2048, 4096, 8192, 16384, 32768, 65536, 131072,
                262144, 524288, 1048576, 2097152, 4194304, 8388608,
                16777216, 33554432, 67108864, 134217728, 268435456,
                536870912, 1073741824, 2147483647
        );

        int rightIndex = 0;

        for (; right > powOfTwo.get(rightIndex); ++rightIndex);

        if (powOfTwo.get(rightIndex) == right && right != 2147483647) return 0;

        if (powOfTwo.get(rightIndex - 1) == left) return left;

        if (powOfTwo.get(rightIndex - 1) > left) return 0;

        int num = left;

        for (int count = num + 1; count <= right && count != -2147483648; ++count) {
            num &= count;
        }

        return num;
    }
}
