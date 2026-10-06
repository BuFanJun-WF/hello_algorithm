package chapter_hashtable;

import node.Pair;

import java.util.ArrayList;
import java.util.List;

/**
 * 解决哈希冲突改良方法：链式地址
 *
 * @Author: wangfan
 * @name: HashMapChaining
 * @Date: 2026/10/6
 */
public class HashMapChaining {
    // 键值对数量
    private int size;
    // 哈希表容量
    private int capacity;
    // 触发扩容的负载因子阈值
    private double loadFactor;
    // 扩容倍数
    private int resizeFactor;
    // 桶数组
    private List<List<Pair>> buckets;

    /* 构造方法 */
    public HashMapChaining() {
        size = 0;
        capacity = 4;
        loadFactor = 2.0 / 3.0;
        resizeFactor = 2;
        buckets = new ArrayList<>(capacity);
        for (int i = 0; i < capacity; i++) {
            buckets.add(new ArrayList<>());
        }
    }

    /* 哈希函数 */
    private int hash(int key) {
        return key % capacity;
    }

    /* 负载因子 */
    private double loadFactor() {
        return (double) size / capacity;
    }

    /* 扩容操作 */
    private void extend() {
        // 暂存原来的哈希表
        List<List<Pair>> oldBuckets = buckets;
        // 初始化扩容后的新哈希表
        capacity *= resizeFactor;
        buckets = new ArrayList<>(capacity);
        for (int i = 0; i < capacity; i++) {
            buckets.add(new ArrayList<>());
        }
        // 将键值对从原哈希表搬运至新哈希表
        for (List<Pair> bucket : oldBuckets) {
            for (Pair pair : bucket) {
                put(pair.key, pair.value);
            }
        }
    }


    /* 查询操作 */
    public String get(int key) {
        int index = hash(key);
        List<Pair> bucket = buckets.get(index);
        for (Pair pair : bucket) {
            if (pair.key == key) {
                return pair.value;
            }
        }
        return null;
    }

    /* 添加操作 */
    public void put(int key, String value) {
        // 当负载因子大于阈值时，执行扩容
        if (loadFactor() > loadFactor) {
            extend();
        }

        int index = hash(key);
        List<Pair> bucket = buckets.get(index);
        // 遍历桶，如果遇到指定的key，则更新对应的value并返回
        for (Pair pair : bucket) {
            if (pair.key == key) {
                pair.value = value;
                return;
            }
        }
        // 如果找不到key，则将键值对添加到尾部
        Pair pair = new Pair(key, value);
        bucket.add(pair);
        size++;
    }

    /* 删除操作 */
    void remove(int key) {
        int index = hash(key);
        List<Pair> bucket = buckets.get(index);
        // 遍历桶，从中删除键值对
        for (Pair pair : bucket) {
            if (pair.key == key) {
                bucket.remove(pair);
                size--;
                break;
            }
        }
    }
}
