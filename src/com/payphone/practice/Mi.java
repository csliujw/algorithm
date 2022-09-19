package com.payphone;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Mi {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String s = reader.readLine();
            String[] array = s.split(" ");
            for (int start =0,end=array.length-1 ; start <end ;start++,end--) {
                if(array[start].equals(array[end])) continue;
                else {
                    System.out.println("False");
                    return;
                }
            }
            System.out.println("True");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
