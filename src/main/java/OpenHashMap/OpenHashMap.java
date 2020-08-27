package OpenHashMap;

import java.util.Arrays;

class OpenHashMap {

    private final int MIN_VALUE = Integer.MIN_VALUE;
    private final int size;
    private final int[] keys;
    private final int[] values;

    OpenHashMap(final int size) {

        this.size = size;
        this.keys = new int[this.size];
        this.values = new int[this.size];

        Arrays.fill(keys, MIN_VALUE);
    }


    /**
     * Add key:value pair to map
     *
     * @param key - map key
     * @param value - map value
     */
    void put(final int key, final int value) {

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

    /**
     * Get value from map by key
     *
     * @param key - map key
     * @return - value from map using key
     */
    int get(final int key) {

        for (int i = index(hash(key)); ; i++) {

            if (i == size) {
                i = 0;
            }
            if (keys[i] == MIN_VALUE) {
                throw new RuntimeException("No such key!");
            }
            if (keys[i] == key) {
                return values[i];
            }
        }
    }


    /**
     * Return map hash value using key
     *
     * @param key - map key
     * @return - hash value
     */
    private int hash(final int key) {
        return (key >> 15) ^ key;
    }

    /**
     * Return HEAD element of map using hash method
     *
     * @param hash - map hash from hash method
     * @return - HEAD element of map
     */
    private int index(final int hash) {
        return Math.abs(hash) % size;
    }
}
