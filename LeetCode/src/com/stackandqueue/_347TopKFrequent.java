package com.stackandqueue;

import javafx.util.Pair;

import java.util.*;

/**
 * @Author: renmagical
 * @Date: 2019-03-21 16:05
 * @Description:
 */
public class _347TopKFrequent {

    class PairComparator implements Comparator<Pair<Integer, Integer>> {

        @Override
        public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2) {
            if (o1.getKey() != o2.getKey()) {
                return o1.getKey() - o2.getKey();
            }
            return o1.getValue() - o2.getValue();
        }
    }

    public List<Integer> topKFrequent(int[] nums, int k) {
        if (k < 0){
            throw new IllegalArgumentException("k should be greater than 0.");
        }
        //先将元素的频率统计到一个map中
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            if (freq.containsKey(num)) {
                freq.put(num, freq.get(num) + 1);
            } else {
                freq.put(num, 1);
            }
        }

        if (k > nums.length) {
            throw new IllegalArgumentException("k should be less than the number of unique numbers in nums.");
        }

        //维护一个k个元素的优先队列，每次找出最小的元素，和后面的元素作对比，比最小的元素大就交换
        //Pair中，1：频率  2：元素
        PriorityQueue<Pair<Integer, Integer>> q = new PriorityQueue<>(new PairComparator());
        for (int num : freq.keySet()) {
            int numFreq = freq.get(num);
            if (q.size() == k) {
                if (numFreq > q.peek().getKey()) {
                    q.poll();
                    q.add(new Pair<>(numFreq, num));
                }
            } else {
                q.add(new Pair<>(numFreq, num));
            }
        }

        List<Integer> res = new ArrayList<>();
        while (!q.isEmpty()) {
            res.add(q.poll().getValue());
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {4,1,-1,2,-1,2,3};
        int k = 2;
        List<Integer> res = new _347TopKFrequent().topKFrequent(nums, k);
        System.out.println(res);
    }
}
