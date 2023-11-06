package Test;



public class TestPlay {

    class HashMap<K,V> {
        private static final int DEFAULT_CAPACITY = 16;
        private static final float LOAD_FACTOR = 0.75f;
        ListNode<K,V>[] map;
        private int capacity ;
        private float loadfactor;
        private int size;
        public HashMap(){
            this(DEFAULT_CAPACITY,LOAD_FACTOR);
        }
        public HashMap(int capacity , float loadfactor){
            this.capacity = capacity ;
            this.loadfactor= loadfactor;
            map = new ListNode[capacity];
        }
    }

    class ListNode<K,V> {
       K key ;
       V value;
       private ListNode next;
       private ListNode head ;

       ListNode(K key ,  V value){
           this.value = value;
           this.key = key;
       }
    }

    public static void main(String[] args) {

    }
}
