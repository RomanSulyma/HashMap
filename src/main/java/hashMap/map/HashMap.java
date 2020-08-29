package hashMap.map;

import java.util.Arrays;

public class HashMap implements AbstractHashMap {

  private static final int MIN_VALUE = Integer.MIN_VALUE; // start value of map
  private static final int HASH_CONST = 15; // const for hashing

  private int size; // size of map
  private int[] keys; // array with keys
  private int[] values; // array with value
  private int currentSize = 0; // current size of array

  public HashMap(final int size) {

    this.size = size;
    this.keys = new int[size];
    this.values = new int[size];

    Arrays.fill(keys, MIN_VALUE);
  }

  @Override
  public void put(final int key, final int value) {

    checkSize();

    for (int i = index(hash(key), size); ; i++) {

      if (i == size) {
        i = 0;
      }
      if (keys[i] == MIN_VALUE) {
        keys[i] = key;
      }
      if (keys[i] == key) {
        values[i] = value;
        currentSize += 1;
        return;
      }
    }
  }

  @Override
  public int get(final int key) {

    for (int i = index(hash(key), size); ; i++) {

      if (i == size) {
        i = 0;
      }
      if (keys[i] == MIN_VALUE) {
        throw new RuntimeException("No value found");
      }
      if (keys[i] == key) {
        return values[i];
      }
    }
  }

  @Override
  public int hash(final int key) {
    return (key >> HASH_CONST) ^ key;
  }

  @Override
  public int index(final int hash, final int size) {
    return Math.abs(hash) % size;
  }

  @Override
  public void checkSize() {
      if (currentSize >= (size / 2)) {

          final int newSize = size * 2; // new array size
          final int[] newKeys = new int[newSize];
          final int[] newValues = new int[newSize];

          Arrays.fill(newKeys, Integer.MIN_VALUE);

          // fill all elements from old to new array with indexes change
          for (int key : keys) {

              final int oldIndex = index(hash(key), size);
              final int newIndex = index(hash(key), newSize);

              newKeys[newIndex] = keys[oldIndex];
              newValues[newIndex] = values[oldIndex];
          }

          keys = newKeys;
          values = newValues;
          size = newSize;
      }
  }

  @Override
  public int getSize() {
      return currentSize;
  }
}














