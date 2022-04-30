package com.payphone.leetcode;

/**
 * https://leetcode-cn.com/problems/longest-common-prefix/
 */
public class N0014LongestCommonPrefix {
    public static void main(String[] args) {
        N0014LongestCommonPrefix longestCommonPrefix = new N0014LongestCommonPrefix();
        String[] str = {"fliower", "fliow", "flight"};
        String s = longestCommonPrefix.longestCommonPrefix(str);
        System.out.println(s);
    }

    /**
     * 先拿出一个字符串。用它与其他的找最长的前缀
     *
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs == null) return null;
        if (strs.length == 1) return strs[0];
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            for (int j = 0; j < prefix.length() && j < strs[i].length(); j++) {
                if (prefix.charAt(j) != strs[i].charAt(j)) prefix = strs[i].substring(0, j);
            }
            if (prefix.length() > strs[i].length()) prefix = strs[i];
        }
        return prefix;
    }
}
