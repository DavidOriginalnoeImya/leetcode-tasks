package ge.davab.leetcode.h_index_2_275;

class Solution {
    public int hIndex(int[] citations) {
        return binaryHIndex(citations, -1, 0, citations.length - 1);
    }

    public int binaryHIndex(int[] citations, int curHIndex, int left, int right) {
        if (right < left) return curHIndex;

        int mid  = (left + right) / 2;

        if (citations[mid] == citations.length - mid) return citations[mid];

        int newHIndex = Math.max(curHIndex, Math.min(citations[mid], citations.length - mid));

        if (right == left) return newHIndex;

        if (citations[mid] > citations.length - mid) {
            return binaryHIndex(citations, newHIndex, left, mid - 1);
        }

        if (citations[mid] < citations.length - mid) {
            return binaryHIndex(citations, newHIndex, mid + 1, right);
        }

        return newHIndex;
    }
}
