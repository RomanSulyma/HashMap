package hashMap;

import hashMap.map.AbstractHashMap;
import hashMap.map.HashMap;
import java.util.Scanner;

class Menu {

  private final AbstractHashMap hashMap = new HashMap(2);
  private final Scanner scanner = new Scanner(System.in);

  /**
   * Call menu to work with map interface (get, put) values
   */
  void getMenu() {

    boolean flag = true;

    while (flag) {

      System.out.println("1 - Get value");
      System.out.println("2 - Put value");
      System.out.println("3 - Get size");
      System.out.println("4 - Exit");

      final int scannedValue = scanValue();

      switch (scannedValue) {
        case 1:
          getValue();
          break;
        case 2:
          putValue();
          break;
        case 3:
          getSize();
          break;
        case 4:
          closeApp();
          flag = false;
          break;
        default:
          break;
      }
    }
  }

  /**
   * Put value to the map
   */
  private void putValue() {

    System.out.println("Enter key");
    final int key = scanValue();

    System.out.println("Enter value");
    final int value = scanValue();

    hashMap.put(key, value);
  }

  /**
   * Get value from map and print result
   */
  private void getValue() {

    System.out.println("Enter key");
    final int key = scanValue();
    final int result = hashMap.get(key);

    System.out.println(result);
  }

  /**
   * Get current size of map
   */
  private void getSize() {
    System.out.println("Current size: " + hashMap.getSize());
  }

  /**
   * Close application
   */
  private void closeApp() {
    scanner.close();
    System.out.println("Good bye ;)");
  }

  /**
   * Scan value from console and return it or default value (1)
   *
   * @return scanned value or default value (1)
   */
  private int scanValue() {

    try {
      return scanner.nextInt();
    } catch (Exception e) {
      throw new RuntimeException("Invalid value format");
    }
  }
}
