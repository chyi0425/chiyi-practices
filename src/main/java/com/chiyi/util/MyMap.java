package com.chiyi.util;



/**
 * @author chiyi
 */
public class MyMap<K,V> {
    // capacity
    private int size;

    // default capacity
    private static int INIT_CAPACITY = 16;

    // the array object to save data
    private Entry<K,V>[] container;

    // the load factor
    private static float LOAD_FACTOR = 0.75f;

    // the max data size
    private int max;

    public MyMap(int initCapacity, float loadFactor){
        if(initCapacity<0){
            throw new IllegalArgumentException("Illegal initial capacity: "+initCapacity);
        }
        if(loadFactor <=0|| Float.isNaN(loadFactor)){
            throw new IllegalArgumentException("Illegal load factor: "+loadFactor);
        }
        LOAD_FACTOR = loadFactor;
        max = (int)(initCapacity*loadFactor);
        container = new Entry[initCapacity];
    }

    public MyMap(){
        this(INIT_CAPACITY,LOAD_FACTOR);
    }

    public boolean put(K k,V v){
        // calc K's hash value
        int hash = k.hashCode();

        Entry<K,V> temp = new Entry(k,v,hash);
        if(setEntry(temp,container)){
            size ++;
            return true;
        }
        return false;
    }

    public V get(K k){
        Entry<K,V> entry = null;
        // calc K's hash code
        int hash = k.hashCode();
        // find index by hash code
        int index = indexFor(hash,container.length);
        // find linked list by index
        entry = container[index];
        // if linked list is null,return null;
        if(entry==null){
            return null;
        }
        // if not null traverse linked list,compare the key,if equals ,return the value
        while(entry!=null){
            if(k == entry.key||entry.key.equals(k)){
                return entry.value;
            }
            entry = entry.next;
        }
        // when end of traverse,and can not find the same key,return null;
        return null;
    }

    /**
     * add temp to hash table(table)
     * judge the temp is exists in table or not
     * if temp is exists return false
     * if added,return true.
     * @param temp
     * @param table
     * @return
     */
    private boolean setEntry(Entry<K, V> temp, Entry<K, V>[] table) {
        // find index by hash code value
        int index = indexFor(temp.hash,table.length);
        // find the element
        Entry<K,V> entry = table[index];
        // if exists
        if(entry !=null){
            // traverse the whole list ,judge equals or not
            while(entry!=null){
                // if address equals and the equals method return true and their value equals
                // do not save , return false
                if((temp.key == entry.getKey()||temp.key.equals(entry.getKey()))&&temp.hash == entry.hash&&(temp.value==entry.value||temp.value.equals(entry.value))){
                    return false;
                } else if(temp.key == entry.key && temp.value!=entry.value){
                    entry.value = temp.value;
                    return true;
                } /* if their key do not equals ,to next key */
                else if(temp.key!=entry.key){
                    // reach the last entry, break
                    if(entry.next==null){
                        break;
                    }
                    entry = entry.next;
                }
            }
            // reach the last,and there is no element's key equals, append this element to tail
            addEntry2Last(entry,temp);
            return true;
        }
        // if not exist ,init
        setFirstEntry(temp,index,table);
        return true;
    }

    private void setFirstEntry(Entry<K, V> temp, int index, Entry<K, V>[] table) {
        // judge the size of container, if bigger than max, reSize container
        if(size > max){
            reSize(container.length*4);
        }
        // not bigger than max , or after reSize,init the element
        table[index] = temp;
        temp.next = null;

    }

    private void reSize(int newSize) {
        // init new array,
        Entry<K,V>[] newTable = new Entry[newSize];
        max = (int)(newSize *LOAD_FACTOR);
        // copy all element,traverse all element ,re save every element
        for(int j=0;j<container.length;j++){
            Entry<K,V> entry = container[j];
            // every element of array is linked list
            while (entry!=null){
                setEntry(entry,newTable);
                entry = entry.next;
            }
        }
        // change the reference
        container = newTable;
    }

    private void addEntry2Last(Entry<K, V> entry, Entry<K, V> temp) {
        if(size > max){
            reSize(container.length*4);
        }
        entry.next = temp;
    }

    /**
     * calc index by hash code and container length
     * @param hashcode
     * @param containerLength
     * @return
     */
    public int indexFor(int hashcode, int containerLength){
        return hashcode & (containerLength -1);
    }

    class Entry<K,V>{
        Entry<K,V> next;
        K key;
        V value;
        int hash;

        Entry(K k,V v,int hash){
            this.key=k;
            this.value = v;
            this.hash = hash;
        }

        public Entry<K, V> getNext() {
            return next;
        }

        public void setNext(Entry<K, V> next) {
            this.next = next;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public int getHash() {
            return hash;
        }

        public void setHash(int hash) {
            this.hash = hash;
        }
    }
}
