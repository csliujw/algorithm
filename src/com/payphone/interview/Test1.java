package com.payphone.interview;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class Test1 {
    /**
     * 集合的用法还是不熟悉.
     * 如果内存存不下,就把它切分成多个list进行操作.
     *
     * @param vecA
     * @param vecB
     * @return
     */
    public List<String> getTheSameQQ(final List<String> vecA, final List<String> vecB) {
        TreeSet<String> vec1 = new TreeSet<>();
        TreeSet<String> vec2 = new TreeSet<>();
        vec1.addAll(vecA);
        vec2.addAll(vecB);
        vec1.retainAll(vec2);
        return new ArrayList<>(vec1);
    }

    public static void main(String[] args) {
        Test1 test1 = new Test1();
        ArrayList<String> str1 = new ArrayList<>();
        ArrayList<String> str2 = new ArrayList<>();
        str1.add("695466632");
        str1.add("695466631");
        str1.add("695466630");
        str1.add("695466629");
        str2.add("695466632");
        str2.add("46846468");
        str2.add("456481351");
        str2.add("456400454");
        List<String> theSameQQ = test1.getTheSameQQ(str1, str2);
        theSameQQ.forEach(System.out::printf);
    }
}
