package com.payphone.offer;

public class Offer058ReverseWords1 {
    public static void main(String[] args) {
        Offer058ReverseWords1 reverseWords = new Offer058ReverseWords1();
        String s = reverseWords.reverseWords("a good   example");
        System.out.println(s);
    }

    public String reverseWords(String s) {
        s = s.trim();
        if (s.length() == 0 || s.length() == 1) return s;
        char[] chars = s.toCharArray();
        int length = chars.length - 1;
        // i 前指针， j 后指针
        String retVal = "";
        for (int i = length, j = length; i >= 0; ) {
            while (chars[i] != ' ' && i > 0) i--;
            if (i == 0) {
                retVal += s.substring(i, j + 1);
                break;
            } else retVal += s.substring(i + 1, j + 1) + " ";
            while (chars[i] == ' ' && i > 0) i--;
            j = i;
        }
        return retVal;
    }

    public String reverseWords1(String s) {
        // 去除前后空格
        s = s.trim();
        if (s.length() == 0 || s.length() == 1) return s;
        String str = "";
        str += s.charAt(0);
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == ' ' && s.charAt(i + 1) == ' ') continue;
            str += s.charAt(i + 1);
        }
        char[] chars = str.toCharArray();
        //
        // 再进行单词反转。 先整体翻转一次，再每个单词翻转一次。
        reverseWord(chars, 0, chars.length - 1);

        for (int i = 0, start = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                reverseWord(chars, start, i - 1);
                start = i + 1;
            }
            if (i == chars.length - 1) {
                reverseWord(chars, start, chars.length - 1);
            }
        }
        return new String(chars);
    }

    private void reverseWord(char[] chars, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            swap(chars, i, j);
        }
    }

    private void swap(char[] chars, int i, int j) {
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
    }

}
