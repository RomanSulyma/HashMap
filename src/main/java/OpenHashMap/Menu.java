package OpenHashMap;

import java.util.Scanner;

class Menu {

    private final OpenHashMap openHashMap = new OpenHashMap(2);

    /**
     * Recursive call menu to work with map interface (get, put) values
     */
    void getMenu() {

        System.out.println("1 - Get value");
        System.out.println("2 - Put value");

        switch (scanValue()) {
            case 1:
                getValue();
                break;
            case 2:
                putValue();
                break;
            default:
                break;
        }

        getMenu();
    }

    /**
     * Put value to the map
     */
    private void putValue() {

        System.out.println("Enter key");
        final int key = scanValue();

        System.out.println("Enter value");
        final int value = scanValue();

        openHashMap.put(key, value);
    }

    /**
     * Get value from map and print result
     */
    private void getValue() {

        System.out.println("Enter key");
        final int key = scanValue();
        final int result = openHashMap.get(key);

        System.out.println(result);
    }

    private int scanValue() {

        int value = 1;

        try(final Scanner scanner = new Scanner(System.in)) {
            value = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("Invalid value format");
        }

        return value;
    }
}
