package ge.davab.leetcode.word_break_139;

import java.util.*;

class Solution {

    public boolean wordBreak(String s, List<String> wordDict) {
        Map<Character, List<String>> dict = new HashMap<>();
        for (char ch = 'a'; ch <= 'z'; ++ch) dict.put(ch, new LinkedList<>());
        for (String word: wordDict) dict.get(word.charAt(0)).add(word);

        Set<Integer> lens = new HashSet<>(); lens.add(0);

        while (!lens.isEmpty()) {
            int len = lens.stream().findFirst().get();
            lens.remove(len);

            if (len == s.length()) return true;

            if (len < s.length()) {
                for (String word: dict.get(s.charAt(len))) {
                    if (len + word.length() <= s.length() &&
                            word.equals(s.substring(len, len + word.length()))
                    ) {
                        lens.add(len + word.length());
                    }
                }
            }
        }

        return false;
    }

//    public boolean wordBreak(String s, List<String> wordDict) {
//        for (char ch = 'a'; ch <= 'z'; ++ch) dict.put(ch, new LinkedList<>());
//        for (String word: wordDict) dict.get(word.charAt(0)).add(word);
//
//        Stack<Integer> strEnds = new Stack<>();
//        int strBeg = 0;
//
//        for (String word: dict.get(s.charAt(strBeg))) {
//            if (word.length() <= s.length() && word.equals(s.substring(strBeg, word.length()))) {
//                if (word.length() == s)
//
//
//                strEnds.add(strBeg); strBeg = word.length();
//            }
//        }
//
//        return wordBreak(s);
//    }

//    public boolean wordBreak(String s, List<String> wordDict) {
//        for (char ch = 'a'; ch <= 'z'; ++ch) dict.put(ch, new LinkedList<>());
//        for (String word: wordDict) dict.get(word.charAt(0)).add(word);
//        for (List<String> words: dict.values()) words.sort(Comparator.comparingInt(String::length));
//        return wordBreak(s);
//    }
//
//    private boolean wordBreak(String s) {
//        if ("".equals(s)) return true;
//
//        List<String> words = dict.get(s.charAt(0));
//
//        for (String word: words) {
//            if (word.length() <= s.length() && word.equals(s.substring(0, word.length()))) {
//                boolean canBeSeg = wordBreak(s.substring(word.length()));
//
//                if (canBeSeg) return true;
//            }
//        }
//
//        return false;
//    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.wordBreak(
                "aaaaaaaaaaaaaaaaaaaaaaaaabaab",
                List.of("aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa","ba"))
        );
    }
}
