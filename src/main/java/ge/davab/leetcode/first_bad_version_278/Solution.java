package ge.davab.leetcode.first_bad_version_278;

class VersionControl {
    public boolean isBadVersion(int ver) {
        return ver >= 1702766719;
    }
}

public class Solution extends VersionControl {

    public int firstBadVersion(int n) {
        return firstBadVersion(1, n);
    }

    private int firstBadVersion(int f, int l) {
        int m = f + (l - f) / 2;

        if (isBadVersion(m)){
            if (m == 1 || (m > 1 && !isBadVersion(m - 1))) return m;
            return firstBadVersion(f, m - 1);
        } else {
            return firstBadVersion(m + 1, l);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.firstBadVersion(2126753390));
    }
}
