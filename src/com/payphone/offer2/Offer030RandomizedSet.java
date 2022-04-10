package com.payphone.offer2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Offer030RandomizedSet {
    static class RandomizedSet {
        public static void main(String[] args) {
            RandomizedSet randomizedSet = new RandomizedSet();
            randomizedSet.getRandom();
        }

        ArrayList<Integer> save;
        HashMap<Integer, Integer> numToIndex;
        Random random;

        /**
         * Initialize your data structure here.
         */
        public RandomizedSet() {
            save = new ArrayList<>();
            numToIndex = new HashMap<>();
            random = new Random();
        }

        /**
         * Inserts a value to the set. Returns true if the set did not already contain the specified element.
         */
        public boolean insert(int val) {
            if (numToIndex.containsKey(val)) {
                // 如果包含该元素
                return false;
            }
            numToIndex.put(val, save.size());
            save.add(val);
            return true;
        }

        /**
         * Removes a value from the set. Returns true if the set contained the specified element.
         * 边界条件
         */
        public boolean remove(int val) {
            // 如果包含
            if (numToIndex.containsKey(val)) {
                int index = numToIndex.remove(val);
                numToIndex.put(save.get(save.size() - 1), index);
                numToIndex.remove(val);
                save.set(index, save.get(save.size() - 1));
                save.remove(save.size() - 1);
                return true;
            }
            return false;
        }

        /**
         * Get a random element from the set.
         */
        public int getRandom() {
            int i = random.nextInt(save.size());
            return save.get(i);
        }
    }

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
}
