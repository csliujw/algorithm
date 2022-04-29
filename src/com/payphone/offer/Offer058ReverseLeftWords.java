package com.payphone.offer;

public class Offer058ReverseLeftWords {
    public String reverseLeftWords(String s, int n) {
        int len = s.length();
        s = s + s;
        return s.substring(n, len + n);
    }
}
