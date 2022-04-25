package com.payphone.offer2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Offer086Partition {

    @Test
    public void f1() {
        partition("bbbbbbbbbbbbbbb");
    }

    public String[][] partition(String s) {
        List<List<String>> result = new ArrayList<>();
        helper(s, 0, new ArrayList<>(), result);
        // result 转 String
        String[][] ans = new String[result.size()][];
        for (int i = 0; i < result.size(); i++) {
            String[] tmp = new String[result.get(i).size()];
            result.get(i).toArray(tmp);
            ans[i] = tmp;
        }
        return ans;
    }

    /**
     * start 这次从那个下标的字符开始枚举
     * cur 当前记录的部分解
     * result 返回的结果
     */
    private void helper(String s, int start, List<String> single, List<List<String>> result) {
        if (start == s.length()) {
            result.add(new LinkedList<>(single));
            return;
        }
        // 因为要枚举 g~google 所s以需要 for
        for (int i = start; i < s.length(); i++) {
            if (isP(s, start, i)) {
                single.add(s.substring(start, i + 1));
                helper(s, i + 1, single, result);
                single.remove(single.size() - 1);
            }
        }
    }

    // 判断回文串
    private boolean isP(String str, int start, int end) {
        while (start < end) {
            if (str.charAt(start++) != str.charAt(end--)) return false;
        }
        return true;
    }
}
