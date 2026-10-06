package chapter_hashtable;

import node.Pair;

/**
 * 解决哈希冲突改良方法：开放寻址哈希表
 * 线性探测：+1
 * 平方探测：跳过探测次数的平方
 * 多重哈希：使用多个哈希函数
 * @Author: wangfan
 * @name: HashMapOpenAddressing
 * @Date: 2026/10/6
 */
public class HashMapOpenAddressing {
    private int size; // 键值对数量
    private int tombstoneCount; // 删除标记数量
    private int capacity = 4; // 哈希表容量
    private final double loadThres = 2.0 / 3.0; // 触发扩容的负载因子阈值
    private final int extendRatio = 2; // 扩容倍数
    private Pair[] buckets; // 桶数组
    private final Pair TOMBSTONE = new Pair(-1, "-1"); // 删除标记
    /* 构造方法 */
    public HashMapOpenAddressing() {
        size = 0;
        buckets = new Pair[capacity];
    }

    /* 哈希函数 */
    private int hashFunc(int key) {
        return key % capacity;
    }

    /* 负载因子（含删除标记） */
    private double loadFactor() {
        return (double) (size + tombstoneCount) / capacity;
    }

    /* 扩容哈希表 */
    private void extend() {
        // 暂存原哈希表
        Pair[] oldBuckets = buckets;
        // 初始化扩容后的新哈希表
        capacity *= extendRatio;
        buckets = new Pair[capacity];
        // 将原哈希表中的键值对重新插入新哈希表中（重建时丢弃所有删除标记）
        tombstoneCount = 0;
        for (Pair pair : oldBuckets) {
            if (pair != null && pair != TOMBSTONE) {
                put(pair.key, pair.value);
            }
        }
    }

    /* 搜索key对应的桶索引 */
    private int findBucket(int key) {
        int hash = hashFunc(key);
        int firstTombstone = -1;

        // 线性探测，当遇到空桶时跳出
        while (buckets[hash] != null) {
            // 遇到key，返回对应的桶索引
            if (buckets[hash].key == key) {
                // 如果之前遇到了首个删除标记，则将键值对移动到删除标记所在的位置
                if (firstTombstone != -1) {
                    buckets[firstTombstone] = buckets[hash];
                    buckets[hash] = TOMBSTONE;
                    // 返回移动后的桶索引
                    return firstTombstone;
                }
                return hash;
            }
            // 记录遇到的首个删除标记
            if (firstTombstone == -1 && buckets[hash] == TOMBSTONE) {
                firstTombstone = hash;
            }
            // 计算桶索引，越过尾部则返回头部
            hash = (hash + 1) % capacity;
        }
        // 如果key不存在，则返回添加点的索引
        return firstTombstone == -1 ? hash : firstTombstone;
    }

    /* 查询操作 */
    public String get(int key) {
        // 搜索key对应的桶索引
        int index = findBucket(key);
        // 若找到键值对，则返回对应value
        if (buckets[index] != null && buckets[index] != TOMBSTONE) {
            return buckets[index].value;
        }
        // 若键值对不存在，则返回null
        return null;
    }

    /* 添加操作 */
    public void put(int key, String value) {
        // 当负载因子超过阈值时，执行扩容
        if (loadFactor() > loadThres) {
            extend();
        }
        // 搜索key对应的桶索引
        int index = findBucket(key);
        // 若找到键值对，则覆盖value并返回
        if (buckets[index] != null && buckets[index] != TOMBSTONE) {
            buckets[index].value = value;
            return;
        }
        // 若键值对不存在，则添加该键值对（若复用了删除标记的桶，则标记数减一）
        if (buckets[index] == TOMBSTONE) {
            tombstoneCount--;
        }
        buckets[index] = new Pair(key, value);
        size++;
    }

    /* 删除操作 */
    public void remove(int key) {
        // 搜索key对应的桶索引
        int index = findBucket(key);
        // 若找到键值对，则用删除标记覆盖
        if (buckets[index] != null && buckets[index] != TOMBSTONE) {
            buckets[index] = TOMBSTONE;
            size--;
        }
    }
}
