package com.payphone.offer2;

public class Offer034IsAlienSorted {
    public boolean isAlienSorted(String[] words, String order) {
        int[] map = new int[26];
        for (int i = 0; i < order.length(); i++) {
            map[order.charAt(i) - 'a'] = i;
        }
        // 判断是排序，前一个比后一个小就行
        for (int i = 0; i < words.length - 1; i++) {
            if (!preSmallNext(words[i], words[i + 1], map)) return false;
        }
        return true;
    }

    public boolean preSmallNext(String pre, String next, int[] map) {
        int length = Math.min(pre.length(), next.length());
        // 比较两个单词的大小。如果相等则继续比较，如果不相等则返回比较结果
        for (int i = 0; i < length; i++) {
            int preChar = map[pre.charAt(i) - 'a'];
            int nextChar = map[next.charAt(i) - 'a'];
            if (preChar == nextChar) continue;
            if (preChar < nextChar) return true;
            else return false;
        }
        // 前缀全部相同，则len短的小
        if (pre.length() <= next.length()) return true;
        return false;
    }

    public static void main(String[] args) {
        Offer034IsAlienSorted solution = new Offer034IsAlienSorted();
        String[] words = {"apple", "app"};
        String order = "abcdefghijklmnopqrstuvwxyz";
        System.out.println(solution.isAlienSorted(words, order));
    }
}
