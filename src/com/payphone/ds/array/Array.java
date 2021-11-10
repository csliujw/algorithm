package com.payphone.ds.array;

public class Array {
    private int[] data;
    // size指向数组中第一个没有元素的位置
    private int size;

    public Array() {
        this(16);
        size = 0;
    }

    public Array(int capacity) {
        data = new int[capacity];
    }


    public void addLast(int element) {
        if (data.length == this.size) throw new IllegalArgumentException("Add last failed");
        data[size++] = element;
    }


    public void addByIndex(int index, int element) {
        if (this.size == data.length) throw new IllegalArgumentException("Add element failed");
        if (index < 0 || index > size) throw new IllegalArgumentException("Add index illegal");
        // 把位置index 及 index后面的元素统统后移
        for (int i = size - 1; i >= index; i--) data[i + 1] = data[i];
        data[index] = element;
        size++;
    }

    // 按index移除元素
    public void remove(int index) {

    }

    // 按元素移除
    public void removeElement(int element) {

    }

    // 移除所有值未element的元素
    public void removeAllElement(int element) {

    }

    // 获得某个索引的元素
    public int get(int index) {
        if (index < 0 || index >= this.size)
            throw new IllegalArgumentException("get failed, index should >0 && index<size");
        return this.data[index];
    }

    // 修改某个索引的数据
    public void set(int index, int element) {
        if (index < 0 || index >= this.size)
            throw new IllegalArgumentException("get failed, index should >0 && index<size");
        this.data[index] = element;
    }

    public int getSize() {
        return this.size;
    }

    // 数组的最大容量
    public int getCapacity() {
        return data.length;
    }

    public void printfAll() {
        System.out.format("size=%d, capacity=%d\n", this.size, data.length);
        for (int i = 0; i < size; i++) {
            System.out.format("%d \t", data[i]);
        }
    }

    public static void main(String[] args) {
        Array array = new Array();
        array.addLast(1);
        array.addLast(2);
        array.addLast(3);
        array.addLast(4);
        array.addByIndex(4, -1);
        array.set(0, 100);
        array.printfAll();
    }
}
