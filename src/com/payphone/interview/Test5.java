package com.payphone.interview;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 某高校学校学生的信息保存在文件student.txt中,每个学生的信息占一行.
 * 信息格式为:学生英文名称 学院id 专业id   年级 字段通过空格分隔.
 * 姓名   学院id    专业id    年级
 * moon     10      101     2018
 * lark     11      103     2019
 * chris    10      102     2017
 * label    15      108     2016
 */
public class Test5 {

}

class Student {

    public static void main(String[] args) {
        Student student = new Student("D:\\Code\\Java\\JavaEE\\concurrent\\src\\main\\java\\txbs\\student.txt");
//        student.getMembersOfCollege("10").forEach(System.out::println);
        Pair<String, String> moon = student.getStudentInfo("moon");
        System.out.println(moon);
    }

    private HashMap<String, ArrayList<String>> college = new HashMap<>();
    private HashMap<String, ArrayList<String>> major = new HashMap<>();
    private HashMap<String, ArrayList<String>> grade = new HashMap<>();
    private HashMap<String, Pair<String, String>> studentInfo = new HashMap<>();

    // 输入为文件名称
    public Student(String filename) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(filename)))) {
            String str;

            while ((str = reader.readLine()) != null) {
                if (str.equals(" ")) return;
                String[] array = str.split(" ");
                // arr[0] 姓名
                // arr[1] 学院
                // arr[2] 专业
                // arr[3] 年级
                if (college.containsKey(array[1])) {
                    college.get(array[1]).add(array[0]);
                } else {
                    ArrayList<String> strings = new ArrayList<>();
                    strings.add(array[0]);
                    college.put(array[1], strings);
                }
                if (major.containsKey(array[2])) {
                    major.get(array[2]).add(array[0]);
                } else {
                    ArrayList<String> strings = new ArrayList<>();
                    strings.add(array[0]);
                    major.put(array[1], strings);
                }
                if (grade.containsKey(array[3])) {
                    grade.get(array[1]).add(array[0]);
                } else {
                    ArrayList<String> strings = new ArrayList<>();
                    strings.add(array[0]);
                    grade.put(array[1], strings);
                }
                studentInfo.put(array[0], new Pair<String, String>(array[1], array[2]));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 获取学生所在学院ID和专业ID,请自行定义Pair
    public Pair<String, String> getStudentInfo(String strName) {
        // 时间复杂度为 O(1)
        return studentInfo.get(strName);
    }

    // 获取某学院的所有学生
    public List<String> getMembersOfCollege(String strCollege) {
        return college.get(strCollege);
        // 时间复杂度为 O(1)
    }

    // 获取某专业的所有学生
    public List<String> getMembersOfMajor(String strMajor) {
        // 时间复杂度为 O(1)
        return major.get(strMajor);

    }

    // 获取某个年级的所有学生.
    public List<String> getMembersOfGrade(String strGrade) {
        // 时间复杂度为 O(1)
        return grade.get(strGrade);
    }

    class Pair<T, S> {
        T college;
        S major;

        public Pair(T college, S major) {
            this.college = college;
            this.major = major;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "college=" + college +
                    ", major=" + major +
                    '}';
        }
    }
}