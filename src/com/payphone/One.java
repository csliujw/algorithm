package com.payphone;

import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.nextLine(); // pass
        String[] str = sc.nextLine().split(" ");
        int[] ans = new int[str.length];
        int sum = 0;
        int retVAl = 0;
        for (int i = 0; i < str.length; i++) {
            ans[i] = Integer.parseInt(str[i]);
            sum ^= ans[i];
            retVAl += ans[i];
        }
        if (sum != 0) System.out.println(-1);
        Arrays.sort(ans);
        System.out.println(retVAl - ans[0]);
    }
}
