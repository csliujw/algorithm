package com.payphone;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Demo {
    static HashMap<String, Integer> wordToIndex = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s1 = reader.readLine();
        String[] zhu = reader.readLine().split(" ");
        String[] wei = reader.readLine().split(" ");
        String[] bin = reader.readLine().split(" ");
        for (String s : zhu) wordToIndex.put(s, 0);
        for (String s : wei) wordToIndex.put(s, 1);
        for (String s : bin) wordToIndex.put(s, 2);
        int count = Integer.parseInt(reader.readLine());
        String[] sentence = new String[count];
        while (count > 0) {
            sentence[5 - count] = reader.readLine();
            count--;
        }
        for (int i = 0; i < sentence.length; i++) {
            String[] s = sentence[i].split(" ");
            if (judge(s)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    private static boolean judge(String[] sen) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < sen.length; i++) {
            int chengfeng = wordToIndex.get(sen[i]); // 查一下是什么句子成分
            int index = map.getOrDefault(chengfeng, -1); // 看是否已经找到一个句子成分
            if (index == -1) {
                map.put(chengfeng, i);// 没有这个成分，则记录成分的位置
            } else if (chengfeng == 1) { //找到了第二个谓语，false
                return false;
            } else if (index == 2) {
                map.put(2, index);// 找到了第二个宾语，更新 index
            }
        }
        Integer zhu = map.get(0);
        Integer wei = map.get(1);
        if (zhu == null || wei == null) return false;
        // 主语谓语都不是 null
        Integer bin = map.get(2);
        if ((zhu < wei && bin == null) || (zhu < wei && wei < bin)) return true;
        return false;
    }
}
