package com.payphone.leetcode;

import org.junit.Test;

public class _06_Convert {    public String convert(String s, int numRows) {
    char[] chars = s.toCharArray();
    int space = 2 * (numRows - 1);
    System.out.println(space);
    StringBuilder ans = new StringBuilder();
    for (int i = 0; i < numRows; i++) {
        if (i == 0 || i == numRows - 1) {
            int index = i;
            while (index < chars.length) {
                ans.append(chars[index]);
                index = index + space;
            }
        } else {
            int pre = i;
            int end = 2 * numRows - i - 2;
            System.out.println("end=" + end);
            while (pre < chars.length || end < chars.length) {
                if (pre < chars.length) ans.append(chars[pre]);
                if (end < chars.length) ans.append(chars[end]);
                pre += space;
                end += space;
            }
        }
    }
    return ans.toString();
}


    @Test
    public void t() {
        convert("0123456789", 3);
    }


}
