package com.payphone.interview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class Test2 {
    // 给定一个关注关系的数组(vecRecords)
    // 请找出一个用户,该用户关注的人数最多.
    // 请找出一个用户,该用户被最多的人关注,方法声明如下
    public Result getTopUser(final List<Record> vecRecords) {
        // 遍历一次. 用HashMap
        HashMap<String, Integer> follow = new HashMap<>();
        HashMap<String, Integer> followed = new HashMap<>();

        for (Record r : vecRecords) {
            // 通过遍历,统计关注和被关注的人数
            // 计算userB的数目 即统计多少人关注了它.
            String userA = r.userA;
            String userB = r.UserB;
            if (followed.containsKey(userB)) {
                followed.put(userB, followed.get(userB) + 1);
            } else {
                followed.put(userB, 1);
            }
            if (follow.containsKey(userA)) {
                follow.put(userA, follow.get(userA) + 1);
            } else {
                follow.put(userA, 1);
            }
        }
        Set<String> followSet = follow.keySet();
        Set<String> followedSet = followed.keySet();
        int followMax = 0;
        int followedMax = 0;
        Result result = new Result();

        for (String str : followSet) {
            if (followMax < follow.get(str)) {
                followMax = follow.get(str);
                result.maxFollow = str;
            }
        }

        for (String str : followedSet) {
            if (followedMax < followed.get(str)) {
                followedMax = followed.get(str);
                result.maxFollowed = str;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Record r1 = new Record("A", "BB");
        Record r2 = new Record("A", "cc");
        Record r3 = new Record("A", "dd");
        Record r4 = new Record("A", "BeeB");
        Record r5 = new Record("A", "ff");
        Record r6 = new Record("BB", "tt");
        Record r7 = new Record("CC", "tt");
        Record r8 = new Record("DD", "tt");
        ArrayList<Record> records = new ArrayList<>();
        records.add(r1);
        records.add(r2);
        records.add(r3);
        records.add(r4);
        records.add(r5);
        records.add(r6);
        records.add(r7);
        records.add(r8);
        Test2 test2 = new Test2();
        Result topUser = test2.getTopUser(records);
        System.out.format("maxFollow= %s\t maxFollowed=%s", topUser.maxFollow, topUser.maxFollowed);
    }
}

class Record {
    // 表示userA关注userB
    String userA;
    String UserB;

    public Record() {
    }

    public Record(String userA, String userB) {
        this.userA = userA;
        this.UserB = userB;
    }
}

class Result {
    // 关注最多的人
    String maxFollow;
    // 被关注最多的人
    String maxFollowed;
}
