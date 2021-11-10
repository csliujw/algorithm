package com.payphone.ds.union_set;

/**
 * 并查集代码
 */
public class UnionSet {
    // 查
    int find(int ele, int father[]) {
        if (father[ele] == ele) return ele;
        else father[ele] = find(father[ele], father);
        return 0;
    }

    // 并 合并a b两个组织
    void merger(int a, int b, int father[]) {

    }
}
