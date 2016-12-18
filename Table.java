package PracticeTest;

/**
 * Created by ignacioojanguren on 18/12/2016.
 *
 * This class is an Open-addressing Hashing.
 * How it works is by if two elements have the same key, the previous element is being removed from the table.
 * Hashing in average similar to the binary search; however, hashing doesn't have to be sorted.
 *
 *
 */
public class Table<K, E> {

    //ManyItems contains how many elements there are in the table
    private int manyItems;
    //Array that contains the keys of the elements
    private Object[] keys;
    //Array that contains the data for each key
    private Object[] data;
    //Boolean that contains whether the element has been used
    private boolean[] hasBeenUsed;

    public Table(int capacity){
        if (capacity <= 0) throw new IllegalArgumentException("The capacity is negative");
        keys = new Object[capacity];
        data = new Object[capacity];
        hasBeenUsed = new boolean[capacity];
    }

    private int hash(K key){
        return Math.abs(key.hashCode());
    }

    private int nextIndex(int index){
        if(index + 1 == data.length){
            index = 0;
        }else{
            index++;
        }
        return index;
    }

    private int findIndex(K key){
        for(int i = 0; i < manyItems - 1; i++){
            if(key.equals(keys[i])){
                return i;
            }
        }
        return -1;
    }

    public E put(K key, E element){
        int index = findIndex(key);

        if(index != -1){
            E oldElement = (E)data[index];
            data[index] = element;
            manyItems++;
            return oldElement;
        }else if(manyItems < data.length){
            while(keys[index] != null){
                index = nextIndex(index);
            }

            keys[index] = key;
            data[index] = element;
            hasBeenUsed[index] = true;
            manyItems++;

            return null;
        }else{
            throw new IllegalArgumentException("Sorry there is no more space for this new element");
        }
    }

    public E remove(K key){
        int index = findIndex(key);
        E oldElement = null;
        if( index != -1 ){
            oldElement = (E)data[index];
            keys[index] = null;
            data[index] = null;
            manyItems --;
        }
        return oldElement;
    }
}
