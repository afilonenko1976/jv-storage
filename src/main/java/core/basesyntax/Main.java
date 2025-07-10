package core.basesyntax;

import core.basesyntax.impl.StorageImpl;

public class Main {

    public static void main(String[] args) {

        Storage<Integer, Box> storage = new StorageImpl<>();

        Box box1 = new Box();
        storage.put(22, box1);

        Box box2 = new Box();
        storage.put(75, box2);

        Box box100 = new Box();
        storage.put(22, box100);

        Box box3 = new Box();
        storage.put(99, box3);

        Box value = storage.get(22); // returns the Box
        int size = storage.size(); // returns storage size

    }

}
