package com.chiyi.foundation.btree;

/**
 * @author chiyi
 * @date 2019/9/10.
 */
public class BTree<K extends Comparable<K>, V> {
    private static final int M = 4; // B树的阶数

    // 根节点
    private Node root;

    // 树的高度
    private int height;

    // 树中键值对的数目
    private int N;

    private static final class Node {
        private int m;  // number of children
        private Entry[] children = new Entry[M];    // the array of children

        // create a node with k children
        private Node(int k) {
            m = k;
        }
    }

    // B-tree节点的元素类型
    private static class Entry {
        private Comparable key;
        private Object val;
        private Node next;  // 指向节点中下一元素

        public Entry(Comparable key, Object val, Node next) {
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }

    public BTree() {
        root = new Node(0);
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int size() {
        return N;
    }

    public int height() {
        return height;
    }

    /**
     * get操作
     *
     * @param key
     * @return
     */
    public V get(K key) {
        if (key == null) {
            throw new NullPointerException("key must not be null");
        }
        return search(root, key, height);
    }

    public void put(K key, V val) {
        if(key == null){
            throw new NullPointerException("key must not be null");
        }
    }

    /**
     * 搜索操作
     *
     * @param x
     * @param key
     * @param ht
     * @return
     */
    private V search(Node x, K key, int ht) {
        Entry[] children = x.children;

        //节点内数组操作，内部遍历
        if (ht == 0) {
            for (int j = 0; j < x.m; j++) {
                if (equals(key, children[j].key)) {
                    return (V) children[j].val;
                }
            }
        }
        // 外部定位
        else {
            for (int j = 0; j < x.m; j++) {
                if (j + 1 == x.m || less(key, children[j + 1].key)) {
                    return search(children[j].next, key, ht - 1);
                }
            }
        }
        return null;
    }

    // 判断两个元素是否相等
    private boolean equals(Comparable k1, Comparable k2) {
        return k1.compareTo(k2) == 0;
    }

    // 判断两个元素的大小
    private boolean less(Comparable k1, Comparable k2) {
        return k1.compareTo(k2) < 0;
    }


}
