package folder.data_structure_impl;

class ArrayList<T> {
    private Object[] list;
    private static final int DEFAULT_CAPACITY = 10;
    private static float LOAD_FACTOR = 0.75f;
    private float loadFactor;
    private int capacity;
    private int size;
    private int ind = 0;

    public ArrayList() {
        this(DEFAULT_CAPACITY, LOAD_FACTOR);
    }

    public ArrayList(int capacity, float loadFactor) {
        this.capacity = capacity;
        this.loadFactor = loadFactor;
        list = new Object[capacity];
    }

    private boolean add(T data) {
        list[ind] = data;
        size++;
        ind = size;
        return true;
    }

    private boolean add(T data, int indexPos) throws Exception {
        int index = indexPos;
        if (index > size) {
            throw new Exception("Illegal list index exception");
        }
        // reshuffling towards right in case of addition at specific position
        // 1 2 3 6 4 5
        int last = size + 1;
        while (last > index) {
            list[last] = list[last - 1];
            last--;
        }
        list[index] = data;
        size++;
        ind = size;
        return true;
    }

    private boolean remove(T data) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (list[i] == data) {
                index = i;
            }
        }
        if (index == -1 || index > size) {
            throw new RuntimeException("index out of bound exeption");
        }
        // reshuffling towards left in case of deletion any element ..
        while (index < size) {
            list[index] = list[index + 1];
            index++;
        }
        size--;
        return true;
    }

    private boolean remove(int index) throws Exception {
        if (index > size || index < 0) {
            throw new Exception("array index out of bound Exception.");
        }
        // reshuffling towards left in case of deletion any element ..
        while (index < size) {
            list[index] = list[index + 1];
            index++;
        }
        size--;
        ind = size;
        return true;
    }

    private void resizing(Object[] list, int capacity){


    }

    private int size() {
        return size;
    }

    private boolean isEmpty() {
        return size == 0;
    }
}

public class ArrayListImplmentation {

}
