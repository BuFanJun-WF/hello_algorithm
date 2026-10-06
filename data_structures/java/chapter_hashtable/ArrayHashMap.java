package chapter_hashtable;

import node.Pair;

import java.util.ArrayList;
import java.util.List;

/**
 * 基于数组实现的哈希表
 *
 * @Author: wangfan
 * @name: ArrayHashMap
 * @Date: 2026/10/6
 */
public class ArrayHashMap {
    private List<Pair> buckets;

    public ArrayHashMap() {
        buckets = new ArrayList<>();
        for (int i = 0; i < 16; i++)
            buckets.add(null);
    }

    /* 哈希函数 */
    private int hashFunction(int key) {
        return key % 16;
    }

    /* 查询操作 */
    public String get(int key) {
        int index = hashFunction(key);
        Pair pair = buckets.get(index);
        if (pair == null)
            return null;
        return pair.value;
    }

    /* 添加操作 */
    public void put(int key, String val) {
        Pair pair = new Pair(key, val);
        int index = hashFunction(key);
        buckets.set(index, pair);
    }

    /* 删除操作 */
    public void remove(int key) {
        int index = hashFunction(key);
        // 置为 null ，代表删除
        buckets.set(index, null);
    }

    /* 获取所有键值对 */
    public List<Pair> pairSet() {
        List<Pair> pairSet = new ArrayList<>();
        for (Pair pair : buckets) {
            if (pair != null)
                pairSet.add(pair);
        }
        return pairSet;
    }

    /* 获取所有键 */
    public List<Integer> keySet() {
        List<Integer> keySet = new ArrayList<>();
        for (Pair pair : buckets) {
            if (pair != null)
                keySet.add(pair.key);
        }
        return keySet;
    }

    /* 获取所有值 */
    public List<String> valueSet() {
        List<String> valueSet = new ArrayList<>();
        for (Pair pair : buckets) {
            if (pair != null)
                valueSet.add(pair.value);
        }
        return valueSet;
    }

    /* 打印哈希表 */
    public void print() {
        for (Pair kv : pairSet()) {
            System.out.println(kv.key + " -> " + kv.value);
        }
    }
}
