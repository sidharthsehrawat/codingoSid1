package folder.data_structure_impl;


class HashMap<K, V> {
    private static final int DEFAULT_CAPACITY = 16;
    private static final float LOAD_FACTOR = 0.75f;
    private int capacity;
    private float loadFactor;
    private int size;
    private ListNode<K, V>[] map;

    public HashMap() {
        this(DEFAULT_CAPACITY, LOAD_FACTOR);
    }

    public HashMap(int defaultCapacity, float loadFactor) {
        this.capacity = defaultCapacity;
        this.loadFactor = loadFactor;
        this.map = new ListNode[defaultCapacity];
    }


    private static class ListNode<K, V> {
        K key;
        V value;
        ListNode<K, V> next;

        public ListNode(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private int hash(K key) {
        return key.hashCode() % capacity;
    }

    public void put(K key, V value) {
        int index = hash(key);
        ListNode<K, V> node = map[index];
        while (node != null) {
            if (node.key.equals(key)) {
                node.value = value;
            }
            node = node.next;
        }

        ListNode<K, V> newNode = new ListNode(key, value);
        newNode.next = map[index];
        map[index] = newNode;
        size++;
        if (size > capacity * loadFactor) {
            resize();
        }
    }

    public V get(K key) {
        int index = hash(key);
        ListNode<K, V> node = map[index];
        while (node != null) {
            if (node.key.equals(key)) {
                return node.value;
            }
            node = node.next;
        }
        return null;
    }

    public void remove(K key){
        int index = hash(key);
        ListNode<K, V> node = map[index];
        ListNode<K,V> prev = null;
        while (node!=null){
            if(node.key.equals(key)){
                if(prev == null){
                    map[index] =  node.next;
                }else {
                    prev.next = node.next;
                }
                size--;
                return;
            }
            prev = node;
            node = node.next;
        }
    }

    private void resize() {
        int newCapacity = 2 * capacity;
        ListNode<K, V>[] newMap = new ListNode[newCapacity];
        for (int i = 0; i < capacity; i++) {
            ListNode<K, V> node = map[i];
            while (node != null) {
                int index = hash(node.key);
                node.next = newMap[index];
                newMap[index] = node;
                node = node.next;
            }
            map = newMap;
            capacity = newCapacity;
        }
    }

}


public class HashMapImplementation {
    public static void main(String[] args) {
        HashMap<Integer,String> map = new HashMap<>();
        map.put(1,"Sid");
        map.put(2,"Ash");
        map.put(3,"don");
        map.put(4,"kon");

        /*map.get(1);
        map.remove(1);
        map.put(3,"don");*/
        System.out.println(map);

    }
}