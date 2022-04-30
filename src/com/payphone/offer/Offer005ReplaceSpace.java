package com.payphone.offer;

public class Offer005ReplaceSpace {
    public static void main(String[] args) {
        Offer005ReplaceSpace replaceSpace = new Offer005ReplaceSpace();
        System.out.println(replaceSpace.replaceSpace("Hello world ajva"));
    }

    public String replaceSpace(String s) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ') str.append(s.charAt(i));
            else str.append("%20");
        }
        return str.toString();
    }
}
