package ge.davab.leetcode.student_attendance_record_1_551;

class Solution {
    public boolean checkRecord(String s) {
        int absent = 0, maxLate = 0, curLate = 0;

        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == 'L') {
                ++curLate;
            } else {
                if (s.charAt(i) == 'A') {
                    ++absent;
                }

                if (curLate > maxLate) maxLate = curLate;

                curLate = 0;
            }
        }

        if (curLate > maxLate) maxLate = curLate;

        return maxLate < 3 && absent < 2;
    }
}
