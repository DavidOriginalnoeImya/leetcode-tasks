package ge.davab.leetcode.count_and_say_38;

class Solution {
    public String countAndSay(int n) {
        if (n == 1) return "1";

        String ans = countAndSay(n - 1);

        StringBuilder stringBuilder = new StringBuilder();
        int repNum = 1;
        char curSym = ans.charAt(0);

        for (int index = 1; index < ans.length(); ++index) {
            if (curSym != ans.charAt(index)) {
                stringBuilder.append(repNum); stringBuilder.append(curSym);
                curSym = ans.charAt(index);
                repNum = 1;
            }
            else {
                ++repNum;
            }
        }
        stringBuilder.append(repNum); stringBuilder.append(curSym);

        return stringBuilder.toString();
    }
}
