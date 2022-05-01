package com.payphone.guide;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

public class GetMin {
    Stack<Integer> stackData = new Stack<>();
    Stack<Integer> stackMin = new Stack<>();

    // stackMin 存入每步最小的值。
    public void push(int value) {
        if (stackMin.isEmpty() || value <= stackMin.peek()) {
            stackMin.push(value);
        }
        stackData.push(value);
    }

    public int pop() {
        // 如果 stackData 的 pop 值 > stackMin.peek() 则 stackMin 不 pop
        int value = stackData.pop();
        if (value == stackMin.peek()) {
            stackMin.pop();
        }
        return value;
    }

    public int getMin() {
        if (!stackMin.isEmpty()) {
            return stackMin.peek();
        }
        return -1;
    }

    public static void test() {
        Scanner in = new Scanner(System.in);
        int count = Integer.parseInt(in.nextLine());

        GetMin mystack = new GetMin();
        // 注意 hasNext 和 hasNextLine 的区别
        while (count > 0) { // 注意 while 处理多个 case
            String[] op = in.nextLine().split(" ");
            if (op[0].equals("push")) {
                mystack.push(Integer.parseInt(op[1]));
            } else if (op[0].equals("pop")) {
                mystack.pop();
            } else {
                // getMin
                System.out.println(mystack.getMin());
            }
            count--;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int cout = Integer.parseInt(reader.readLine());
        GetMin getMin = new GetMin();
        while (cout > 0) {
            String[] op = reader.readLine().split(" ");
            if (op[0].equals("push")) {
                getMin.push(Integer.parseInt(op[1]));
            } else if (op[0].equals("pop")) {
                getMin.pop();
            } else {
                System.out.println(getMin.getMin());
            }
            cout--;
        }
    }

}

