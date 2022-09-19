package com.payphone;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Mi2 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        String[] tmp = s.split(" ");
        int[] ints = new int[tmp.length];
        for (int i = 0; i <tmp.length ; i++) {
            ints[i] = Integer.parseInt(tmp[i]);
        }

        // 从两端拿薯片，看小米可以能不能获胜。
        // 贪心做一下，看可以过多少测试用例。
        int smallMi = 0,bigMi = 0;
        for (int start = 0,end = ints.length-1; start <=end ; ) {
            smallMi += (ints[start]>ints[end])?ints[start++]:ints[end--];
            if(start<=end) break;
            bigMi += (ints[start]>ints[end])?ints[start++]:ints[end--];
            if(start<=end) break;
        }
        if(smallMi>=bigMi) System.out.println("Yes");
        else System.out.println("No");
    }
}
