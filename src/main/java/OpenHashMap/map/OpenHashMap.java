package OpenHashMap.map;

import java.util.Arrays;

public class OpenHashMap implements AbstractHashMap {

  private static final int MIN_VALUE = Integer.MIN_VALUE; // start value of map
  private static final int HASH_CONST = 15; // const for hashing

  private final int size; // size of map
  private final int[] keys; // array with keys
  private final int[] values; // array with value

  public OpenHashMap(final int size) {

    this.size = size;
    this.keys = new int[size];
    this.values = new int[size];

    Arrays.fill(keys, MIN_VALUE);
  }

  @Override
  public void put(final int key, final int value) {

    for (int i = index(hash(key)); ; i++) {

      if (i == size) {
        i = 0;
      }
      if (keys[i] == MIN_VALUE) {
        keys[i] = key;
      }
      if (keys[i] == key) {
        values[i] = value;
        return;
      }
    }
  }

  @Override
  public int get(final int key) {

    for (int i = index(hash(key)); ; i++) {

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
  public int index(final int hash) {
    return Math.abs(hash) % size;
  }
}
