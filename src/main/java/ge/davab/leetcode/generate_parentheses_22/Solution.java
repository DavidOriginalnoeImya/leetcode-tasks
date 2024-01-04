package ge.davab.leetcode.generate_parentheses_22;

import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> parenthesis = new LinkedList<>();
        String curComb = "(";
        generateParenthesis(curComb, n - 1, n, parenthesis);
        return parenthesis;
    }

    public void generateParenthesis(String curComb, int open, int close, List<String> parenthesis) {
        if (open == 0 && close == 0) parenthesis.add(curComb);
        if (open != 0 && open <= close) generateParenthesis(curComb + "(", open - 1, close, parenthesis);
        if (close != 0) generateParenthesis(curComb + ")", open, close - 1, parenthesis);
    }
}
