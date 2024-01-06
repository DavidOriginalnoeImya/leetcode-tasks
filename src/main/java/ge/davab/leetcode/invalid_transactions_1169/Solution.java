package ge.davab.leetcode.invalid_transactions_1169;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

class Solution {
    public List<String> invalidTransactions(String[] transactions) {
        Set<Integer> invalidTransactionPos = new HashSet<>();

        for (int i = 0; i < transactions.length; ++i) {
            String[] fTrData = transactions[i].split(",");

            if (Integer.parseInt(fTrData[2]) > 1000) {
                invalidTransactionPos.add(i);
            }

            for (int j = i + 1; j < transactions.length; ++j) {
                String[] sTrData = transactions[j].split(",");

                int timeDiff = Math.abs(Integer.parseInt(fTrData[1]) - Integer.parseInt(sTrData[1]));

                if (fTrData[0].equals(sTrData[0]) && timeDiff <= 60 && !fTrData[3].equals(sTrData[3])) {
                    invalidTransactionPos.add(i);
                    invalidTransactionPos.add(j);
                }
            }
        }

        return invalidTransactionPos.stream()
                .map(pos -> transactions[pos])
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.invalidTransactions(new String[] {"alice,20,800,mtv","alice,50,100,beijing"}));
    }

}