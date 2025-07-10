package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {

    private static final int MAXSIZE = 10;
    private static int maxIndex = 0;

    private Object[] keys = new Object[MAXSIZE];
    private Object[] values = new Object[MAXSIZE];

    {
        maxIndex = 0;
    }

    //public StorageImpl() {
    //}

    @Override
    public void put(K key, V value) {

        if (maxIndex + 1 == MAXSIZE) {
            throw new ArrayIndexOutOfBoundsException("Index out of bounds!");
        }

        if (maxIndex > 0) {
            for (int i = 0; i < maxIndex; i++) {
                if (keys[i] != null && keys[i].equals(key) || (keys[i] == null && key == null)) {
                    values[i] = value;
                    return;
                }
            }
        }

        keys[maxIndex] = key;
        values[maxIndex] = value;

        if (maxIndex + 1 > MAXSIZE) {
            return;
        }
        maxIndex++;

    }

    @Override
    public V get(K key) {

        for (int i = 0; i < maxIndex; i++) {
            if ((keys[i] != null && keys[i].equals(key)) || (keys[i] == null && key == null)) {
                return (V) values[i];
            }
        }

        return null;
    }

    @Override
    public int size() {
        return maxIndex;
    }
}
