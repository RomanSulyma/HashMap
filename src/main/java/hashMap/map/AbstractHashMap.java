package hashMap.map;

/**
 * Abstract interface of map with put, get, and hash methods
 */
public interface AbstractHashMap {

  /**
   * Add key:value pair to map
   *
   * @param key   - map key
   * @param value - map value
   */
  void put(final int key, final int value);

  /**
   * Get value from map by key
   *
   * @param key - map key
   * @return - value from map using key
   */
  int get(final int key);

  /**
   * Return map hash value using key
   *
   * @param key - map key
   * @return - hash value
   */
  int hash(final int key);

  /**
   * Return HEAD element of map using hash method
   *
   * @param hash - map hash from hash method
   * @return - HEAD element of map
   */
  int index(final int hash, final int size);

  /**
   * Check current map size and expand if array is full enough
   */
  void checkSize();

  /**
   * Get current map size
   *
   * @return - map current size
   */
  int getSize();
}
