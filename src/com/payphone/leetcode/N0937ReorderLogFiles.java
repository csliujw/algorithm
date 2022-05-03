package com.payphone.leetcode;

import org.junit.Test;

import java.util.Arrays;

public class N0937ReorderLogFiles {

    @Test
    public void f1() {
        String[] s = {"dig1 8 1 5 1", "let1 art can", "dig2 3 6", "let2 own kit dig", "let art zero"};
        reorderLogFiles(s);
    }

    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (log1, log2) -> {
            // 重写比较器
            String sub1 = log1.substring(log1.indexOf(' ') + 1);
            String sub2 = log2.substring(log2.indexOf(' ') + 1);
            // 都是数字开头，保持不变
            if (Character.isDigit(sub1.charAt(0)) && Character.isDigit(sub2.charAt(0))) {
                return 0;
            } else if (Character.isDigit(sub1.charAt(0))) {
                return 1;
            } else if (Character.isDigit(sub2.charAt(0))) {
                return -1;
            }
            // 都是字符串
            int i = sub1.compareTo(sub2);
            return i == 0 ? log1.compareTo(log2) : i;
        });
        Arrays.stream(logs).forEach(System.out::println);
        return logs;
    }
}
