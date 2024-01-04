package ge.davab.leetcode.number_of_laser_beams_in_a_bank_2125;

class Solution {
    public int numberOfBeams(String[] bank) {
        int beamNum = 0, curRowSecDev = 0, prevRowSecDev = 0;

        for (String row: bank) {
            for (int cell = 0; cell < row.length(); ++cell) {
                if (row.charAt(cell) == '1') ++curRowSecDev;
            }

            beamNum += curRowSecDev * prevRowSecDev;

            if (curRowSecDev != 0) prevRowSecDev = curRowSecDev;

            curRowSecDev = 0;
        }

        return beamNum;
    }
}
